package src.com.certifications.javase11.questions.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatterQuestion {
    public static void main(String[] args) {
        /*
            A. “eeee dd+”th of”+ MMM yyyy”
            B. “eeee dd'th of' MMM yyyy”
            C. “eeee d+”th of”+ MMMM yyyy”
            D. “eeee d’th of’ MMMM yyyy”
         */
        LocalDate d1 = LocalDate.of(1997, 2, 7);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("eeee d'th of' MMMM yyyy");
        // 'MMMM' : Month in full form February
        // 'MMM'  : 'Short representation' Feb
        // 'MM'   : In numeric 02
        // 'M'    : In numeric 2
        dtf = DateTimeFormatter.ofPattern("eeee d'th of' MMMM yyyy"); //Friday 7th of February 1997
        dtf = DateTimeFormatter.ofPattern("eeee d'th of' MMM yyyy");  // Friday 7th of Feb 1997
        dtf = DateTimeFormatter.ofPattern("eeee d'th of' MM yyyy");  // Friday 7th of 02 1997
        dtf = DateTimeFormatter.ofPattern("eeee d'th of' M yyyy");   // Friday 7th of 2 1997
        dtf = DateTimeFormatter.ofPattern("eeee d'th of' MMMM yyy"); // Friday 7th of February 1997

        dtf = DateTimeFormatter.ofPattern("eeee d'th of' MMMM yy");  //Friday 7th of February 97
        dtf = DateTimeFormatter.ofPattern("eeee d'th of' MMMM y");   // Friday 7th of February 1997

        dtf = DateTimeFormatter.ofPattern("eee d'th of' MMMM yy");  // Fri 7th of February 97
        dtf = DateTimeFormatter.ofPattern("ee d'th of' MMMM y");   // 06 7th of February 1997
        dtf = DateTimeFormatter.ofPattern("e d'th of' MMMM y");   // 06 7th of February 1997
        System.out.println(dtf.format(d1));

        LocalDate anotherSummerDay = LocalDate.of(2016, 8, 23);
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
            .format(anotherSummerDay)); //Tuesday, 23 August, 2016

        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
            .format(anotherSummerDay)); // 23 August 2016

        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
            .format(anotherSummerDay));// 23-Aug-2016

        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
            .format(anotherSummerDay)); // 23/08/16
    }

}
