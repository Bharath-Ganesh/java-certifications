package src.com.certifications.javase11.chapter07interfaces.project.prod;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {

    //2. Modify ProductManager class to enable to store information about a Product and a review.
    /*
        At this point the ProductManager class would store information about a Product and a Review
     */


    //13. Add instance variable to the ProductManager class to print the Product report.
    /*
     All the implementation classes actually override the toString() to print the report.
     But this is not end-user friendly, as we're hardcoding the format in our java code and we can't make use of different locale
     so as print the product report.
     */

    private Locale locale;
    private ResourceBundle resource;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    private Product product;
    private Review review;

    public ProductManager(Locale locale) {
        this.locale = locale;
        resource = ResourceBundle.getBundle("src.com.certifications.javase11.chapter07interfaces.project.prod.resources",locale);
        dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        moneyFormat = NumberFormat.getCurrencyInstance(locale);
    }


    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        product = new Food(id, name, price, rating, bestBefore);
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        product = new Drink(id, name, price, rating);
        return product;
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {
        review = new Review(rating, comments);
        this.product = product.applyRating(rating);
        return this.product;
    }

    public void printProductReport(){
        StringBuilder text =new StringBuilder();
        text.append(MessageFormat.format(resource.getString("product"),
                product.getName(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())));
        text.append("\n");
        if(review!=null){
            text.append(MessageFormat.format(resource.getString("review"),
                    review.getRating().getStars(),
                    review.getComments()));

        }else{
            text.append(resource.getString("no.reviews"));
        }

        text.append("\n");

        System.out.println(text);
    }
}
