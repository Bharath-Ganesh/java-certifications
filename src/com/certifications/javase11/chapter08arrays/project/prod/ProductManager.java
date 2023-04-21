package src.com.certifications.javase11.chapter08arrays.project.prod;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {


    private Locale locale;
    private ResourceBundle resource;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    private Product product;
    //1. Update ProductManager review instance to be an array.
    /*
    Now for a particular Product, we can take many reviews
     */
    private Review[] reviews = new Review[5];

    public ProductManager(Locale locale) {
        this.locale = locale;
        resource = ResourceBundle.getBundle("src.com.certifications.javase11.chapter07interfaces.project.prod.resources", locale);
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
        // 2. Update reviewProduct().
        /*
        Arrays.copyOf() method will copy the existing array into a new array of larger length
         */
        if (reviews[reviews.length - 1] != null) {
            reviews=Arrays.copyOf(reviews, reviews.length + 5);
        }
        int sum = 0, i = 0;
        //The var indicates whether the review has been added to the list.

        boolean reviewedSet = false;

        while (i < reviews.length && !reviewedSet) {
            if (reviews[i] == null) {
                reviews[i] = new Review(rating, comments);
                reviewedSet = true;
            }
            sum += reviews[i].getRating().ordinal();
            i++;
        }
        //update the product rating with the average value
        this.product = product.applyRating(Rateable.convert(Math.round((float) sum / i)));
        return this.product;
    }

    public void printProductReport() {
        StringBuilder text = new StringBuilder();
        text.append(MessageFormat.format(resource.getString("product"),
                product.getName(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())));
        text.append("\n");
        for (Review review : reviews) {
            if (review == null) {
                break;
            }
            text.append(MessageFormat.format(resource.getString("review"),
                    review.getRating().getStars(),
                    review.getComments()));
            text.append("\n");
        }

        if(reviews[0]==null){
            text.append(resource.getString("no.reviews"));
            text.append("\n");
        }

        System.out.println(text);
    }
}
