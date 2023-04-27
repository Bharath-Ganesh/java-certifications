package src.com.certifications.javase11.chapter09Collections.project.prod;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ProductManager {


    private Locale locale;
    private ResourceBundle resource;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    // 1. Replace declaration of product and reviews with an instance of HashMap.
    /*
        A product can now store multiple reviews.
     */
    private Map<Product, List<Review>> products=new HashMap<>();


    private Review[] reviews = new Review[5];

    public ProductManager(Locale locale) {
        this.locale = locale;
        resource = ResourceBundle.getBundle("src.com.certifications.javase11.chapter07interfaces.project.prod.resources", locale);
        dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        moneyFormat = NumberFormat.getCurrencyInstance(locale);
    }


    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        Product product = new Food(id, name, price, rating, bestBefore);
        products.putIfAbsent(product,new ArrayList<>());
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        Product product = new Drink(id, name, price, rating);
        products.putIfAbsent(product,new ArrayList<>());
        return product;
    }

    public Product reviewProduct(int id, Rating rating, String comments) {
        return reviewProduct(findProduct(id),rating,comments);
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {

        List<Review> reviews=products.get(product);
        // remove the entire entry from the app and update the list with the new review
        products.remove(product);
        reviews.add(new Review(rating, comments));

        int sum=0;
        // Update the while loop with forEachLoop
        for(Review review : reviews){
            sum+=review.getRating().ordinal();
        }
        //update the product rating with the average value
        product = product.applyRating(Rateable.convert(Math.round((float) sum / reviews.size())));
        products.put(product,reviews);
        return product;
    }

    public Product findProduct(int id){
        Product result=null;
        for (Product product : products.keySet()){
            if(product.getId()==id){
                result=product;
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
        List<Review> reviews=products.get(product);
        Collections.sort(reviews);

        text.append(MessageFormat.format(resource.getString("product"),
            product.getName(),
            moneyFormat.format(product.getPrice()),
            product.getRating().getStars(),
            dateFormat.format(product.getBestBefore())));
        text.append("\n");
        for (Review review : reviews) {
            text.append(MessageFormat.format(resource.getString("review"),
                review.getRating().getStars(),
                review.getComments()));
            text.append("\n");
        }

        if(reviews.isEmpty()){
            text.append(resource.getString("no.reviews"));
            text.append("\n");
        }

        System.out.println(text);
    }
}
