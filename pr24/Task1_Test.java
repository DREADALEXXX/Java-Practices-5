// task1_complex/Task1_Test.java
package task1_complex;

public class Task1_Test {
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();

        Complex zero = factory.createComplex();
        System.out.println("createComplex()      → " + zero);

        Complex c = factory.createComplex(3, 4);
        System.out.println("createComplex(3, 4)  → " + c);
    }
}