package src.com.certifications.javase11.interfaces;

public class CloneTest implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        CloneTest cloneTest=new CloneTest();
        try {
            cloneTest.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
