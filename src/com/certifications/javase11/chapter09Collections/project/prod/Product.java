package src.com.certifications.javase11.chapter09Collections.project.prod;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Product implements Rateable<Product> {


    public final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private final int id;
    private final String name;
    private final BigDecimal price;
    private Rating rating;

    Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }


    Product() {
        this(0, "no name", BigDecimal.valueOf(0));
    }

    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
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


    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", " + getDiscount() + ", " + rating.getStars() + ", " + getBestBefore();
    }

    //10. Update the equals' method in Product class.
    /*
    As we're comparing using the product Id, remove the name from the equal comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if(o instanceof Product){
            Product product = (Product) o;
            return id == product.id;
        }
        return false;

    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public LocalDate getBestBefore() {
        return LocalDate.now();
    }
}
