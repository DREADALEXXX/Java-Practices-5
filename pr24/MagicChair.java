// task2_chair/MagicChair.java
package task2_chair;

public class MagicChair implements Chair {
    @Override
    public void sit() { System.out.println("Сидим на магическом стуле..."); }

    @Override
    public String getType() { return "MagicChair"; }

    public void doMagic() { System.out.println("✨ Магия!"); }
}