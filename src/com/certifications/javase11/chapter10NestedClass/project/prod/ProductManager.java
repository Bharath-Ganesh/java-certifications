package src.com.certifications.javase11.chapter10NestedClass.project.prod;

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

public class ProductManager {



    private static class ResourceFormatter {
        private Locale locale;
        private ResourceBundle resource;
        private DateTimeFormatter dateFormat;
        private NumberFormat moneyFormat;

        // The local as an argument
        // You make the constructor private because, it can be accessed by the outer class.
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

    // 4. Add formatter to the ProductManager which represents the selected Formatter.
    private ResourceFormatter formatter;

    // 3. Map of ResourceFormatters representing different locale.
    private static Map<String, ResourceFormatter> formatters =
        Map.of("en-GB", new ResourceFormatter(Locale.UK),
        "en-US", new ResourceFormatter(Locale.US),
        "fr-FR", new ResourceFormatter(Locale.FRANCE),
        "ru-RU", new ResourceFormatter(new Locale("ru","RU")),
        "zh-CN", new ResourceFormatter(Locale.CHINA));

    public ProductManager(Locale locale) {
        this(locale.toLanguageTag());
    }

    public ProductManager(String languageTag) {
        changeLocale(languageTag);
    }

    public void changeLocale(String languageTag){
        formatter=formatters.getOrDefault(languageTag,formatters.get("en-GB"));
    }

    // A method that would give the supported set of locales.
    public static Set<String> getSupportedLocales(String languageTag){
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

    public Product reviewProduct(Product product, Rating rating, String comments) {

        List<Review> reviews = products.get(product);
        // remove the entire entry from the app and update the list with the new review
        products.remove(product);
        reviews.add(new Review(rating, comments));

        int sum = 0;
        // Update the while loop with forEachLoop
        for (Review review : reviews) {
            sum += review.getRating()
                .ordinal();
        }
        //update the product rating with the average value
        product = product.applyRating(Rateable.convert(Math.round((float) sum / reviews.size())));
        products.put(product, reviews);
        return product;
    }

    public Product findProduct(int id) {
        Product result = null;
        for (Product product : products.keySet()) {
            if (product.getId() == id) {
                result = product;
                break;
            }
        }
        return result;
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
        for (Review review : reviews) {
            text.append(formatter.formatReview(review));
            text.append("\n");
        }

        if (reviews.isEmpty()) {
            text.append(formatter.getText("no.reviews"));
            text.append("\n");
        }

        System.out.println(text);
    }

    public void printProducts(Comparator<Product> sorter){
        List<Product> productList=new ArrayList<>(products.keySet());
        Collections.sort(productList,sorter);
        StringBuilder text=new StringBuilder();
        for(Product product: productList){
            text.append(formatter.formatProduct(product));
            text.append("\n");
        }
        System.out.println(text);

    }
}
