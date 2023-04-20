package src.com.certifications.javase11.chapter07interfaces.project.mgmt;


import src.com.certifications.javase11.chapter07interfaces.project.prod.Food;
import src.com.certifications.javase11.chapter07interfaces.project.prod.Product;
import src.com.certifications.javase11.chapter07interfaces.project.prod.ProductManager;
import src.com.certifications.javase11.chapter07interfaces.project.prod.Rating;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Shop {

    public static void main(String[] args) {

        //22. Create an instance of ProductManager in shop class.
        /*
        The ProductManager being in the same package as Product, Drink and Food can access the constructor of them, but shop being
        in a different package can't access the constructor of the aforementioned classes.

        Now with this change, we can create new subclasses of Product.
         */
        ProductManager pm=new ProductManager();
        Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.THREE_STAR);
        Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = pm.createProduct(105,"Cookie",BigDecimal.valueOf(3.99), Rating.TWO_STAR,LocalDate.now());
        Product p5 = p3.applyRating(Rating.THREE_STAR);
        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p8 = p4.applyRating(Rating.FIVE_STAR);
        Product p9 = p1.applyRating(Rating.TWO_STAR);

        //11. Compare p6 and p7 using equals method.
        /*
            The p6 and p7 method comparison is false.
            This is because p6 actually invokes the equals method of object class which basically checks if they're referring
            to the same object in the heap.
         */
        System.out.println(p6.equals(p7));

        // 17. The getBestBefore() is only present in the Food class and access that from Shop class.
        /*
            To access this method, we need to have an instance of Food, but despite having a Food instance as we're referring using it's parent type
            , ie Product, we can't invoke the method directly.
            But this type casting is tiring and should be avoided if it's possible.
            To ensure it's declared in the product class, there are two ways.
            1. Define the operation as abstract so as to make sure the child class implement it.
            2. Define a fall back behaviour, ie to create a default behaviour with some value and only override it in the child class.
         */
        //19. Now remove instanceOf operator from shop class.
        /*
        As we have default method in Product class, no type casting is required
         */
        if(p3 instanceof Food){
            System.out.println(((Food) p3).getBestBefore());
        }



        //7. Replace the println method of shop class.
        /*
        The println method class the toString() method of the object class. To achieve polymorphism, we can override the toString()
        method in the child class, ie Food and Drink. Then on invoking the println method with object p1 for an instance, it would look
        at the lowest level of implementation of toString() present. This is essentially what we achieve with polymorphism.
         */
//        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " " + p1.getRating().getStars());
//        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getPrice() + " " + p2.getDiscount() + " " + p2.getRating().getStars());
//        System.out.println(p3.getId() + " " + p3.getName() + " " + p3.getPrice() + " " + p3.getDiscount() + " " + p3.getRating().getStars());
//        System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscount() + " " + p4.getRating().getStars());
//        System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscount() + " " + p5.getRating().getStars());

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);

    }
}
