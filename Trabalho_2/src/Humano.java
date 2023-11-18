import java.util.Scanner;
import java.io.Serializable;


public class Humano extends Jogador implements JogarComoHumano{
    private String cpf;
    private String agencia;
    private String conta;
    private int nBanco;



    public Humano(String nome, int tipoJogador, String cpf, String agencia, String conta, int nBanco) {
        super(nome, tipoJogador);
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.nBanco = nBanco;
    }

    public Humano(String cpf, String agencia, String conta, int nBanco) {
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.nBanco = nBanco;
    }

    @Override
    public int escolherJogo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite qual jogo você deseja Jogar: \n 1 - Jogo General \n 2 - Jogo de Azar.\n");
        return sc.nextInt();
    }

    @Override
    public int escolherJogada(JogoGeneral jogo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma jogada válida: ");
        int jogada = sc.nextInt();
        System.out.println("Valor escolhido:"+jogada);
        if((jogada >= 1 && jogada <= 13) && (jogo.getValoresJogadas(jogada - 1) == -1)){
            jogo.pontuarJogada(jogada);
            return 1;
        }else {
            System.out.println("Jogada inválida!");
            escolherJogada(jogo);
        }
        return 0;
    }
    @Override
    public String toString() {

        return super.toString() + " 'Humano'" +
                ", cpf='" + cpf + '\'' +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", nBanco='" + nBanco + "'\n";
    }

    @Override
    public void jogarDados(int tipoJogo) {
        if (tipoJogo == 1) { // Se for jogo general
            if (this.getnJogadas() < 10) {//se tiver jogadas livres
                if (this.getJogo()[this.getnJogadas()]  == null) {
                    this.getJogo()[this.getnJogadas()] = new JogoGeneral(); //cria a instancia do jogo
                }
                this.getJogo()[this.getnJogadas()].rolarDados();
            }
        }else {
            if (this.getnJogadas() < 10) {
                if(this.getJogo()[this.getnJogadas()] == null){
                    this.getJogo()[this.getnJogadas()] = new JogoAzar();
                }
                this.getJogo()[this.getnJogadas()].rolarDados();

            }
        }
    }

}
