package src.com.certifications.javase11.chapter12Exception.project.mgmt;

import src.com.certifications.javase11.chapter12Exception.project.prod.ProductManager;

public class Shop {

    public static void main(String[] args) {

        ProductManager pm = new ProductManager("en-GB");
        pm.parseProduct("F,101,Coffee,1.99,0,2019-09-19");
        pm.printProductReport(101);
        pm.parseReview("101,5,Nice hot cup of coffee");
        pm.parseReview("101,2,Rather weak tea");
        pm.parseReview("101,4,Fine tea");
        pm.parseReview("101,4,Awesome tea");
        pm.parseReview("101,5,Perfect");
        pm.parseReview("101,3,Maybe lemon");

        pm.printProductReport(101);


//
//        //pm.changeLocale("fr-FR");
//
//        pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.reviewProduct(102, Rating.THREE_STAR, "Coffee was ok");
//        pm.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?");
//        pm.reviewProduct(102, Rating.FIVE_STAR, "It's perfect with the ten spoons of sugar");
//        pm.printProductReport(102);
//
//        pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now()
//            .plusDays(2));
//        pm.reviewProduct(103, Rating.FIVE_STAR, "Very nice cake");
//        pm.reviewProduct(103, Rating.FOUR_STAR, "It's good, but more chocolate");
//        pm.reviewProduct(103, Rating.FIVE_STAR, "The cake is perfect");
//        pm.printProductReport(103);
//
//        pm.createProduct(104, "Cookie", BigDecimal.valueOf(2.99), Rating.NOT_RATED, LocalDate.now());
//        pm.reviewProduct(104, Rating.THREE_STAR, "Just another cookie");
//        pm.reviewProduct(104, Rating.THREE_STAR, "Okay");
//        pm.printProductReport(104);
//
//        pm.createProduct(105, "Hot Chocolate", BigDecimal.valueOf(2.50), Rating.NOT_RATED);
//        pm.reviewProduct(105, Rating.FOUR_STAR, "Tasty");
//        pm.reviewProduct(105, Rating.FOUR_STAR, "No bad at all");
//        pm.printProductReport(105);
//
//        pm.createProduct(106, "Chocolate", BigDecimal.valueOf(2.50), Rating.NOT_RATED, LocalDate.now()
//            .plusDays(3));
//        pm.reviewProduct(106, Rating.TWO_STAR, "Too sweet");
//        pm.reviewProduct(106, Rating.THREE_STAR, "Better than cookie");
//        pm.reviewProduct(106, Rating.TWO_STAR, "Too bitter");
//        pm.reviewProduct(106, Rating.ONE_STAR, "I don't get it");
//        pm.printProductReport(106);
//
//        System.out.println("\n**************************\n");
//
//        Map<String, String> discounts = pm.getDiscounts();
//        discounts.forEach((rating,discount)-> System.out.println(rating + "\t" + discount));
//
//        System.out.println("\n**************************\n");
//
//
//
//
//        Comparator<Product> ratingSorter= Comparator.comparingInt(p -> p.getRating()
//            .ordinal());
//        Comparator<Product> priceSorter= Comparator.comparing(Product::getPrice);
//
//        pm.printProducts(ratingSorter);
//        pm.printProducts(priceSorter);
//
//
//        Comparator<Product> productComparator = ratingSorter.thenComparing(priceSorter);
//        pm.printProducts(productComparator);
//
//
//        pm.printProducts(ratingSorter,p->p.getPrice().floatValue()<2);

    }
}
