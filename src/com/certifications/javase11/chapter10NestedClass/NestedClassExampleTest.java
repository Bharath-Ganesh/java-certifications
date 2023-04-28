package src.com.certifications.javase11.chapter10NestedClass;

public class NestedClassExampleTest {

    public static void main(String[] args) {

        NestedClassExample outer = new NestedClassExample();
        NestedClassExample.methodInitialize(outer);

        NestedClassExample.StaticNested staticClass = new NestedClassExample.StaticNested();

        // To create an instance of a member class, you need to create an object of the outer class
        // The class has to be public
        NestedClassExample.MemberClass memberClass = outer.createMemberClass();

        // To create an instance of a member class, you need to create an object of the outer class
        // It can't be accessed outside outer
        //  NestedClassExample.MemberClassPrivate memberClassPrivate = outer.createMemberClassPrivate();

        NestedClassExample.MemberClassDefault memberClassDefault = outer.createMemberClassDefault();
        System.out.println(memberClassDefault.getId());



    }
}
