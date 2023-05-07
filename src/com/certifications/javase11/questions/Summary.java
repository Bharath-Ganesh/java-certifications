package src.com.certifications.javase11.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Summary {

    public static void main(String[] args) {

        test();
        //test1();
        //test3();
        //test4();
        //test5();
        // test6();
        // test7();
        // test8();
        //test9();
        //test10();
        //test11();
        //test12();
    }

    private static void test11() {
        var a="Hello";
        var b="World";
        a=b;
        a="as";
    }

    private static void test10() {
        Iterator iter=List.of(1,2,3).iterator();
        while (iter.hasNext()){
            iter.next();
        }

        Iterator iter2=List.of(1,2,3).iterator();
        while (iter.hasNext()){
            iter2.next();
        }

        for(Iterator iter3=List.of(1,2,3).iterator();iter.hasNext();){

        }

        for(Iterator iter4=List.of(1,2,3).iterator();iter.hasNext();){
            iter2.next();
        }
    }

    public static void test1() {
        int x = 0, y = 6;
        for (; x < y; x++, y--) {
            if (x % 2 == 0) {
                continue;
            }
            System.out.println(x + "-" + y);
        }
    }

    public static void test3() {
        int i = 10;
        do {
            // The inner loop will run for itself
            for (int j = i / 2; j > 0; j--) {
                System.out.print(j + " ");
            }
            i -= 2;
        } while (i > 0);
    }

    private static void test4() {
/*
Which one would compile?
    A. int[][][] e = {{1,1,1},{2,2,2}}; FALSE
    B. short sh = (short)’A’; TRUE
    C. float x = 1f;   TRUE
    D. byte b = 10;    FALSE
    char c = b;
    E. String contact# = “(+2) (999) (232)”; FALSE '#' can't be a part of the identifier
    F. int x = 12_34;  TRUE
    G. boolean false = (4 != 4); FALSE; keyword name
 */
        int[] arr1 = { 1, 2, 3 };
        int[][] arr2 = { { 1, 2, 3 }, { 1, 2, 3 } };
        int[][][] arr3 = { { { 1, 2, 3 }, { 1, 2, 3 } }, { { 4, 5, 6 }, { 7, 8, 9 } } };

        short sh = (short) 'A';

        float x = 1f;

        int a1 = 'a';
        byte b1 = 'a';
        char c1 = 'a';
        a1 = c1;
        // Error : b1=c1; Explicitly casting is required to assign to type lower than int
        short s1 = 'a';
        // Error : s1= c1; Explicitly casting is required

        a1 = c1;
        long l1 = 'a';
        l1 = c1;

        float f1 = 'a';
        f1 = c1;

        double d1 = 'a';
        d1 = c1;

        int x1 = 12_34;

        //boolean false = (4 != 4);

    }

    private static void test5() {

        Person p = new Person("joe");

        checkPerson(p);
        System.out.println(p);
        p = null;
        checkPerson(p);
        System.out.println(p);

    }

    private static void test6() {

        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        /*
        Returns an unmodifiable view of the specified list.
        Query operations on the returned list "read through" to the specified list, and attempts to modify the returned list,
        whether direct or via its iterator, result in an UnsupportedOperationException.
         */
        List<String> list2 = Collections.unmodifiableList(list1);
        list1.add("C");
        list1.add("D");
        System.out.println(list1);
        System.out.println(list2);
    }

    private static void test7() {
        var symbols = List.of("USD", "GBP", "EUR", "CNY");
        var exchangeRate = List.of(1.0, 1.3255, 1.1969, 0.1558094);

        var map1 = IntStream.range(0, Math.min(symbols.size(), exchangeRate.size()))
            .boxed()
            .collect(Collectors.toMap(i -> symbols.get(i), i -> 1 / exchangeRate.get(i)));

        for (Map.Entry<String, Double> entries : map1.entrySet()) {
            String key = entries.getKey();
            Double val = entries.getValue();
        }

        Map<String, Double> collect1 = map1.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        LinkedHashMap<String, Double> collect2 = map1.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        //collect2.forEach((var k,var v)-> System.out.printf("%s -> %.2f\n",k,v));

    }

    private static void test8() {

        /*
            A. Double d = list.get(0);
            B. double f = list.get(0);
            C. Integer a = Integer.valueOf(list.get(0));
            D. Integer b = list.get(0);
            E. int c = list.get(0);
            F. Double e = Double.valueOf(list.get(0));
         */
        List<Integer> list = List.of(11, 12, 13, 12, 13);
        // Double d=list.get(0);
        double f = list.get(0);
        Integer a = Integer.valueOf(list.get(0));
        Integer b = list.get(0);
        int c = list.get(0);
        Double e = Double.valueOf(list.get(0));

        Integer num1 = 23;
        Double d1 = 23.4;
        // Error: d1=num1;
    }

    private static void test9() {

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1;
            }
        };

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                System.out.println(num);
            }
        };

        Function<Integer, String> fn = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        };


        Predicate<Integer> predicate=new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num>2;
            }
        };
    }

    private static void test() {
 /*
            Primitives
         */

        byte b1 = 1;
        // Error : b1=128
        // As it exceeds the max value of byte, 127
        b1 = (int) 1;
        b1 = (int) 1.0f;
        b1 = (int) 123l;

        int a = Integer.MAX_VALUE; // 2147483647
        System.out.println(a);

        // 1. If we store value greater than the max value of int, we have to explicitly provide 'l'
        long l1 = 214748364823232l;

        // 2. This will represent the number in the power.
        float f1 = l1;
        System.out.println(f1); // 2.14748365E14

        // 3. By default, decimal values are stored in double

        char c1 = 'a';
        c1 = 2; // 4. It can take any values from 0->65,535

        // It takes the ASCII value
        char c2 = 100; //d

        //represent the number in hex, oct and binary;
        int var=32;

        // hex ; 16 digits (0-9,A-F)
        // 32/16 =>2
        // 16^2 * 2+ 16^1 * 0 + 16^0 * 0
        int hex= 0x200;
        System.out.println("HEX: " + hex);


         /*
            Number system
         */

        //(0 prefix | 0-7)
        int oct1 = 017; // 15
        // 8^2 *0 + 8^1 * 1 + 8^0* 7= 0 + 8 + 7 =15
        System.out.println(oct1);

        // oct1 = 019; // 15
        // Compilation error  : As the maximum val is 0-7

        //(0x prefix | 0-9,A-F)
        int hex1 = 0xf;
        // 16^1 * 15 + 16^0 * 15 = 240+15 = 255
        System.out.println(hex1); // 255

        //(0B prefix | 0-1)
        int bin1 = 0B11;
        // 2^1 * 1 + 2^0 * 1 = 2+1 = 3
        System.out.println(bin1); // 3


         /*
            Literals and Underscore Character
            To increase the readability
             Add underscore except,
            1. at the beginning of a literal
            2. at the end of a literal
            3. right before a decimal point
            4. right after a decimal point
         */
        float million1 = 1000000.00f;

        million1 = 10_00_000.00f;
        million1 = 10_____00_______000.0_________0f;
        /*
        The below won't work
         */
        // million1=_10_00_000.00f;
        // million1=10_00_000.00_f;
        // million1=10_00_000._00f;
        // million1=10_00_000_.00f;

        // Identifier : Name of a variable, method, class, interface or package
        // A single underscore alone is not allowed
        // ERROR : int _=0;
        int $ = 9;


        /*
        Wrapper class
         */

        int i1 = 1;
        i1 = 'a';

        Integer i2 = 1;
        // ERROR : i2='a';
        // This is not possible , you have to use value of method
        i2 = Integer.valueOf('a');
        System.out.println(i2);

        // Explicitly cast
        Byte aByte = Byte.valueOf((byte) 1);

        // The Character class does not participate in the
        // parseXxx() and valueOf()
        int i = Integer.parseInt("2");
        long l = Long.parseLong("214748364");

        double d2 = 23.23;
        float f2 = 2.23f;
        var v = d2 + f2;

        int a1 = 2;
        int res1 = (6 * 8 / ++a1);
        System.out.println(res1);

        // The result of an assignment is an expression in and of itself

        int work1 = 5;

        int coyotte = work1 = 3;
        System.out.println(coyotte);

        short s1 = 120;
        short s2 = 10;
        short tail = 120 + 10;
        // The addition of two short variable yields an int value.
        //tail = s1 + s2;


        /*
        Compound
         */
        long goat = 10;
        int sheep = 5;

        // Error : sheep=goat*sheep;
        sheep = (int) goat * sheep;
        // Here the casting happens
        sheep *= goat;

        byte goat1 = 10;
        int sheep1 = 5;
        sheep1 += goat1;
        System.out.println();

        /*
        Equality comparison
         */
        // if the numeric values are of different type, the values are automatically promted
        if (5 == 5.0) {
            System.out.println("Promoted");
        }
    }

    // Here the Person p is a local variable to the checkPerson()
    private static Person checkPerson(Person p) {
        if (p == null) {
            p = new Person("Mary");
        } else {
            p = null;
        }
        return p;
    }


    private static void method(List<String>... values){
        Object[] arr=values;
        arr[0]=List.of(1,2,3);
        for(List<String> ar : values){
            System.out.println(ar.get(0));
        }
    }

    private static void test12(){
        method(Arrays.asList("A", "B", "C"),Arrays.asList("D", "E", "F"));
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}


