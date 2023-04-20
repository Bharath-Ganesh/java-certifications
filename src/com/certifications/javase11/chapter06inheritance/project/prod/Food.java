package src.com.certifications.javase11.chapter06inheritance.project.prod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Food extends Product {

/*
2. Temporarily comment the no-args constructor of Product class.
When you have commented out the product class no args constructor and given that Product class also have custom constructors,
the food class on trying to invoke the no-args constructor of the parent class would result into an error.
    public Food(){
       super();
       }
 */

    private LocalDate bestBefore;


    public LocalDate getBestBefore() {
        return bestBefore;
    }

    Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    //9. Generate toString() method in the Food class.
    /*
    The super.toString() would invoke the parent class (Product) toString method.
     */
    @Override
    public String toString() {
        return super.toString() + ", " + bestBefore;
    }

    //14. Override method of getDiscount() in Food class to calculate discount based on bestBefore.
    /*
    Discount based on happy hours
     */
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
