import java.io.Serializable;

//Clase Dados: acessada para rolar os dados dos jogos.
public class Dados implements Serializable {

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

    public void setValor(int valor) {
        this.valor = valor;
    }

   
}
