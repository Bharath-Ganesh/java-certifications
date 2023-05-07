package src.com.certifications.javase11.questions;

public interface AnInterface {
    abstract void x();
}

abstract class AbstractClassB {

    public void x() {

    }

    public abstract void z();
}

class C extends B implements AnInterface {

    @Override
    public void x() {

    }
}