public class Die {
    import java.util.Random;

    class Die {
        private int sideUp;

        public Die() {
            roll();  // Chama o método roll() no construtor para definir um valor inicial.
        }

        public int getSideUp() {
            return sideUp;
        }

        public void roll() {
            Random random = new Random();
            sideUp = random.nextInt(6) + 1;  // Gera um número aleatório de 1 a 6.
        }
    }
}
