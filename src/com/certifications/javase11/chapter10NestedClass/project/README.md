Steps to reproduce

Session 1

1. Create a Static Inner class in ProductManager to format the message from ResourceBundle.
2. Create formatProduct() for formatting the message.
3. Map of ResourceFormatters representing different locale.
4. Add formatter to the ProductManager which represents the selected Formatter.
5. Add new resource properties
6. Update the Shop class, ProductManager initialization.


Session 2

7. Add printProducts(Comparator<Product> sorter).
8. Now invoke the above method using various comparators.