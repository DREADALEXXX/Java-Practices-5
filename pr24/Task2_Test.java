// task2_chair/Task2_Test.java
package task2_chair;

public class Task2_Test {
    public static void main(String[] args) {
        AbstractChairFactory factory = new ChairFactory();
        Client client = new Client();

        client.setChair(factory.createVictorian());
        client.sit();

        client.setChair(factory.createMagic());
        client.sit();

        client.setChair(factory.createFunctional());
        client.sit();
    }
}