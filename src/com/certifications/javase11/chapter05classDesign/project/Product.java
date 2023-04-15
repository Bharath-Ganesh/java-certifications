package src.com.certifications.javase11.chapter05classDesign.project;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Product {

    /**
     * final keywords has to be initialized at runtime or in all the constructors
     */
    public final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private final int id;
    private final String name;
    private final BigDecimal price;

    private Rating rating;

    // 1. The default no args constructor is not available in the product class
    // as we have declared custom constructor

    // 2. It's called constructor overloading. Two constructor
    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    // 3. explicitly add the no args constructor
    public Product() {
        this(0, "no name", BigDecimal.valueOf(0));
    }

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_DOWN);
    }

    /**
     * This method will create a replica of an object with an updated rating
     * @param newRating
     * @return
     */
    public Product applyRating(Rating newRating){
        return new Product(this.id,this.name,this.price,newRating);
    }
}
