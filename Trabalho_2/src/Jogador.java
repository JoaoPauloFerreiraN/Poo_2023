import java.util.Arrays;
import java.io.Serializable;


abstract public class Jogador {
    private String nome;
    private int tipoJogador;
    private JogoDados[] jogo;
    private int nJogadas;
    private float saldo;

    public Jogador() {
        this.nome = "Maquina";
        this.tipoJogador = 2; //Maquina
        jogo = new JogoDados[10];
        this.nJogadas = 0;
        this.saldo = 100;
    }
    public Jogador( int tipoJogador) {
        this.nome = "Anonimo";
        this.tipoJogador = tipoJogador;
        jogo = new JogoDados[10];
        this.nJogadas = 0;
        this.saldo = 100;
    }
    public Jogador( String nome) {
        this.nome = nome;
        this.tipoJogador = 2;//Maquina
        jogo = new JogoDados[10];
        this.nJogadas = 0;
        this.saldo = 100;
    }
    public Jogador(String nome, int tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        jogo = new JogoDados[10];
        this.nJogadas = 0;
        this.saldo = 100;
    }

    abstract public void jogarDados(int tipoJogo);

    public void mostrarJogadasExecutadas(){
        for (int i = 0; i < this.getnJogadas(); i++){
            this.getJogo()[i].jogadaExecutada();
        }
    };



    public JogoDados[] getJogo() {
        return jogo;
    }

    public int getnJogadas() {
        return nJogadas;
    }

    public void setnJogadas(int nJogadas) {
        this.nJogadas = nJogadas;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", tipoJogador=";
    }

    public String getNome() {
        return nome;
    }

    public int getTipoJogador() {
        return tipoJogador;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setJogo(JogoDados jogo, int i) {
        this.jogo[i] = jogo;
    }
}
