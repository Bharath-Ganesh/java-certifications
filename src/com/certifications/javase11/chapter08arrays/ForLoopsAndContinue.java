package src.com.certifications.javase11.chapter08arrays;

public class ForLoopsAndContinue {

    public static void main(String[] args) {

        char[][] arr1 =
                        {{'A', 'B', 'C', 'D'},
                        {'E', 'F', 'G', 'H'},
                        {'I', 'J', 'K', 'L'},
                        {'M', 'N', 'O', 'P'},
                        {'A', 'B', 'C', 'D'},
                        {'E', 'F', 'G', 'H'},
                        {'I', 'J', 'K', 'L'},
                        {'M', 'N', 'O', 'P'}};

        /*
         * The loop labels can be used to indicate when encountering a special termination condition;
         * where the control needs to go to.
         * It has to be declared immediately before the for loop condition.
         */
        outerLoopLabel:
        for (char[] row : arr1) {
            for (char val : row) {
                if (val == 'C') continue;
                if (val == 'F') continue outerLoopLabel;
                if (val == 'I') break;
                if (val == 'M') break outerLoopLabel;
                System.out.print(val + " ");
            }
            System.out.println();
        }



        char[][][] arr =
                {
                        {{'A', 'B', 'C', 'D'},
                    {'E', 'F', 'G', 'H'},
                    {'I', 'J', 'K', 'L'},
                    {'M', 'N', 'O', 'P'}},
                {       {'A', 'B', 'C', 'D'},
                        {'E', 'F', 'G', 'H'},
                        {'I', 'J', 'K', 'L'},
                        {'M', 'N', 'O', 'P'}}};

        outerLoopLabel:
        for (char[][] matrix : arr) {
            innerLoopLabel:
            for (char[] row : matrix) {
                for (char val : row) {
                    if (val == 'C') continue;
                    if (val == 'F') continue innerLoopLabel;
                    if (val == 'I') break;
                    if (val == 'M') break outerLoopLabel;
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}
