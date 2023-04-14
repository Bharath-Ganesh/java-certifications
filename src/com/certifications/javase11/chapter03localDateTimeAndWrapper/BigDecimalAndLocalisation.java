package src.com.certifications.javase11.chapter03localDateTimeAndWrapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalAndLocalisation {

    public static void main(String[] args) {
        /**
         * Big Decimal
         */
        double price=1.85;
        double rate=0.065;
        price-=price*rate;
        System.out.println(price); //1.7297500000000001

        // 1. Math.round() gives you a whole number
        long round = Math.round(price);
        System.out.println(round); //2

        // To round of the digits to the required decimal places
        float newResult=Math.round(price*100)/100f;
        System.out.println(newResult); // 1.73


        // Double has a precision upto 64 bits
        double newResultInDouble=Math.round(price*100)/100f;
        System.out.println(newResultInDouble); //1.7300000190734863

        // Now let's use BigDecimal for the exact same scenario
        System.out.println("\n BigDecimal \n");
        //But BigDecimal can be used for exact precision
        // They're immutable
        // They have arbitrary precision
        // It's designed to work specifically with


        BigDecimal bPrice=BigDecimal.valueOf(1.85);
        BigDecimal bRate=BigDecimal.valueOf(0.065);
        BigDecimal resultPrice = bPrice.subtract(bPrice.multiply(bRate));
        System.out.println(resultPrice);

        //Please see the documentation to see various rounding mode
        BigDecimal scaledPrice = resultPrice.setScale(2, RoundingMode.HALF_UP);
        System.out.println(scaledPrice);


        /**
         * Localization
         */

        System.out.println("\n Localization \n");

        Locale ukLocale= Locale.UK;



        // Let's see how can format the price and rate in the aforementioned example
        // to the respective locale

        NumberFormat ukCurrentFormat=NumberFormat.getCurrencyInstance(ukLocale);
        NumberFormat ukPercentFormat=NumberFormat.getPercentInstance(ukLocale);

        // Sets the maximum number of digits allowed in the fraction portion of a number.
        ukPercentFormat.setMaximumFractionDigits(2);

        System.out.println(ukCurrentFormat.format(price)); // £1.73
        System.out.println(ukPercentFormat.format(rate)); //  6.5%



        System.out.println(ukCurrentFormat.format(price)); // £1.73
        System.out.println(ukPercentFormat.format(rate)); //  6.5%



        //   public Locale(String language, String country) {
        Locale franceLocale = new Locale("fr", "FR");

        NumberFormat frCurrentFormat=NumberFormat.getCurrencyInstance(franceLocale);
        NumberFormat frPercentFormat=NumberFormat.getPercentInstance(franceLocale);

        // Sets the maximum number of digits allowed in the fraction portion of a number.
        frPercentFormat.setMaximumFractionDigits(2);

        System.out.println(frCurrentFormat.format(price)); // 1,73 €
        System.out.println(frPercentFormat.format(rate)); //  6,5 %

        String priceText = frCurrentFormat.format(price);
        String rateText=frPercentFormat.format(rate);
    }
}
