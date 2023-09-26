public class Dados {

    private int valor;

    public Dados() {
        this.roll();
    }

    public void roll() {
        this.valor = (int) (Math.random() * 6) +1;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "valor=" + valor +
                '}';
    }
}
