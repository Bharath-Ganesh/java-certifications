package src.com.certifications.javase11.chapter07interfaces.project.mgmt;


import src.com.certifications.javase11.chapter07interfaces.project.prod.Food;
import src.com.certifications.javase11.chapter07interfaces.project.prod.Product;
import src.com.certifications.javase11.chapter07interfaces.project.prod.ProductManager;
import src.com.certifications.javase11.chapter07interfaces.project.prod.Rating;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Shop {

    public static void main(String[] args) {


        ProductManager pm = new ProductManager(Locale.CANADA);
        Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.printProductReport();
        pm.reviewProduct(p1, Rating.FOUR_STAR, "Nice hot cup of coffee");
        pm.printProductReport();


//        Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
//        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p4 = pm.createProduct(105,"Cookie",BigDecimal.valueOf(3.99), Rating.TWO_STAR,LocalDate.now());
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
//        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);
//        Product p9 = p1.applyRating(Rating.TWO_STAR);
//
//
//        System.out.println(p6.equals(p7));
//
//        if(p3 instanceof Food){
//            System.out.println(((Food) p3).getBestBefore());
//        }


        //    System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        System.out.println(p5);
//        System.out.println(p6);
//        System.out.println(p7);
//        System.out.println(p8);
//        System.out.println(p9);

    }
}
