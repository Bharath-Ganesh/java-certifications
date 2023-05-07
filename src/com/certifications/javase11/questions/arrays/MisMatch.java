package src.com.certifications.javase11.questions.arrays;

import java.util.Arrays;

public class MisMatch {

    int a;

    public static void main(String[] args) {


        /*
        Finds and returns the index of the first mismatch between two int arrays, otherwise return -1 if no mismatch is found.
        The index will be in the range of 0 (inclusive) up to the length (inclusive) of the smaller array.
         */
        int[] secA = { 2, 4, 6, 8, 10 };
        int[] secB = { 2, 4, 8, 6, 10 };
        int res1 = Arrays.mismatch(secA, secB);

        /*
        The value 0 if the first and second array are equal and contain the same elements in the same order;
        a value less than 0 if the first array is lexicographically less than the second array;
        and a value greater than 0 if the first array is lexicographically greater than the second array
         */
        int res2 = Arrays.compare(secA, secB);
        System.out.println(res1 + " : " + res2);

        int[] sec1A = { 3, 100, 4, 10000, 10 };
        int[] sec2B = { 3, 100, 8, 6, 10 };
        int res3 = Arrays.mismatch(sec1A, sec2B);
        int res4 = Arrays.compare(sec1A, sec2B);
        System.out.println(res3 + " : " + res4);

    }

    public void method() {
        a = a * 2;
        /*
        Variables that represent fields in a class are automatically initialized to their corresponding 0, null, or false values during object
         instantiation.
         Local variables must be specifically initialized before they can be used.
         */
        int b;
        //b=b*2;
    }
}
