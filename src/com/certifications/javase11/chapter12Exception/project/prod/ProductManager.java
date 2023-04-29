package src.com.certifications.javase11.chapter12Exception.project.prod;

import java.math.BigDecimal;
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
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProductManager {

    private static final Logger logger = Logger.getLogger(ProductManager.class.getName());

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

    private ResourceBundle config = ResourceBundle.getBundle("src.com.certifications.javase11.chapter12Exception.project.prod.config");
    private Map<Product, List<Review>> products = new HashMap<>();
    private Review[] reviews = new Review[5];
    private ResourceFormatter formatter;
    private static Map<String, ResourceFormatter> formatters = Map.of("en-GB", new ResourceFormatter(Locale.UK), "en-US", new ResourceFormatter(Locale.US), "fr-FR", new ResourceFormatter(Locale.FRANCE), "ru-RU", new ResourceFormatter(new Locale("ru", "RU")),
        "zh-CN", new ResourceFormatter(Locale.CHINA));

    private MessageFormat reviewFormat = new MessageFormat(config.getString("review.data.format"));
    private MessageFormat productFormat = new MessageFormat(config.getString("product.data.format"));

    public void parseReview(String text) {
        try {
            Object[] values = reviewFormat.parse(text);
            int id = Integer.parseInt((String) values[0]);
            Rating rating = Rateable.convert(Integer.parseInt((String) values[1]));
            String comment = ((String) values[2]);
            reviewProduct(id, rating, comment);
        } catch (ParseException | NumberFormatException ex) {
            logger.log(Level.WARNING, "Error parsing reviw " + text, ex.getMessage());
        }
    }

    public void parseProduct(String text) {
        try {
            Object[] values = productFormat.parse(text);

            String type = ((String) values[0]);
            int id = Integer.parseInt((String) values[1]);
            String productName = ((String) values[2]);
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble((String) values[3]));
            Rating rating = Rateable.convert(Integer.parseInt((String) values[4]));
            switch (type) {
            case "D":
                createProduct(id, productName, price, rating);
                break;
            case "F":
                LocalDate localDate = LocalDate.parse(((String) values[5]));
                createProduct(id, productName, price, rating, localDate);
            }
        } catch (ParseException | NumberFormatException | DateTimeException ex) {
            logger.log(Level.WARNING, "Error parsing product " + text, ex.getMessage());
        }
    }

    public ProductManager(Locale locale) {
        this(locale.toLanguageTag());
    }

    public ProductManager(String languageTag) {
        changeLocale(languageTag);
    }

    public void changeLocale(String languageTag) {
        formatter = formatters.getOrDefault(languageTag, formatters.get("en-GB"));
    }

    public static Set<String> getSupportedLocales(String languageTag) {
        return formatters.keySet();
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        Product product = new Food(id, name, price, rating, bestBefore);
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        Product product = new Drink(id, name, price, rating);
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product reviewProduct(int id, Rating rating, String comments) {
        try {
            return reviewProduct(findProduct(id), rating, comments);
        } catch (ProductManagerException ex) {
            logger.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

    public Map<String, String> getDiscounts() {

        return products.keySet()
            .stream()
            .collect(Collectors.groupingBy(product -> product.getRating()
                .getStars(), Collectors.collectingAndThen(Collectors.summingDouble(product -> product.getDiscount()
                .doubleValue()), discount -> formatter.moneyFormat.format(discount))));
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {

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
        //2. Replace the ElseGet of the findProduct() to get().
        /*
        The get() method would throw NoSuchElementException if there is no product found.
         */
        return products.keySet()
            .stream()
            .filter(product -> product.getId() == id)
            .findFirst()
            //4. Modify the findProduct() to throw the ProductManagerException.
            /*
            This is Checked Exception, hence needs to be caught or thrown from here.
             */
            .orElseThrow(() -> new ProductManagerException("Product with Id " + id + " not found"));
    }

    public void printProductReport(int id) {
        try {
            printProductReport(findProduct(id));
        } catch (ProductManagerException ex) {
            logger.log(Level.INFO, ex.getMessage());
        }
    }

    public void printProductReport(Product product) {
        StringBuilder text = new StringBuilder();
        List<Review> reviews = products.get(product);
        Collections.sort(reviews);

        text.append(formatter.formatProduct(product));
        text.append("\n");
        if (reviews.isEmpty()) {
            text.append(formatter.getText("no.reviews"));
            text.append("\n");
        } else {
            //reviews.stream().forEach(review -> text.append(formatter.formatReview(review) + "\n"));
            text.append(reviews.stream()
                .map(review -> formatter.formatReview(review) + '\n')
                .collect(Collectors.joining()));
        }

        System.out.println(text);
    }

    public void printProducts(Comparator<Product> sorter) {
        printProducts(sorter, product -> true);
    }

    public void printProducts(Comparator<Product> sorter, Predicate<Product> filter) {

        StringBuilder text = new StringBuilder();
        products.keySet()
            .stream()
            .sorted(sorter)
            .filter(filter)
            .forEach(product -> text.append(formatter.formatProduct(product) + "\n"));

        System.out.println(text);

    }
}
