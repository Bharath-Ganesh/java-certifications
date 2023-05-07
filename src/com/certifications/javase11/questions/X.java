package src.com.certifications.javase11.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class X {

    public static void main(String[] args) {

        /*
          1. Comparator<> comparator=new Comparator<Integer>
                We have to provide an identifier
          2. Comparator Comparator=new Comparator<Integer>() {
         */

        Comparator<Integer> Comparator = new Comparator<>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        var itemQueue1= new PriorityQueue<Integer>();

        // The below line is inferred as PriorityQueue<Object>
        var itemQueue2= new PriorityQueue<>();

        UnaryOperator<Integer> un1 = (x) -> x * 3;

        IntUnaryOperator un2 = (x) -> x * 3;

        List<Integer> results = Arrays.asList(1, 2, 3, 4);
        results.stream().mapToInt(x->x*3).map(un2).average();
    }
}


