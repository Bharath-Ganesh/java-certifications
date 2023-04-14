package src.com.certifications.javase11.chapter04classesAndStatic;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Product {

    /**
     * final keywords has to be initialized at runtime or in all the constructors
     */
    public final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private int id;
    private String name;
    private BigDecimal price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    //Here the price can be changed inside the method
    //to make sure this doesn't happen keep it final
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount(){
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_DOWN);
    }
}
