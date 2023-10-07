import java.io.Serializable;
import java.util.Scanner;

public class Jogador implements Serializable  {
    private String nome;
    private int tipoJogador;
    private JogoGeneral jogo;
    private int jogadas;

    //Construtor da classe Jogador de forma sobrecarregada
    public Jogador (){
        this.nome = "Jogador";
        this.tipoJogador = 2;
        this.jogo = new JogoGeneral();
        this.jogadas = 0;
    }
    public Jogador (String nome){
        this.nome = nome;
        this.tipoJogador = 2;
        this.jogo = new JogoGeneral();
        this.jogadas = 0;
    }
    public Jogador(String nome, int tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        this.jogo = new JogoGeneral();
        this.jogadas = 0;
    }

    //Setters e Getters
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

    //Realiza a jogada de daos e Listagem deles 
    public void jogarDados() {
        this.jogo.rolarDados();
        this.jogo.listarDados();
    }
    
    //Invoca o metodo para pontuar a jogada escolhida
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

    //Mostrar jogadas já executadas
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

    //Retorna o total de pontos 
    public int totalPontos(){
        int total = 0;
        for (int i = 0; i < 13; i++){
            total += this.jogo.jogadas[i];
        }
        return total;
    }

    //Re-starta o jogo zerando os pontos da tabela
    public void novoJogo (){
        for(int i =  0 ; i < 13; i++){
            this.jogo.jogadas[i] = -1;
        }
    }
}