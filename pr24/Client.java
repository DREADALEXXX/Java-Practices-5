// task2_chair/Client.java
package task2_chair;

public class Client {
    private Chair chair;

    public void sit() {
        if (chair != null) chair.sit();
        else System.out.println("Стул не выбран");
    }

    public void setChair(Chair chair) { this.chair = chair; }
}