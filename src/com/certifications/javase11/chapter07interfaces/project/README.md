Steps to reproduce

Session 1

1. Create a Rateable interface with generic type. 
   Making an interface enables us to applyRating to any instance say Product or Shop. 
2. Add an applyRating() method to the Rateable interface.
3. Add default rating to the interface. 
4. Add a static method to convert numeric starts value to the Rating enumeration value.
5. Add a default method, applyRating() which applies rating as an int.
6. Add functional interface annotation to indicate there's only one abstract method.
7. Implements the Rateable interface in Product.
8. Now you can delete the abstract method from the Product.

Session 2

9. Create a Review class, to provide rating and comments.
10. Modify ProductManager class to enable to store information about a Product and a review.
11. Add a method reviewProduct() to the ProductManager.
12. Create a resource bundle.
13. Add instance variable to the ProductManager class to print the Product report.

Session3

14. Test the ProductManager report.
