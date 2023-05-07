package src.com.certifications.javase11.questions.ocpchap4.decision;

public class TestExample {

    public static void main(String[] args) {
        TestExample obj = new TestExample();
        obj.ifElseStatement();
    }

    public void forVarStatement(int[] weather) {

        for (var i : weather) {
            System.out.println(weather[i]);
        }

    }

    public void ifElseStatement() {
        int temperature = 4;
        long humidity = -temperature + temperature * 3;
        if (temperature >= 4)
            if (humidity < 6)
                System.out.println("Too Low");
            else
                System.out.println("Just Right");
        else
            System.out.println("Too High");

        int count = 0;
        BUNNY:
        for (int row = 1; row <= 3; row++)
            RABBIT:for (int col = 0; col < 3; col++) {
                if ((col + row) % 2 == 0)
                    break RABBIT;
                count++;
            }
        System.out.println(count);
    }

    public void optionalLabel() {
        int[][] myComplexArray = { { 5, 2, 1, 3 }, { 3, 9, 8, 9 }, { 5, 7, 12, 7 } };

        /*
        A label is an optional pointer to the head of a statement that allows the application flow to jump to it or break from it.
        It is a single identifier that is proceeded by a colon ':'
         */

        int[][] list = { { 1, 13 }, { 5, 2 }, { 2, 2 } };
        int searchValue = 2;
        int positionX = -1;
        int positionY = -1;

        PARENT_LOOP:
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] == searchValue) {
                    positionX = i;
                    positionY = j;
                    break PARENT_LOOP;
                }
            }
        }
        if (positionX == -1 || positionY == -1) {
            System.out.println("Value " + searchValue + " not found");
        } else {
            System.out.println("Value " + searchValue + " found at: " + "(" + positionX + "," + positionY + ")");
        }

        CLEANING:
        for (char stables = 'a'; stables <= 'd'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables == 'b' || leopard == 2) {
                    continue CLEANING;
                }
                System.out.println("Cleaning: " + stables + "," + leopard);
            }
        }

        /*
        Cleaning: a, 1
        Cleaning: c, 1
        Cleaning: d, 1
         */
    }

    public void switchStatement() {
        int month = 1;
        //The first switch statement does not compile because it is missing parentheses around the switch variable.
        // switch month {  // DOES NOT COMPILE
        //     case 1: System.out.print("January");
        // }

        /*
        The second statement does not compile because it is missing braces around the switch body.
         */
        //switch (month)  // DOES NOT COMPILE
        //case 1: System.out.print("January");

        /*
         The third statement does not compile because the case keyword is missing before the 2:
         */
        //switch (month) {
        // case 1: 2: System.out.print("January"); // DOES NOT COMPILE
        //}

        // Switch Data Types
        /*
        The following is a list of all data types supported by switch statements:
            int and Integer
            byte and Byte
            short and Short
            char and Character
            String
            enum values
            var (if the type resolves to one of the preceding types)
         */
        switch (month) {
        }

    }

    final int getCookies() {
        return 4;
    }

    void feedAnimals() {

        /*
        First off, the values in each case statement must be compile-time constant values of the same data type as the switch value.
        This means you can use only literals, enum constants, or final constant variables of the same data type.
         By final constant, we mean that the variable must be marked with the final modifier and initialized with a literal value in
         the same expression in which it is declared.

         For example, you can’t have a case statement value that requires executing a method at runtime, even if that method always
         returns the same value. For these reasons, only the first and last case statements in the following example compiles:
         */
        final int bananas = 1;
        int apples = 2;
        int numberOfAnimals = 3;
        final int cookies = getCookies();
        switch (numberOfAnimals) {
        //The bananas variable is marked final, and its value is known at compile-time, so it is valid.
        case bananas:

            //The apples variable is not marked final, even though its value is known, so it is not permitted.
            //case apples:  // DOES NOT COMPILES

            // The next two case statements, with values getCookies() and cookies, do not compile because methods are not
            // evaluated until runtime, so they cannot be used as the value of a case statement, even if one of the values is
            // stored in a final variable.
            // case getCookies():  // DOES NOT COMPILE
            //  case cookies:  // DOES NOT COMPILE
        case 3 * 5:
        }
    }

    public void numericPromotionCasting() {
        short size = 4;
        final int small = 15;
        final int big = 1_000_000;
        switch (size) {
        case small:
        case 1 + 2:
      /*
      On the other hand, 1_000_000 is too large to fit inside of short without an explicit cast, so the last case statement does not compile.

       */
            //case big:  // DOES NOT COMPILE
        }
    }

    private int getSortOrder(String firstName, final String lastName) {
        String middleName = "Patricia";
        final String suffix = "JR";
        int id = 0;
        switch (firstName) {
        case "Test":
            return 52;

        // middleName is not final
   /*     case middleName:  // DOES NOT COMPILE
            id = 5;
            break;*/
        case suffix:
            id = 0;
            break;
        }

        // Although the lastName is final, it is passed to the function as a parameter. So it's value, can't be accessed at
        // the compile time
        //        case lastName:    // DOES NOT COMPILE
        //            id = 8;
        //            break;

        // Not String
/*        case 5:           // DOES NOT COMPILE
            id = 7;
            break;*/
        // Not String
/*        case 'J':         // DOES NOT COMPILE
            id = 10;
            break;*/
        // Not String; enum
/*        case java.time.DayOfWeek.SUNDAY:  // DOES NOT COMPILE
            id=15;
            break;
        }*/
        return id;

    }
}

