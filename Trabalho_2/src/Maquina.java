import java.io.Serializable;

public class Maquina extends Jogador implements JogarComoMaquina, Serializable {


    public Maquina(String nome, int tipoJogador) {
        super(nome, tipoJogador);
    }
    @Override
    public String toString() {
        return super.toString();
    }


    public int jogadaMaquina(JogoGeneral jogo){
        int jogada = 0;
        int maior = 0;
        for (int i = 0; i < 13; i++){
            if((jogo.getValoresJogadas(i) == -1)){
                if(jogo.valorJogada(i+1) >= maior){
                    maior = jogo.valorJogada(i+1);
                    jogada = i+1;
                }
            }
        }
        return jogada;
    }


    @Override
    public int aplicarEstrategia(JogoDados jogo) {

        if (jogo instanceof JogoGeneral){
            int jogada = jogadaMaquina((JogoGeneral) jogo);
            System.out.println("Jogada escolhida:" + jogada);
            ((JogoGeneral) jogo).pontuarJogada(jogada);
        }
        return 0;
    }
}
