package src.com.certifications.javase11.chapter07interfaces.project.prod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Food extends Product {



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
        return now.isAfter(LocalTime.of(22,30)) && now.isBefore(LocalTime.of(23,30))?super.getDiscount():BigDecimal.ZERO;
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Food(getId(),getName(),getPrice(),newRating,bestBefore);
    }
}
