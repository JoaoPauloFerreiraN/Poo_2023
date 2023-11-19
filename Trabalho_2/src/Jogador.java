import java.util.Arrays;
import java.io.Serializable;


abstract public class Jogador implements Serializable {
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
        this.saldo = (float) 100.00;
    }
    public Jogador( int tipoJogador) {
        this.nome = "Anonimo";
        this.tipoJogador = tipoJogador;
        jogo = new JogoDados[10];
        this.nJogadas = 0;
        this.saldo = (float) 100.00;
    }
    public Jogador( String nome) {
        this.nome = nome;
        this.tipoJogador = 2;//Maquina
        jogo = new JogoDados[10];
        this.nJogadas = 0;
        this.saldo = (float) 100.00;
    }
    public Jogador(String nome, int tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        jogo = new JogoDados[10];
        this.nJogadas = 0;
        this.saldo = (float) 100.00;
    }



    public void jogarDados(int tipoJogo){
         if (tipoJogo == 1) { // Se for jogo general
             if (this.getJogo()[this.getnJogadas()]  == null) {
                 this.getJogo()[this.getnJogadas()] = new JogoGeneral(); //cria a instancia do jogo
             }
         }else {
             if(this.getJogo()[this.getnJogadas()] == null){
                 this.getJogo()[this.getnJogadas()] = new JogoAzar();
             }
         }
         this.getJogo()[this.getnJogadas()].rolarDados();
     }

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
                ", tipoJogador=" + tipoJogador + "}\n";
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
        this.saldo = (float) ((saldo * 100.0) / 100.0);
    }

    public void setJogo(JogoDados jogo, int i) {
        this.jogo[i] = jogo;
    }


}
