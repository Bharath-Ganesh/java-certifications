Steps to reproduce

Session 1

Make use of HashMap to store multiple reviews for a single product

1. Replace declaration of product and reviews with an instance of HashMap.
2. Update createProduct().
3. Update reviewProduct().
4. Modify printProductReport() to iterate through the reviews.
5. Update the Shop class.


Session 2

To sort the review based on the review rating.

6. Implements Comparable interface using in the Review class
7. In the ProductManager, invoke Collections.sort().
8. Create findProduct() in the ProductManager class.
9. Overloaded version of reviewProduct() and printProductReport().
10.Update the equals' method in Product class.