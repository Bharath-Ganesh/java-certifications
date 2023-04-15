package src.com.certifications.javase11.chapter05classDesign.project;


import java.math.BigDecimal;

public class Shop {

    public static void main(String[] args) {
        // 1. Since you have custom constructor, no args constructor is no longer available
        // Product p1=new Product();
        //  p1.setId(101);
        //  p1.setName("Tea");
        //   p1.setPrice(BigDecimal.valueOf(1.99));
        Product p1=new Product(101,"Tea",BigDecimal.valueOf(1.99));
        Product p2=new Product(102,"Coffee",BigDecimal.valueOf(1.99),Rating.FOUR_STAR);
        Product p3=new Product(103,"Cake",BigDecimal.valueOf(3.99),Rating.FIVE_STAR);
        Product p4=new Product();
        Product p5=p3.applyRating(Rating.THREE_STAR);

        //2. Let's make the product class immutable
        //  a. First remove all the setters of the product class, so that once initialized the values cannot be altered.
        //  b. Optionally you can mark the instance of the product class with final keyword. It then have to be initialized directly in all the
        // constructor or using initializer and No other methods can assign such a variable.

        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " " + p1.getRating().getStars());
        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getPrice() + " " + p2.getDiscount() + " " + p2.getRating().getStars());
        System.out.println(p3.getId() + " " + p3.getName() + " " + p3.getPrice() + " " + p3.getDiscount() + " " + p3.getRating().getStars());
        System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscount() + " " + p4.getRating().getStars());
        System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscount() + " " + p5.getRating().getStars());
    }
}
