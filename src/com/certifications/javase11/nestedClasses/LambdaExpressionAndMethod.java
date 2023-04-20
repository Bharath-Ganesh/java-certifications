package src.com.certifications.javase11.nestedClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TextFilter {

    public static boolean test(String s) {
        return s.equals("remove A");
    }

    public  int sortText(String s1,String s2) {
        return s1.compareTo(s2);
    }
}

public class LambdaExpressionAndMethod {

    public static void main(String[] args) {
        LambdaExpressionAndMethod obj=new LambdaExpressionAndMethod();
        TextFilter textFilter=new TextFilter();
        List<String> list=new ArrayList<>();
        String s1="remove A";
        String s2="remove B";
        String s3="remove C";
        String s4="remove D";
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
       list.removeIf(s->s.equals("remove A"));
        /**
         * Method reference
         * Static Class :: Method name
         */
       list.removeIf(TextFilter::test);



        /**
         * Method reference
         * instance obj :: Method name
         */
        list.sort(textFilter::sortText);



        /**
         * Method reference
         * Class :: <instance method name>
         */
        list.sort(String::compareToIgnoreCase);

        String name="outside annoymous inner class";
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.equals(name)?1:0;
            }
        });

    }

}
