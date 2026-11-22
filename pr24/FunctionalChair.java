// task2_chair/FunctionalChair.java
package task2_chair;

public class FunctionalChair implements Chair {
    @Override
    public void sit() { System.out.println("Сидим на функциональном стуле"); }

    @Override
    public String getType() { return "FunctionalChair"; }

    public int sum(int a, int b) { return a + b; }
}