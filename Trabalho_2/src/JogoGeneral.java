import java.io.Serializable;
import java.util.Arrays;


public class JogoGeneral extends JogoDados{
    private int[] valoresJogadas;


    public JogoGeneral() {
        super(5, "JogoGeneral");
        this.valoresJogadas = new int[13];
        for (int i = 0; i < 13; i++){
            this.setValoresJogadas(-1,i);
        }
    }

    //Metodo que verifica o valor de uma jogada escolhida, retornando o valor da jogada.
    // realizado dessa maneira para que quando a maquina jogar ela escolher a maior jogada.
    public int valorJogada (int jogada){
        int cont = 0;
        switch (jogada) {
            case 1 -> {
                for (int i = 0; i < 5; i++) {
                    if (this.getDados()[i].getSideUP() == 1) {
                        cont++;
                        System.out.println("cont contou: "+cont);
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < 5; i++) {
                    if (super.getDados()[i].getSideUP() == 2) {
                        cont += 2;
                        System.out.println("cont contou: "+cont);
                    }
                    System.out.println("for contou: "+i);
                    System.out.println("Dados: "+super.getDados()[i].getSideUP() );
                }
            }
            case 3 -> {
                for (int i = 0; i < 5; i++) {
                    if (this.getDados()[i].getSideUP() == 3) {
                        cont += 3;
                        System.out.println("cont contou: "+cont);
                    }
                }
            }
            case 4 -> {
                for (int i = 0; i < 5; i++) {
                    if (this.getDados()[i].getSideUP() == 4) {
                        cont += 4;
                        System.out.println("cont contou: "+cont);
                    }
                }
            }
            case 5 -> {
                for (int i = 0; i < 5; i++) {
                    if (this.getDados()[i].getSideUP() == 5) {
                        cont += 5;
                        System.out.println("cont contou: "+cont);
                    }
                }
            }
            case 6 -> {
                for (int i = 0; i < 5; i++) {
                    if (this.getDados()[i].getSideUP() == 6) {
                        cont += 6;
                        System.out.println("cont contou: "+cont);
                    }
                }
            }
            case 7 -> {
                int trinca = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = i; j < 5; j++) {
                        if (this.getDados()[i].getSideUP() == this.getDados()[j].getSideUP() && i != j) {
                            trinca++;
                        }
                    }
                }
                if (trinca >= 3) {
                    for (int i = 0; i < 5; i++) {
                        cont += this.getDados()[i].getSideUP();
                    }
                } else {
                    cont = 0;
                }
            }
            case 8 -> {
                int quadra = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = i; j < 5; j++) {
                        if (this.getDados()[i].getSideUP() == this.getDados()[j].getSideUP() && i != j) {
                            quadra++;
                        }
                    }
                }
                if (quadra >= 4) {
                    for (int i = 0; i < 5; i++) {
                        cont += this.getDados()[i].getSideUP();
                    }
                } else {
                    cont = 0;
                }
            }
            case 9 -> {
                int fullHouse = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = i; j < 5; j++) {
                        if (this.getDados()[i].getSideUP() == this.getDados()[j].getSideUP() && i != j) {
                            fullHouse++;
                        }
                    }
                }
                if (fullHouse == 4) {
                    cont = 25;
                } else {
                    cont = 0;
                }
            }
            case 10 -> {
                int seqA = 0;
                if (this.getDados()[0].getSideUP() == 2) {
                    seqA++;
                }
                for (int i = 0; i < 5; i++) {
                    if (this.getDados()[i].getSideUP() == (this.getDados()[i].getSideUP() - 1)) {
                        seqA++;
                    }
                }
                if (seqA == 5) {
                    cont = 30;
                } else {
                    cont = 0;
                }
            }
            case 11 -> {
                int seqB = 0;
                if (this.getDados()[0].getSideUP() == 1) {
                    seqB++;
                }
                for (int i = 0; i < 5; i++) {
                    if (this.getDados()[i].getSideUP() == (this.getDados()[i].getSideUP() - 1)) {
                        seqB++;
                    }
                }
                if (seqB == 5) {
                    cont = 40;
                } else {
                    cont = 0;
                }
            }
            case 12 -> {
                int general = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = i; j < 5; j++) {
                        if (this.getDados()[i].getSideUP() == this.getDados()[j].getSideUP() && i != j) {
                            general++;
                        }
                    }
                }
                if (general == 5) {
                    cont = 50;
                } else {
                    cont = 0;
                }
            }
            case 13 -> {
                for (int i = 0; i < 5; i++) {
                    cont += this.getDados()[i].getSideUP();
                }
            }
            default -> System.out.println("Jogada inválida!");
        }
        return cont;
    }

    //Pontua a jogada escolhida no vetor de pontos.
    public void pontuarJogada(int jogada){
        this.setValoresJogadas(valorJogada(jogada),jogada-1);
    }


    public void rolarDados() {
        for (int i = 0; i < 5; i++){
            this.getDados()[i].roll();
        }
        this.sortDados(1);
        this.listarDados();
    }

    public void listarDados(){
        for (int i = 0; i < 5; i++){
            System.out.print(this.getDados()[i].getSideUP() + " ");
        }
        System.out.println();
    }

    @Override
    public void jogadaExecutada() {
        for (int i = 0; i < 13; i++) {
            if(i < 10 && i != 0){
                System.out.print(" " + (i+1) + " ");
            }else{
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            if (this.getValoresJogadas(i) == -1) {
                System.out.print(" - ");
            }else{
                if(this.getValoresJogadas(i) < 10 && i != 0){
                    System.out.print(" " + this.getValoresJogadas(i) + " ");
                }else{
                    System.out.print( this.getValoresJogadas(i) + " ");
                }
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "JogoGeneral{" +
                "valoresJogadas=" + Arrays.toString(valoresJogadas) +
                '}';
    }

    @Override
    public int getnDados() {
        return super.getnDados();
    }

    @Override
    public String getNomeJogo() {
        return super.getNomeJogo();
    }

    @Override
    public void setNomeJogo(String nomeJogo) {
        super.setNomeJogo(nomeJogo);
    }

    @Override
    public Dado[] getDados() {
        return super.getDados();
    }


    public int getValoresJogadas(int posicao) {
        return valoresJogadas[posicao];
    }

    public void setValoresJogadas(int valor, int posicao) {
        this.valoresJogadas[posicao] = valor;
    }

    @Override
    public int somarFacerSorteadas(Dado[] x) {
        return super.somarFacerSorteadas(x);
    }

    @Override
    public boolean tipoDeJogo() {
        return super.tipoDeJogo();
    }

    public float logicaResultado(){
        int sum = 0;
        int double13 = getValoresJogadas(12) * 2;
        float result = 0;
        for(int i  = 0; i < 12; i++) {
            sum += getValoresJogadas(i);
        }
        if (sum > double13){
            System.out.println("\nO Jogador Venceu !");
            this.setResultado(true);
            result = this.getAposta();
        }else {
            System.out.println("\nO Jogador Perdeu !");
            this.setResultado(false);
            result = -1 * this.getAposta();
        }
        System.out.println("Valor da soma das jogadas (1 - 12): "+sum);
        System.out.println("Dobro da jogada 13: "+double13);
        return result;
    }



}
