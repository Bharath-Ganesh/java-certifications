package src.com.certifications.javase11.chapter11streams.project.prod;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
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
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductManager {

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

    private Map<Product, List<Review>> products = new HashMap<>();
    private Review[] reviews = new Review[5];

    private ResourceFormatter formatter;

    private static Map<String, ResourceFormatter> formatters = Map.of("en-GB", new ResourceFormatter(Locale.UK), "en-US", new ResourceFormatter(Locale.US), "fr-FR", new ResourceFormatter(Locale.FRANCE), "ru-RU", new ResourceFormatter(new Locale("ru", "RU")),
        "zh-CN", new ResourceFormatter(Locale.CHINA));

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
        return reviewProduct(findProduct(id), rating, comments);
    }

    //5. Add getDiscounts() to the ProductManager, to calculate a sum discount value for products having same rating.
    public Map<String, String> getDiscounts() {

        /*
            collect() : To assemble your calculation result into a Map.
            You need to pass two parameters to this collect operation.
            1. Grouping collector to create a map entry per each rating
            2. Formatting of the total discount for each rating

            Collectors.groupingBy() : To group discount values by rating


            Collectors.summingDouble() : To perform discount calculation extracting each product discount as Double value

            Collectors.collectingAndThen() : Formatted value of the total discount per rating
            You need to pass two parameters to this collect operation.
            1. The sum discount calculation
            2. Format the discount value

         */
        return products.keySet()
            .stream()
            .collect(
                Collectors.groupingBy(
                    product -> product.getRating().getStars(),
                    Collectors.collectingAndThen(
                        Collectors.summingDouble(product -> product.getDiscount().doubleValue()),
                        discount -> formatter.moneyFormat.format(discount))));
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {

        List<Review> reviews = products.get(product);
        // remove the entire entry from the app and update the list with the new review
        products.remove(product);
        reviews.add(new Review(rating, comments));

        //        int sum = 0;
        //        // Update the while loop with forEachLoop
        //        for (Review review : reviews) {
        //            sum += review.getRating()
        //                .ordinal();
        //        }
        //        //update the product rating with the average value
        //        product = product.applyRating(Rateable.convert(Math.round((float) sum / reviews.size())));

        //2. Modify reviewProduct() of the ProductManager class.
        /*
        mapToInt() : Convert each Review object into an int value of Rating.

       ToIntFunction<Review> mapToInt=new ToIntFunction<Review>() {
            @Override
            public int applyAsInt(Review review) {
                return review.getRating()
                    .ordinal();
            }
        };
           average() : Returns an optional double
         */

        product = product.applyRating(Rateable.convert((int) Math.round(reviews.stream()
            .mapToInt(review -> review.getRating()
                .ordinal())
            .average()
            .orElse(0))));

        products.put(product, reviews);
        return product;
    }

    public Product findProduct(int id) {
        //        Product result = null;
        //        for (Product product : products.keySet()) {
        //            if (product.getId() == id) {
        //                result = product;
        //                break;
        //            }
        //        }
        //
        //

        //1. Modify ProductManager, findProduct() to use streams.
        /*
            filter to look for object with same id
            findFirst(), to find the first element that matches the predicate, and it returns an optional object
            orElseGet(): To get this product from the optional object or null.
         */
        return products.keySet()
            .stream()
            .filter(product -> product.getId() == id)
            .findFirst()
            .orElseGet(() -> null);
    }

    public void printProductReport(int id) {
        printProductReport(findProduct(id));
    }

    public void printProductReport(Product product) {
        StringBuilder text = new StringBuilder();
        List<Review> reviews = products.get(product);
        Collections.sort(reviews);

        text.append(formatter.formatProduct(product));
        text.append("\n");
        //        for (Review review : reviews) {
        //            text.append(formatter.formatReview(review));
        //            text.append("\n");
        //        }
        //
        //        if (reviews.isEmpty()) {
        //            text.append(formatter.getText("no.reviews"));
        //            text.append("\n");
        //        }

        //3. Modify printProductReport() of the ProductManager class.
        /*
            map : Method to convert each Review object into a String
            Collectors.joining() to assemble formatted lines together.
         */

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
        //        List<Product> productList = new ArrayList<>(products.keySet());
        //        Collections.sort(productList, sorter);
        //        StringBuilder text = new StringBuilder();
        //        for (Product product : productList) {
        //            text.append(formatter.formatProduct(product));
        //            text.append("\n");
        //        }
        //        System.out.println(text);

        StringBuilder text = new StringBuilder();
        products.keySet()
            .stream()
            .sorted(sorter)
            .filter(filter)
            .forEach(product -> text.append(formatter.formatProduct(product) + "\n"));

        System.out.println(text);

    }
}
