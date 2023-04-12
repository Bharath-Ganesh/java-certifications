package com.certifications.javase11.localDateTimeAndWrapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigDecimalAndBigInteger {

    public static void main(String[] args) {

        //BigDecimal represents an immutable arbitrary-precision signed decimal number
        /**
         * BigDecimal represents an immutable arbitrary-precision signed decimal number. It consists of two parts:
         *
         * Unscaled value – an arbitrary precision integer
         * Scale – a 32-bit integer representing the number of digits to the right of the decimal point
         * For example, the BigDecimal 3.14 has the unscaled value of 314 and the scale of 2.
         *
         * We use BigDecimal for high-precision arithmetic. We also use it for calculations requiring control over scale and rounding off behavior.
         * One such example is calculations involving financial transactions.
         */
        BigDecimal a = new BigDecimal(23.02333);
        whenGettingAttributes_thenExpectedResult();
        whenComparingBigDecimals_thenExpectedResult();
        givenPurchaseTxn_whenCalculatingTotalAmount_thenExpectedResult();

    }


    public static void whenGettingAttributes_thenExpectedResult() {
        BigDecimal bd = new BigDecimal("-12345.2611789");

        System.out.println(bd.precision()); //12 : total signification
        System.out.println(bd.scale()); // Number of digits after the decimal points
        System.out.println(bd.signum()); // indicating sign
    }



   //  We compare the value of two BigDecimals using the compareTo method:

    /**
     * This method ignores the scale while comparing.
     *
     * On the other hand, the equals method considers two BigDecimal objects as equal only if they are equal in value and scale.
     * Thus, BigDecimals 1.0 and 1.00 are not equal when compared by this method.
     */
    public static void whenComparingBigDecimals_thenExpectedResult() {
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");
        BigDecimal bd3 = new BigDecimal("2.0");

        System.out.println(bd1.compareTo(bd3) < 0); // true
        System.out.println(bd3.compareTo(bd1) > 0);
        System.out.println(bd1.compareTo(bd2) == 0); // true
        System.out.println(bd1.compareTo(bd3) <= 0);
        System.out.println(bd1.compareTo(bd2) >= 0);
        System.out.println(bd1.compareTo(bd3) != 0);
    }

    public void whenPerformingArithmetic_thenExpectedResult() {
        /**
         * We perform arithmetic operations by calling the corresponding methods:
         */
        BigDecimal bd1 = new BigDecimal("4.0");
        BigDecimal bd2 = new BigDecimal("2.0");

        BigDecimal sum = bd1.add(bd2);
        BigDecimal difference = bd1.subtract(bd2);
        BigDecimal quotient = bd1.divide(bd2);
        BigDecimal product = bd1.multiply(bd2);

        System.out.println(sum.compareTo(new BigDecimal("6.0")) == 0);
        System.out.println(difference.compareTo(new BigDecimal("2.0")) == 0);
        System.out.println(quotient.compareTo(new BigDecimal("2.0")) == 0);
        System.out.println(product.compareTo(new BigDecimal("8.0")) == 0);
    }

    public static BigDecimal calculateTotalAmount(BigDecimal quantity,
                                                  BigDecimal unitPrice, BigDecimal discountRate, BigDecimal taxRate) {
        BigDecimal amount = quantity.multiply(unitPrice);
        BigDecimal discount = amount.multiply(discountRate);
        BigDecimal discountedAmount = amount.subtract(discount);
        BigDecimal tax = discountedAmount.multiply(taxRate);
        BigDecimal total = discountedAmount.add(tax);

        // round to 2 decimal places using HALF_EVEN
        BigDecimal roundedTotal = total.setScale(2, RoundingMode.HALF_EVEN);

        return roundedTotal;
    }

    public static void givenPurchaseTxn_whenCalculatingTotalAmount_thenExpectedResult() {
        BigDecimal quantity = new BigDecimal("4.5");
        BigDecimal unitPrice = new BigDecimal("2.69");
        BigDecimal discountRate = new BigDecimal("0.10");
        BigDecimal taxRate = new BigDecimal("0.0725");

        BigDecimal amountToBePaid = calculateTotalAmount(quantity, unitPrice, discountRate, taxRate);

    }
}
