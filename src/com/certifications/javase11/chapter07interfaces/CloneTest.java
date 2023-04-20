package src.com.certifications.javase11.chapter07interfaces;

public class CloneTest implements Cloneable {

    private int id;

    public CloneTest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public CloneTest clone() throws CloneNotSupportedException{
        return (CloneTest) super.clone();
    }

    public static void main(String[] args) {
        CloneTest cloneTest=new CloneTest(1);
        try {
            CloneTest clone = cloneTest.clone();
            System.out.println(cloneTest==clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
