Steps to reproduce

Session 1

In this exercise, you write the products and review reports to text files.

1. Add three paths for report, data, and temp in the config.properties.
2. Add three filename format for report, data, and temp files.
3. Add three instance var to reference the path where the reports will be created.
4. In the printProduct(), create a Path where product report will be written.

Session 2

Bulk load data from files.

5. Create reports.csv and products.csv in the data folder. E:\Github\javase_11\data
6. Modify config.properties, review.data.format to expect only two values.
7. Modify parseReview().
8. Modify parseProduct().
9. loadReview(), to bulk load all the review.
10. loadProduct().
11. loadAllData().   

Session 3

Serialize and deserialize


12. Product and Review should implement Serializable. 
13. Add dumpData() to dump all the products into a temp file.
