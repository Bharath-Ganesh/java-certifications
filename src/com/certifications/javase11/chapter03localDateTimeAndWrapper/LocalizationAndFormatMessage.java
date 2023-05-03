package src.com.certifications.javase11.chapter03localDateTimeAndWrapper;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationAndFormatMessage {

    public static void main(String[] args) throws ParseException {
        Locale ukLocale = Locale.CHINESE;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("src.com.certifications.javase11.chapter03localDateTimeAndWrapper.messages");
        String hello = resourceBundle.getString("hello");

        BigDecimal price = BigDecimal.valueOf(2.99);
        Double tax = 0.2;
        int quantity = 12345;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(ukLocale);

        NumberFormat percentageFormat = NumberFormat.getPercentInstance(ukLocale);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(ukLocale);
        String formattedPrice = currencyFormat.format(price);
        String formattedTax = percentageFormat.format(tax);
        String formattedQuantity = numberFormat.format(quantity);

        String name = "Cookie";
        LocalDate bestBeforeDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE dd MMM yyyy", ukLocale);
        String bestBefore = bestBeforeDate.format(dateTimeFormatter);
        String pattern = resourceBundle.getString("pattern");
        String format = MessageFormat.format(pattern, name, formattedPrice, formattedQuantity, bestBefore);
        System.out.println(format);
        // The method parse can be used convert back to the numeric values
        // BigDecimal bigDecimal = BigDecimal.valueOf((Double) currencyFormat.parse(formattedPrice));
    }
}
