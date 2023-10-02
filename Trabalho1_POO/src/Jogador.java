import java.io.Serializable;
import java.util.Scanner;

public class Jogador implements Serializable  {
    private String nome;
    private int tipoJogador;
    private JogoGeneral jogo;
    private int jogadas;

    public Jogador(String nome, int tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        this.jogo = new JogoGeneral();
        this.jogadas = 0;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

    public int getJogadas() {
        return jogadas;
    }

    public String getNome() {
        return nome;
    }

    public int getTipoJogador() {
        return tipoJogador;
    }

    public JogoGeneral getJogo() {
        return jogo;
    }

    public void jogarDados() {
        this.jogo.rolarDados();
        this.jogo.listarDados();
    }
    
    public void escolherJogada(int jogada) {
        if (this.jogo.validarJogada(jogada)) {
            this.jogo.pontuarJogada(jogada);
        }else{
            Scanner sc = new Scanner(System.in);
            System.out.println("Jogada inválida!");
            System.out.println("Escolha uma jogada válida: ");
            int opcao = sc.nextInt();
            this.escolherJogada(opcao); 
        }
    }

    public void mostrarJogadasExecutadas() {
        for (int i = 0; i < 13; i++) {
            if(i < 10 && i != 0){
                System.out.print(" " + (i+1) + " ");    
            }else{
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            
            if (this.jogo.jogadas[i] == -1) {
                System.out.print(" - ");
            }else{
                if(this.jogo.jogadas[i] < 10 && i != 0){
                    System.out.print(" " + this.jogo.jogadas[i] + " ");
                }else{
                    System.out.print( this.jogo.jogadas[i] + " ");
                }
            }
        }
        System.out.println();
    }

    public int totalPontos(){
        int total = 0;
        for (int i = 0; i < 13; i++){
            total += this.jogo.jogadas[i];
        }
        return total;
    }

    public void novoJogo (){
        for(int i =  0 ; i < 13; i++){
            this.jogo.jogadas[i] = -1;
        }
    }
}