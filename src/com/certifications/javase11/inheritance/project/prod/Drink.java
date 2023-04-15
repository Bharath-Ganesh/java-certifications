package src.com.certifications.javase11.inheritance.project.prod;



import java.math.BigDecimal;

public class Drink extends Product {

    Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price,rating);
    }

    @Override
    public BigDecimal getDiscount() {
        return super.getDiscount();
    }

    //16. Fix the compilation error by replacing the instantiation of new Product() with the respective implementation.
    /*
    The abstract method needs to be override
     */
    @Override
    public Product applyRating(Rating newRating) {
        return new Drink(getId(),getName(),getPrice(),newRating);
    }
}
