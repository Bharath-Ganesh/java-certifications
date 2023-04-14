package src.com.certifications.javase11.chapter05classDesign;


public class Tester {

    public static void main(String[] args) {

        Jet jet1=new Jet();
        jet1.speed=212;
        System.out.println(jet1.getSpeed());

        Jet jet2=new Jet();
        jet2.setSpeed(212);
        System.out.println(jet2.getSpeed());


        Jet jet3=new Jet();
        System.out.println(jet3.getSpeed());
    }
}
