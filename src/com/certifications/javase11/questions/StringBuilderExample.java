package src.com.certifications.javase11.questions;

public class StringBuilderExample {

    /*
    insert() will push the remaining string forward
     */
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        sb.append("HOWDY");
        // 01234
        // HOWDY
        sb.insert(0,' ');
        // 012345
        //  HOWDY
        sb.replace(3,5,"LL");
        // 012345
        //  HOLLY
        sb.insert(6,"COW");
        // 012345678
        //  HOLLYCOW
        sb.delete(2,7);
        // 012345678
        //  HOW
        System.out.println(sb.length());
        System.out.println(sb.toString());


    }
}
