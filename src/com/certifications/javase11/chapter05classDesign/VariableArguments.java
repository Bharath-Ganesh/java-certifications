package src.com.certifications.javase11.chapter05classDesign;

import java.util.Arrays;

public class VariableArguments {

    public static void main(String[] args) {
        VariableArguments obj = new VariableArguments();
        int res = obj.add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(res);
    }

    //private int add(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) { }
    // It's treated as an array with length
    // the var args must be defined at the last
    private int add(int... varArgs) {
        return Arrays.stream(varArgs).sum();
    }
}
