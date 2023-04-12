package com.certifications.javase11;

public class ForLoopsAndContinue {

    public static void main(String[] args) {


        char[][][] arr = {{{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}, {'I', 'J', 'K', 'L'}, {'M', 'N', 'O', 'P'}}, {{'A', 'B', 'C', 'D'}, {'E', 'F', 'G', 'H'}, {'I', 'J', 'K', 'L'}, {'M', 'N', 'O', 'P'}}};
        /**
         * The loop labels can be used to indicate when encountering a special termination condition;
         * where the control needs to go to.
         * It has to be declared immediately before the for loop condition.
         */
        outerLoopLabel:
        for (char[][] matrix : arr) {
            innerLooplabel:
            for (char[] row : matrix) {
                for (char val : row) {
                    if (val == 'C') continue;
                    if (val == 'F') continue innerLooplabel;
                    if (val == 'I') break outerLoopLabel;
                    if (val == 'M') break outerLoopLabel;
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}
