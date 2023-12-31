import java.io.Serializable;

//Clase JogoGeneral
public class JogoGeneral implements Serializable {
    private Dados [] d;
    int [] jogadas;


    //Construtor da classe JogoGeneral
        //inicializa os 5 dados e as 13 jogadas, colocando -1 em todas as posições.
    public JogoGeneral(){
        this.d = new Dados[5];
        this.jogadas = new int[13];
        for (int i = 0; i < 5; i++){
            this.d[i] = new Dados();
        }
        for (int i = 0; i < 13; i++){
            this.jogadas[i] = -1;
        }
    }

    //Metodo para rolar e organizar os dados em ordem crescente para melhor visualização.   
    public void rolarDados(){
        for (int i = 0; i < 5; i++){
            this.d[i].roll();
        }
        this.sortDados();
    }

    //Metodo para organizar os dados em ordem crescente para melhor visualização.
    public void sortDados(){
        int aux;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 4; j++){
                if(this.d[j].getValor() > this.d[j+1].getValor()){
                    aux = this.d[j].getValor();
                    this.d[j].setValor(this.d[j+1].getValor());
                    this.d[j+1].setValor(aux);
                }
            }
        }
    }

    //Metodo para imprimir os dados.
    public void listarDados(){
        for (int i = 0; i < 5; i++){
            System.out.print(this.d[i].getValor() + " ");
        }
        System.out.println();
    }

    //Metodo para verificar se uma jogada é valida    
    public boolean validarJogada(int jogada){ 
        if(jogada < 1 || jogada > 13){
            System.out.println("Jogada inválida!");
            return false;
        }else{
            if(this.jogadas[jogada-1] == -1){
                return true;
            }else{
                return false;
            }
        }
    }

    //Metodo que verifica o valor de uma jogada escolhida, retornando o valor da jogada.
    // realizado dessa maneira para que quando a maquina jogar ela escolher a maior jogada.
    public int valorJogada (int jogada){
        int cont = 0;
        switch (jogada){
            case 1:
                for (int i = 0; i < 5; i++){
                    if(this.d[i].getValor() == 1){
                        cont++;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 5; i++){
                    if(this.d[i].getValor() == 2){
                        cont += 2;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < 5; i++){
                    if(this.d[i].getValor() == 3){
                        cont += 3;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < 5; i++){
                    if(this.d[i].getValor() == 4){
                        cont += 4;
                    }
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++){
                    if(this.d[i].getValor() == 5){
                        cont += 5;
                    }
                }
                break;
            case 6:
                for (int i = 0; i < 5; i++){
                    if(this.d[i].getValor() == 6){
                        cont += 6;
                    }
                }
                break;
            case 7:
                int trinca = 0;
                for (int i = 0; i < 5; i++){
                    for (int j = i; j < 5; j++){
                        if(this.d[i].getValor() == this.d[j].getValor() && i!= j){
                            trinca++;
                        }
                    }
                }
                if(trinca >= 3){
                    for (int i = 0; i < 5; i++){
                        cont += this.d[i].getValor();
                    }
                }else{
                    cont = 0;
                }

                break;
            case 8:
                int quadra = 0;
                for (int i = 0; i < 5; i++){
                    for (int j = i; j < 5; j++){
                        if(this.d[i].getValor() == this.d[j].getValor() && i != j){
                            quadra++;
                        }
                    }
                }
                if(quadra >= 4){
                    for (int i = 0; i < 5; i++){
                        cont += this.d[i].getValor();
                    }
                }else{
                    cont = 0;
                }
                
                break;
            case 9:
                int fullHouse = 0; 
                for (int i = 0; i < 5; i++){
                    for (int j = i; j < 5; j++){
                        if(this.d[i].getValor() == this.d[j].getValor() && i != j){
                            fullHouse++;
                        }
                    }
                }
                if(fullHouse == 4){
                    cont = 25;
                }else{
                    cont = 0;
                }
                
                break;
            case 10:
                int seqA = 0;
                if(this.d[0].getValor() == 2){
                    seqA++;
                }
                for (int i = 0; i < 5; i++){
                    if(this.d[i].getValor() == (this.d[i].getValor() - 1) ){
                    seqA++;
                    }
                }
                if(seqA == 5){
                    cont = 30;
                }else{
                    cont = 0;
                }
                break;
            case 11:
                int seqB = 0;
                if(this.d[0].getValor() == 1){
                    seqB++;
                }
                for (int i = 0; i < 5; i++){
                    if(this.d[i].getValor() == (this.d[i].getValor() - 1) ){
                    seqB++;
                    }
                }
                if(seqB == 5){
                    cont = 40;
                }else{
                    cont = 0;
                }
                break;
            case 12:
                int general = 0;
                for (int i = 0; i < 5; i++){
                    for (int j = i; j < 5; j++){
                        if(this.d[i].getValor() == this.d[j].getValor() && i != j){
                            general++;
                        }
                    }
                }
                if(general == 5){
                    cont = 50;
                }else{
                    cont = 0;
                }
                break;
            case 13:
                for (int i = 0; i < 5; i++){
                    cont += this.d[i].getValor();
                }              
                break;
            default:
                System.out.println("Jogada inválida!");
                break;
        }
        return cont;
    }

    //Pontua a jogada escolhida no vetor de pontos.
    public void pontuarJogada(int jogada){
        this.jogadas[jogada-1] =  valorJogada(jogada);
    }

    //Verifica a maior jogada possivel e retorna a jogada para ser pontuada.    
    public int jogadaMaquina(){
        int jogada = 0;
        int maior = 0;
        for (int i = 0; i < 13; i++){
            if(validarJogada(i+1)){
                if(valorJogada(i+1) >= maior){
                    maior = valorJogada(i+1);
                    jogada = i+1;
                }
            }
        }
        return jogada;   
    }


}
