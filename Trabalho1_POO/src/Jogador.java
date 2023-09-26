public class Jogador {
    public String nome;
    public boolean tipoJogador;
    public JogoGeneral jogo;

    public Jogador(String nome, boolean tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        this.jogo = new JogoGeneral();
    }

    public void jogarDados() {
        this.jogo.rolarDados();
        this.jogo.listarDados();
    }
    
    public void escolherJogada(int jogada) {
        if (this.jogo.validarJogada(jogada)) {
            this.jogo.pontuarJogada(jogada);
        }
    }

    public void mostrarJogadasExecutadas() {
        for (int i = 0; i < 13; i++) {
            System.out.println(i + " ");
        }
        for (int i = 0; i < 13; i++) {
            System.out.println(this.jogo.jogadas[i] + " ");
        }
    }
}