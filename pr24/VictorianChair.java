// task2_chair/VictorianChair.java
package task2_chair;

public class VictorianChair implements Chair {
    private final int age;

    public VictorianChair(int age) { this.age = age; }

    public int getAge() { return age; }

    @Override
    public void sit() { System.out.println("Сидим на викторианском стуле (возраст: " + age + " лет)"); }

    @Override
    public String getType() { return "VictorianChair"; }
}