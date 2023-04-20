Steps to reproduce

Session 1

1. Create Food and Drink class that extends Product.
2. Temporarily comment the no-args constructor of Product class.
3. Add bestBefore to the Food class
4. Add parameterized constructor to the Food and Drink class. 
5. Modify product p2 of the Shop class to create an instance of the Drink.
6. Modify product p3 of the Shop class to create an instance of the Food.


Session 2 : Polymorphism

7. Replace the println method of shop class and observe the output. // This would invoke the toString() of the object class.
8. Create toString() method in the Product class.
9. Generate toString() method in the Food class.
10. Create p6, p7 product in the shop class.
11. Compare p6 and p7 using equals method.
12. Generate equals(id, name) and hashcode(id) method on the product class.
13. Modify the equals method of product class.
14. Override method of getDiscount() in Food class to calculate discount based on bestBefore.
15. Modify applyRating() of the product class to be an abstract method.
16. Fix the compilation error by replacing the instantiation of new Product() with the respective implementation.
17. The getBestBefore() is only present in the Food class and access that from Shop class.
18. Define a fall back behavior for getBestBefore() in the product.
19. Now remove instanceOf operator from shop class.


Session 3 : Factory Methods
20. Create a ProductManager class and create constructor for Drink and Food class.
21. Remove constructor access in Product, Food, Drink.
22. Create an instance of ProductManager in shop class.