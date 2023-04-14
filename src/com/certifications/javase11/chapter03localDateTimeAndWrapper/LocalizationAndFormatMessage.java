package src.com.certifications.javase11.chapter03localDateTimeAndWrapper;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationAndFormatMessage {

    public static void main(String[] args) {
        Locale ukLocale= Locale.UK;
        ResourceBundle resourceBundle= ResourceBundle.getBundle("messages");
        String hello = resourceBundle.getString("hello");
        //It's an error
        System.out.println(hello);
       // MessageFormat.format();
    }
}
