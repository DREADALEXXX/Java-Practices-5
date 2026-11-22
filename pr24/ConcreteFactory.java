// task1_complex/ConcreteFactory.java
package task1_complex;

public class ConcreteFactory implements ComplexAbstractFactory {
    @Override
    public Complex createComplex() {
        return new Complex(0, 0);
    }

    @Override
    public Complex createComplex(int real, int imag) {
        return new Complex(real, imag);
    }
}