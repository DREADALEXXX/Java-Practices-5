// task2_chair/AbstractChairFactory.java
package task2_chair;

public interface AbstractChairFactory {
    VictorianChair createVictorian();
    MagicChair     createMagic();
    FunctionalChair createFunctional();
}