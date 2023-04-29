Steps to reproduce

Session 1

In this exercise, you'll identify the areas where exception handling are required.

1. In the Shop class, pass a product ID that does not exist to the printProductReport(). It results in NPE.
2. Replace the ElseGet of the findProduct() to get().
3. Create a custom exception class, ProductManagerException.
4. Modify the findProduct() to throw the ProductManagerException.
5. Handle with try-catch block in the invoker method.
6. Add logging in the catch block and also add requires 'java.logging' in the module.info.

Session 2

Parse String and extract information to parse text and values, and do the necessary exception handling.

7. Add config.properties to define the format of review and product message.
8. Load the config using the ResourceBundle.
9. Create parseReview() and parseProduct() method.
10. Invoke  parseReview("101,5,Nice hot cup of coffee") from the Shop class.
11. Now Replace, the second parameter, 5 with an Alphabet. This will throw NumberFormatException.
12. Create test cases in the Shop class to test parseReview method.
13. Create parseProduct similarly. 
