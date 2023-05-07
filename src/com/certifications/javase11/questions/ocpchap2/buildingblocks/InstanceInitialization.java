package src.com.certifications.javase11.questions.ocpchap2.buildingblocks;

public class InstanceInitialization {

    static int sCount;

    static {
        sCount = 2;
    }

    int count;

    {
        System.out.print(count + "-");
    }

    {
        count++;
    }

    public InstanceInitialization() {
        count = 4;
        System.out.print(2 + "-");
    }

    public static void main(String[] args) {

        System.out.print(7 + "-");
        System.out.print(sCount + "-");
        var s = new InstanceInitialization();
        System.out.print(s.count + "-");
    }
}

