package src.com.certifications.javase11.chapter03localDateTimeAndWrapper;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeExample {
    public static void main(String[] args) {

        // The default zoneId
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        /*
            This give the local date and time of the default zoneId
         */
        LocalDate defaultZoneIdLocalDate=LocalDate.now();
        System.out.println(defaultZoneIdLocalDate);   // 2023-04-13  // yyyy-mm-dd
        LocalTime defaultZoneIdLocalTime=LocalTime.now();
        System.out.println(defaultZoneIdLocalTime);  // 21:33:50.024266100  // hh:mm:ss:nan
        LocalDateTime defaultLocalDateTime= LocalDateTime.now();
        System.out.println(defaultLocalDateTime);   //2023-04-13T21:33:50.024266100


        //  If you give a zone Id, you'll get the corresponding date and time
        ZoneId parisZoneId = ZoneId.of("Europe/Paris");

        LocalDate parisLocalDate=LocalDate.now(parisZoneId);
        System.out.println(parisLocalDate);   // 2023-04-13  // yyyy-mm-dd
        LocalTime parisLocalTime=LocalTime.now(parisZoneId);
        System.out.println(parisLocalTime);


        // Assume you're giving a Gre exam in Aug first week friday
        // now you're on month April, so 4 months from now

        Month month = LocalDate.now().plusMonths(4).getMonth();
        System.out.println(month);

        int dayOfMonth=1;
        LocalDate greExam;
        while (true){
            greExam = LocalDate.of(2023, month,dayOfMonth );
            if(greExam.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
                break;
            }
            dayOfMonth++;
        }
        //day of month
        System.out.println("\n GRE EXAM DATE : \n" + greExam.getDayOfMonth());

        //The exam is scheduled at 10
        LocalTime greExamTime=LocalTime.of(10,00);

        LocalDateTime greExamDateAndTime = greExam.atTime(greExamTime);
        System.out.println("\n GRE EXAM DATE AND TIME : \n" + greExamDateAndTime);
        // 2023-08-04T10:00


        //Ielts exam is scheduled one week from gre exam
        // plus operator
        // You can alter the date and time as times gets updated from to 11 from 10
        // All date and time object return date and time object
        LocalDateTime ieltsExamDateTime = greExamDateAndTime.plusDays(7).withHour(11).withMinute(30);
        System.out.println("\n Ielts exam \n" +ieltsExamDateTime); //2023-08-11T11:00


        System.out.println(" Ielts exam date time " + ieltsExamDateTime);  // 2023-08-11T11:30
        System.out.println(" Ielts exam month " + ieltsExamDateTime.getDayOfMonth()); // 4
        System.out.println(" Ielts exam  day of week " + ieltsExamDateTime.getDayOfWeek()); // Friday

        // It's officially the tea time
        Duration examGap = Duration.between(greExamDateAndTime, ieltsExamDateTime);
        System.out.println(examGap.toDays()); // 7
        System.out.println(examGap.toHours()); // 169
        System.out.println(examGap.toMinutesPart()); // 1


        /**
         * Now we're gonna look the time for a student in aus
         */
        // ZoneId
        ZoneId ausZoneId = ZoneId.of("Australia/Sydney");
        ZoneId indZoneId = ZoneId.of("Asia/Kolkata");

        ZonedDateTime zonedIndTime=ZonedDateTime.of(greExamDateAndTime,indZoneId);
        System.out.println(zonedIndTime); //2023-08-04T10:00+05:30[Asia/Kolkata]

        ZonedDateTime zonedAusDateTime = zonedIndTime.withZoneSameInstant(ausZoneId);
        System.out.println(zonedAusDateTime); // 2023-08-04T14:30+10:00[Australia/Sydney]

        ZonedDateTime zonedDirectAusTime=ZonedDateTime.of(greExamDateAndTime,ausZoneId);
        System.out.println(zonedDirectAusTime); // 2023-08-04T10:00+10:00[Australia/Sydney]


        /**
         * Date pattern
         */
        Locale ukLocale= Locale.UK;
        String datePattern="EE' , 'd' of 'MMMM yyyy' at 'HH:mm z";
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern(datePattern,ukLocale);
        String format = dateTimeFormatter.format(zonedAusDateTime);
        System.out.println(format);
    }
}
