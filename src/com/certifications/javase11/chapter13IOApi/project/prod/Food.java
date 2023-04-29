package src.com.certifications.javase11.chapter13IOApi.project.prod;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Food extends Product implements Serializable {



    private LocalDate bestBefore;


    public LocalDate getBestBefore() {
        return bestBefore;
    }

    Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }


    @Override
    public String toString() {
        return super.toString() + ", " + bestBefore;
    }


    @Override
    public BigDecimal getDiscount() {
        LocalTime now = LocalTime.now();
        return now.isAfter(LocalTime.of(15,30)) && now.isBefore(LocalTime.of(20,30))?super.getDiscount():BigDecimal.ZERO;
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Food(getId(),getName(),getPrice(),newRating,bestBefore);
    }
}
