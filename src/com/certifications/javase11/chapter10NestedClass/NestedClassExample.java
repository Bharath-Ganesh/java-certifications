package src.com.certifications.javase11.chapter10NestedClass;

import java.util.Random;

public class NestedClassExample {

    private Integer outerId = 1;

    private static Integer staticOuterId = 1;

    //Local inner class which is defined in the method context of a method.
    public void outerClassMethod(){
        final int val=1;

        class LocalInnerClass{

            public int someComplexMethodLogic(){
                return new Random().nextInt(val);
            }
        }

        NestedClassExample object=new NestedClassExample();
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.someComplexMethodLogic();
    }





    //Static class is associated with the static context of the outer class.
    public static class StaticNested {
        //Can only access static variable and methods of the outer class.
        //   private Integer id=outerId;

        private Integer id = staticOuterId;

    }



    public MemberClass createMemberClass() {
        return new MemberClass();
    }

    // Member class is associated with the instance context of the outer class.
    public class MemberClass {
        private Integer id = staticOuterId;

        {
            id = outerId;
        }

        public void someMethods(){

        }
    }

    public MemberClassPrivate createMemberClassPrivate() {
        return new MemberClassPrivate();
    }

    // Member class is associated with the instance context of the outer class.
    private class MemberClassPrivate {
        private Integer id;
    }

    public MemberClassDefault createMemberClassDefault() {
        return new MemberClassDefault();
    }

    // Member class is associated with the instance context of the outer class.
    class MemberClassDefault {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    // Anonymous inner class is associated with an inline implementation of an interface or a class.

    public static void methodInitialize(NestedClassExample outer) {

        NestedClassExample.MemberClassPrivate memberClassPrivate = outer.createMemberClassPrivate();
        memberClassPrivate.id = 2;

        NestedClassExample.MemberClassDefault memberClassDefault = outer.createMemberClassDefault();
        memberClassDefault.id = 3;
    }
}
