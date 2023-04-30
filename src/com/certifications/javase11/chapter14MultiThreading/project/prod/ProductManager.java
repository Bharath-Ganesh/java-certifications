package src.com.certifications.javase11.chapter14MultiThreading.project.prod;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProductManager {

    private static final Logger logger = Logger.getLogger(ProductManager.class.getName());

    private Map<Product, List<Review>> products = new HashMap<>();
    private Review[] reviews = new Review[5];

    // 1.  We have to decouple ResourceFormatter one-one mapping with ProductManager.
    // private ResourceFormatter formatter;
    private final ResourceBundle config = ResourceBundle.getBundle("src.com.certifications.javase11.chapter14MultiThreading.project.prod.config");
    private final static Map<String, ResourceFormatter> formatters = Map.of("en-GB", new ResourceFormatter(Locale.UK), "en-US", new ResourceFormatter(Locale.US), "fr-FR", new ResourceFormatter(Locale.FRANCE), "ru-RU",
        new ResourceFormatter(new Locale("ru", "RU")), "zh-CN", new ResourceFormatter(Locale.CHINA));

    private final MessageFormat reviewFormat = new MessageFormat(config.getString("review.data.format"));
    private final MessageFormat productFormat = new MessageFormat(config.getString("product.data.format"));

    private final Path reportsFolder = Path.of(config.getString("reports.folder"));
    private final Path dataFolder = Path.of(config.getString("data.folder"));
    private final Path tempFolder = Path.of(config.getString("temp.folder"));

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // Any operation that requires write access must use writeLock
    // loadAllData(), loadProduct(), loadReview(), restoreData(), and createProduct()
    private final Lock writeLock = lock.writeLock();

    // Any operation that requires write access must use read
    // findProduct(), getDiscounts(), printProducts(), dumpData() and printProductReport()
    private final Lock readLock = lock.writeLock();

    private static final ProductManager pm = new ProductManager();

    //    public ProductManager(Locale locale) {
    //        this(locale.toLanguageTag());
    //    }

    public static ProductManager getInstance() {
        return pm;
    }

    private ProductManager() {
        //changeLocale(languageTag);
        loadAllData();
    }

    public void dumpData() {
        try {
            if (Files.notExists(tempFolder)) {
                Files.createDirectories(tempFolder);
            }
            Path tempFile = tempFolder.resolve(MessageFormat.format(config.getString("temp.file"), LocalDate.now()
                .toString()));
            try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(tempFile, StandardOpenOption.CREATE))) {
                out.writeObject(tempFile);
                products = new HashMap<>();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error dumping data " + ex.getMessage(), ex);
        }
    }

    public void restoreData() {
        try {
            Path tempFile = Files.list(tempFolder)
                .filter(file -> file.getFileName()
                    .toString()
                    .endsWith("tmp"))
                .findFirst()
                .orElseThrow();

            try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(tempFile, StandardOpenOption.READ))) {
                products = (HashMap) in.readObject();
            }
        } catch (Exception ex) {
            // ClassNotFoundException to indicate serialized version of code does not match
            // NoSuchElementException to indicate no temp file was found
            logger.log(Level.SEVERE, "Error restoring data " + ex.getMessage(), ex);
        }
    }

    // 7. Modify parseReview().
    /*
    Return a single review instead of adding to the map.
     */
    private Review parseReview(String text) {
        Review review = null;
        try {
            text = text.replaceAll("^\"|\"$", "");
            Object[] values = reviewFormat.parse(text);
            Rating rating = Rateable.convert(Integer.parseInt((String) values[0]));
            String comment = ((String) values[1]);
            review = new Review(rating, comment);
        } catch (ParseException | NumberFormatException ex) {
            logger.log(Level.WARNING, "Error parsing review " + text, ex.getMessage());
        }
        return review;
    }

    private Product parseProduct(String text) {
        Product product = null;
        try {
            text = text.replaceAll("^\"|\"$", "");
            Object[] values = productFormat.parse(text);
            String type = ((String) values[0]);
            int id = Integer.parseInt((String) values[1]);
            String productName = ((String) values[2]);
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble((String) values[3]));
            Rating rating = Rateable.convert(Integer.parseInt((String) values[4]));
            switch (type) {
            case "D":
                product = new Drink(id, productName, price, rating);
                break;
            case "F":
                LocalDate localDate = LocalDate.parse(((String) values[5]));
                product = new Food(id, productName, price, rating, localDate);
            }
        } catch (ParseException | NumberFormatException | DateTimeException ex) {
            logger.log(Level.WARNING, "Error parsing product " + text, ex.getMessage());
        }
        return product;
    }

    private void loadAllData() {
        /*
        This method would load all the product files from the data folder, and each for each product,
        it will store the value in the products hashmap, against a particular product and list of reviews.
         */
        try {
            products = Files.list(dataFolder)
                .filter(file -> file.getFileName()
                    .toString()
                    .startsWith("product"))
                .map(file -> loadProduct(file))
                .filter(product -> product != null)
                .collect(Collectors.toMap(product -> product, product -> loadReviews(product)));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading data " + e.getMessage(), e);
        }
    }

    private Product loadProduct(Path file) {
        Product product = null;
        try {
            product = parseProduct(Files.lines(dataFolder.resolve(file), Charset.forName("UTF-8"))
                .findFirst()
                .orElseThrow());
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error loading product " + e.getMessage());
        }
        return product;
    }

    private List<Review> loadReviews(Product product) {
        List<Review> reviews = null;
        Path file = dataFolder.resolve(MessageFormat.format(config.getString("reviews.data.file"), product.getId()));
        if (Files.notExists(file)) {
            // Not all files would have the reviews
            reviews = new ArrayList<>();
        } else {
            try {
                reviews = Files.lines(file, Charset.forName("UTF-8"))
                    .map(txtReview -> parseReview(txtReview))
                    .filter(review -> review != null)
                    .collect(Collectors.toList());
            } catch (IOException e) {
                logger.log(Level.WARNING, "Error loading reviews " + e.getMessage());
            }
        }
        return reviews;
    }

    // public void changeLocale(String languageTag) {
    //  formatter = formatters.getOrDefault(languageTag, formatters.get("en-GB"));
    //  }

    public static Set<String> getSupportedLocales() {
        return formatters.keySet();
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        Product product = null;
        try {
            writeLock.lock();
            product = new Food(id, name, price, rating, bestBefore);
            products.putIfAbsent(product, new ArrayList<>());
        } catch (Exception ex) {
            logger.log(Level.INFO, "Error adding product" + ex.getMessage());
            return null;
        } finally {
            writeLock.unlock();
        }
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        Product product = null;
        try {
            writeLock.lock();
            product = new Drink(id, name, price, rating);
            products.putIfAbsent(product, new ArrayList<>());
        } catch (Exception ex) {
            logger.log(Level.INFO, "Error adding product" + ex.getMessage());
            // It might be possible that object might be created, but not added to map.
            // Hence to clear the reference we return null;
            return null;
        } finally {
            writeLock.unlock();
        }
        return product;
    }

    // 8. Change Map to ConcurrentHashMap.
    /*
        1. This won't work because it's doing both removal and addition of Product to the Map.
        ConcurrentHashMap ensures thread safe only when there is either of the operation alone.
        2. Making method synchronised, but there is a performance degradation.
        3. Read lock to all operation that read from the map, and write lock to all operation that modifies the map.
     */
    public Product reviewProduct(int id, Rating rating, String comments) {
        try {
            writeLock.lock();
            return reviewProduct(findProduct(id), rating, comments);
        } catch (ProductManagerException ex) {
            logger.log(Level.INFO, ex.getMessage());
        } finally {
            writeLock.unlock();
        }
        return null;
    }

    public Map<String, String> getDiscounts(String language) {
        try {
            readLock.lock();
            ResourceFormatter formatter = formatters.getOrDefault(language, formatters.get("en-GB"));
            return products.keySet()
                .stream()
                .collect(Collectors.groupingBy(product -> product.getRating()
                    .getStars(), Collectors.collectingAndThen(Collectors.summingDouble(product -> product.getDiscount()
                    .doubleValue()), discount -> formatter.moneyFormat.format(discount))));
        } finally {
            readLock.unlock();
        }

    }

    // Make this private, as it need not be accessed from outside.
    private Product reviewProduct(Product product, Rating rating, String comments) {

        List<Review> reviews = products.get(product);
        // remove the entire entry from the app and update the list with the new review
        products.remove(product);
        reviews.add(new Review(rating, comments));
        product = product.applyRating(Rateable.convert((int) Math.round(reviews.stream()
            .mapToInt(review -> review.getRating()
                .ordinal())
            .average()
            .orElse(0))));

        products.put(product, reviews);
        return product;
    }

    public Product findProduct(int id) throws ProductManagerException {
        try {
            readLock.lock();
            return products.keySet()
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductManagerException("Product with Id " + id + " not found"));
        } finally {
            readLock.unlock();
        }

    }

    // In this method, when concurrent invokers tries to write to the same file.
    // This will create a clash. Hence add an parameter to make each thread unique
    public void printProductReport(int id, String language, String client) {
        try {
            readLock.lock();
            printProductReport(findProduct(id), language, client);
        } catch (ProductManagerException ex) {
            logger.log(Level.INFO, ex.getMessage());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error printing product report" + ex.getMessage(), ex);
        } finally {
            readLock.unlock();
        }
    }

    private void printProductReport(Product product, String language, String client) throws IOException {
        // 4. Path represents where the Product report will be written.
        List<Review> reviews = products.get(product);
        Collections.sort(reviews);
        ResourceFormatter formatter = formatters.getOrDefault(language, formatters.get("en-GB"));

        Path productFile = reportsFolder.resolve(MessageFormat.format(config.getString("report.file"), product.getId(), client));
        try (PrintWriter out = new PrintWriter(new OutputStreamWriter(Files.newOutputStream(productFile, StandardOpenOption.CREATE), "UTF-8"))) {
            //System.lineSeparator() Provide platform specific line separator.
            out.append(formatter.formatProduct(product) + System.lineSeparator());
            if (reviews.isEmpty()) {
                out.append(formatter.getText("no.reviews") + System.lineSeparator());
            } else {
                //reviews.stream().forEach(review -> text.append(formatter.formatReview(review) + "\n"));
                out.append(reviews.stream()
                    .map(review -> formatter.formatReview(review) + System.lineSeparator())
                    .collect(Collectors.joining()));
            }
        }
    }

    public void printProducts(Comparator<Product> sorter, String languageTag) {
        printProducts(sorter, product -> true, languageTag);
    }

    private void printProducts(Comparator<Product> sorter, Predicate<Product> filter, String languageTag) {
        try {
            readLock.lock();
            ResourceFormatter formatter = formatters.getOrDefault(languageTag, formatters.get("en-GB"));
            StringBuilder text = new StringBuilder();
            products.keySet()
                .stream()
                .sorted(sorter)
                .filter(filter)
                .forEach(product -> text.append(formatter.formatProduct(product) + "\n"));
            System.out.println(text);
        } finally {
            readLock.unlock();
        }
    }

    private static class ResourceFormatter {
        private Locale locale;
        private ResourceBundle resource;
        private DateTimeFormatter dateFormat;
        private NumberFormat moneyFormat;

        private ResourceFormatter(Locale locale) {
            this.locale = locale;
            resource = ResourceBundle.getBundle("src.com.certifications.javase11.chapter07interfaces.project.prod.resources", locale);
            dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                .localizedBy(locale);
            moneyFormat = NumberFormat.getCurrencyInstance(locale);
        }

        private String formatProduct(Product product) {
            return MessageFormat.format(resource.getString("product"), product.getName(), moneyFormat.format(product.getPrice()), product.getRating()
                .getStars(), dateFormat.format(product.getBestBefore()));
        }

        private String formatReview(Review review) {
            return MessageFormat.format(resource.getString("review"), review.getRating()
                .getStars(), review.getComments());
        }

        private String getText(String key) {
            return resource.getString(key);
        }
    }
}
