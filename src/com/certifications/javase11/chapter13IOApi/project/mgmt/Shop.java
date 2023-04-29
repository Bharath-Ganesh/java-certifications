package src.com.certifications.javase11.chapter13IOApi.project.mgmt;

import src.com.certifications.javase11.chapter13IOApi.project.prod.ProductManager;

public class Shop {

    public static void main(String[] args) {

        ProductManager pm = new ProductManager("en-GB");
        pm.printProductReport(101);
        pm.printProductReport(102);
        pm.printProductReport(103);

        pm.dumpData();
        pm.restoreData();

        pm.printProductReport(104);



    }
}
