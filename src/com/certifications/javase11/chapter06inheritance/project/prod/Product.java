package src.com.certifications.javase11.chapter06inheritance.project.prod;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;


public abstract class Product {

    /**
     * final keywords has to be initialized at runtime or in all the constructors
     */
    public final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private final int id;
    private final String name;
    private final BigDecimal price;

    private Rating rating;



    Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    // 2. Temporarily comment the no-args constructor of Product class.
    Product() {
        this(0, "no name", BigDecimal.valueOf(0));
    }

    Product(int id, String name, BigDecimal price, Rating rating) {
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
    //15. Fix applyRating() of the product class.
    /*
    The apply rating returns an instance of Product, not specifically of Drink or Food class.
    To fix this issue, Product class needs to treat this operation as something that needs to implemented by it's subtypes.
    Solution: Make this an abstract method, which in-turn would ask you to make the Product class also abstract.
    The abstract method cannot have implementation.
    The concrete classes or the implementation classes have to override the abstract method.
     */
    public abstract Product applyRating(Rating newRating);

    //8. Create toString() method in the Product class.
    /*
    To override a method, a child class( in this case Product) must provide a method with the
    same signature (method name, same return type, same parameters)
    of the parent class (Object class)
    Override annotation is optional
     */
    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", " + getDiscount() + ", " + rating.getStars() + ", " + getBestBefore();
    }

    /*
    12. Generate equals(id, name) and hashcode(id) method on the product class.
    The hashcode method generates a new hash value based on product Id
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //13. Modify the equals method of product class.
        /*
        As we're are comparing whether the products of the same class type, the below validation fails.
        Comment the below line so as to ensure we only check them based on the name and id.
        The null check is no longer required, because the instance operator returns false if the parameter is null.
         */
       // if (o == null || getClass() != o.getClass()) return false;

        if(o instanceof Product){
            Product product = (Product) o;
            return id == product.id && Objects.equals(name, product.name);
        }
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //18. Define a fall back behavior for getBestBefore() in the product.
    /*
    As the bestBefore var is not available, define a default value
     */
    public LocalDate getBestBefore() {
        return LocalDate.now();
    }
}
