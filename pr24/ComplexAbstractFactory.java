// task1_complex/ComplexAbstractFactory.java
package task1_complex;

public interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int imag);
}