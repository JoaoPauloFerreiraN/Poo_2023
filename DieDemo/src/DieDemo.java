
public class DieDemo {
    public static void main(String[] args) {
        Die die1 = new Die();
        Die die2 = new Die();

        die1.roll();
        die2.roll();

        int sum = die1.getSideUp() + die2.getSideUp();

        System.out.println("Lado do dado 1: " + die1.getSideUp());
        System.out.println("Lado do dado 2: " + die2.getSideUp());
        System.out.println("Soma dos lados: " + sum);
    }
}


