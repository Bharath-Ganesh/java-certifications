Steps to reproduce

Session 1

1. Create a Rateable interface with generic type.
2. Add an abstract method to the Rateable interface.
3. Add default rating to the interface. 
4. Add a static method to convert numeric starts value to the Rating enumeration value.
5. Add a default method, applyRating() which applies rating as an int.
6. Add functional interface annotation to indicate there's only one abstract method.
7. Implements the Rateable interface in Product.
8. Now you can delete the abstract method from the Product.