import java.io.Serializable;

//Classe Dado: Acessada para rolar os dados dos jogos.
public class Dado implements Serializable {
    private  int sideUP;

    public Dado (){
        this.roll();
    }

    public int getSideUP() {
        return sideUP;
    }

    public void setSideUP(int sideUP) {
        this.sideUP = sideUP;
    }

    public void roll (){
        this.setSideUP((int)(Math.random() * 6)+1);
    }

    @Override
    public String toString() {
        return "Dado{" +
                "sideUP=" + sideUP +
                '}';
    }
}
