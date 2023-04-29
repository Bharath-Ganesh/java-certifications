package src.com.certifications.javase11.chapter13IOApi.project.prod;



import java.io.Serializable;
import java.math.BigDecimal;

public class Drink extends Product implements Serializable {


    Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price,rating);
    }

    @Override
    public BigDecimal getDiscount() {
        return super.getDiscount();
    }


    @Override
    public Product applyRating(Rating newRating) {
        return new Drink(getId(),getName(),getPrice(),newRating);
    }
}
