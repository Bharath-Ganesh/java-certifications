package src.com.certifications.javase11.chapter14MultiThreading;

public class MultiThreadingExample {

    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();
        int i = r.availableProcessors();
        System.out.println(i);
    }
}
