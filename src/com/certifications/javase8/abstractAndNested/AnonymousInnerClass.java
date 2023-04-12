package com.certifications.javase8.abstractAndNested;

// Java program to demonstrate Need for
// Anonymous Inner class

// Interfae
interface Age {

    // Defining variables and methods
    // By default constants are public static final
    int x = 21;

    void getAge();
}

// Class 1
// Helper class implementing methods of Age Interface
class MyClass implements Age {


    @Override
    public void getAge() {
        System.out.print("Age is " + x);
    }
}

// Class 2
// Main class
// AnonymousDemo
public class AnonymousInnerClass {
    // Main driver method
    public static void main(String[] args) {
        // Class 1 is implementation class of Age interface
        /**
         * Here, an object of MyClass is created but not an intance of Age is created and copied in the entire class code as shown above.
         * This is possible only with anonymous inner class. Such a class is called ‘anonymous inner class’, so here we call ‘Myclass’ as anonymous inner class.
         */
        //MyClass obj = new MyClass();

        // calling getage() method implemented at Class1
        // inside main() method
        // obj.getAge();


        //Type 1: Anonymous Inner class that extends a class
        Age age= new Age() {
            @Override
            public void getAge() {
                System.out.print("Age is " );
            }
        };
        age.getAge();

        //   ((Age) () -> System.out.print("Age is " + Age.x)).getAge();
        //lambda
        ((Age) ()-> System.out.println("Age")).getAge();



        //Type 2: Anonymous Inner class that implements an interface
        // Using Anonymous Inner class that extends a class
        // Here a Thread class
        Thread thread = new Thread() {

            // run() method for the thread
            @Override
            public void run() {
                // Print statement for child thread
                // execution
                System.out.println("Child Thread");
            }
        };

        Thread thread2 = new Thread( () -> System.out.println("Child Thread 2"));


        // Starting the thread
        thread.start();

        // Displaying main thread only for readibilty
        System.out.println("Main Thread");


        // Here we are using Anonymous Inner class
        // that implements a interface i.e. Here Runnable
        // interface
        Runnable r = new Runnable() {

            // run() method for the thread
            public void run() {
                // Print statement when run() is invoked
                System.out.println("Child Thread");
            }
        };


        // Creating thread in main() using Thread class
        Thread t = new Thread(r);

        // Starting the thread using start() method
        // which invokes run() method automatically
        t.start();

        // Print statement only
        System.out.println("Main Thread");


        //Type 3: Anonymous Inner class that defines inside method/constructor argument
        Thread t2 = new Thread(new Runnable() {

            // run() method for the thread
            public void run() {
                // Print statement when run() is invoked
                System.out.println("Child Thread");
            }
        });

        t2.start();

        System.out.println("Main Thread");
    }
}

