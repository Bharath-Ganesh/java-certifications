package src.com.certifications.javase11.chapter05classDesign;

public class GarbageCollections {
    public static void main(String[] args) {
        // You can trigger garbage collection explicitly using
        System.gc();
        Runtime.getRuntime().gc();

        // But there's no guarantee that JVM would run garbage collection and clean up memory.
        // It depends on many factors
        // 1. Amount of available memory vs used memory
    }


}
