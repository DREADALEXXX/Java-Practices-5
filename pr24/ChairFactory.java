// task2_chair/ChairFactory.java
package task2_chair;

public class ChairFactory implements AbstractChairFactory {
    @Override
    public VictorianChair createVictorian() { return new VictorianChair(100); }

    @Override
    public MagicChair createMagic()         { return new MagicChair(); }

    @Override
    public FunctionalChair createFunctional() { return new FunctionalChair(); }
}