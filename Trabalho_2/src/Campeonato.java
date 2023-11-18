import java.util.Scanner;
import java.io.File;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Campeonato implements Serializable {
    private Jogador[] jogadores;
    private int qtdParticipantes = 0;


    public Campeonato() {
        this.jogadores = new Jogador[10];
    }

    //Adiciona o jogador ao campeonato
    public void incluirJogador() {
        if (qtdParticipantes < 10) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome do jogador: ");
            String nome = sc.nextLine();
            System.out.println("Digite o tipo do jogador [1 - Humano ou 2 - Maquina]: ");
            int tipo = sc.nextInt();
            if (tipo == 1){
                sc.nextLine();
                System.out.println("Digite o CPF do jogador: ");
                String cpf = sc.nextLine();
                System.out.println("Digite a agencia do jogador: ");
                String agencia = sc.nextLine();
                System.out.println("Digite a conta do jogador: ");
                String conta = sc.nextLine();
                System.out.println("Digite o numero do banco do jogador: ");
                int numero = sc.nextInt();
                sc.nextLine();
                Jogador j = new Humano(nome, tipo, cpf, agencia, conta, numero);
                this.jogadores[this.qtdParticipantes] = j;
                System.out.printf(this.jogadores[this.qtdParticipantes].toString());
                this.qtdParticipantes++;

            }
        } else {
            System.out.println("Número máximo de jogadores atingido!");
        }
    }

    //Remnove um jogador pelo nome
    public void removerJogador() {
        if (this.qtdParticipantes > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome do jogador: ");
            String nome = sc.nextLine();
            for (int i = 0; i < this.qtdParticipantes; i++) {
                if (this.jogadores[i].getNome().equals(nome)) {
                    this.jogadores[i] = null;
                    for (int j = i; j < this.qtdParticipantes; j++) {
                        this.jogadores[j] = this.jogadores[j + 1];
                    }
                    this.qtdParticipantes--;
                    break;
                }
            }
        } else {
            System.out.println("Não há jogadores cadastrados!");
        }
    }


    public void imprimirExtratosDosResultados(){
        for ( int i = 0; i < this.getQtdParticipantes(); i++){
            Jogador jogadorAux = this.getJogadores()[i];
            System.out.printf("\n Jogador: " + jogadorAux.getNome());
            for (int j = 0; j < jogadorAux.getnJogadas(); j++){
                JogoDados jogoAux = jogadorAux.getJogo()[j];
                System.out.print("\n Jogo: ");
                if ( jogoAux instanceof JogoGeneral ){
                    System.out.print("Jogo General\n");
                    jogoAux.jogadaExecutada();
                    System.out.print("\nValor Apostado: " + jogoAux.getAposta());
                    if (jogoAux.isResultado()){
                        System.out.print("\nResultado: Venceu!");
                    }else{
                        System.out.print("\nResultado: Perdeu!\n");
                    }
                }else{
                    System.out.printf("Jogo Azar");
                }
            }
        }
    }

    public void executarRodadasApostas(){
        Scanner sc = new Scanner(System.in);
        //while (verificaJogadasTodos()){
            for (int i = 0; i < this.getQtdParticipantes(); i++){
                if(this.getJogadores()[i].getSaldo() > 0) {
                    if (this.getJogadores()[i] instanceof Humano) {
                        Humano jogadorAux = (Humano) this.getJogadores()[i];
                        System.out.println("Vez do Jogador: " + jogadorAux.getNome());
                        if (this.verificaJogadasLivre(jogadorAux)) {
                            System.out.println("Informe o valor que voce deseja Apostar: ");
                            float auxAposta = sc.nextFloat();
                            sc.nextLine();
                            while (auxAposta > jogadorAux.getSaldo() || auxAposta <= 0 ) {
                                if (auxAposta > jogadorAux.getSaldo()){
                                    System.out.println("Saldo insulficiente!\n Seu saldo é de: R$" + jogadorAux.getSaldo());
                                }else {
                                    System.out.println("Aposta menor ou igual a zero1!\n Seu saldo é de: " + jogadorAux.getSaldo());
                                }
                                System.out.println("Informe o valor que voce deseja Apostar: ");
                                auxAposta = sc.nextFloat();
                                sc.nextLine();
                            }
                            System.out.printf("Informe o Jogo que deseja jogar:\n 1 - Jogo General e 2 - Jogo Azar.\n");
                            int auxTipoJogo = sc.nextInt();
                            if (auxTipoJogo == 1) {
                                JogoGeneral novoJogoGeneral = new JogoGeneral();
                                jogadorAux.setJogo(novoJogoGeneral,jogadorAux.getnJogadas());
                                novoJogoGeneral.setAposta(auxAposta);
                                System.out.println("Jogando Jogo General !");
                                rodadaJogoGeneralHumano(jogadorAux, novoJogoGeneral);
                            } else {
                                JogoAzar novoJogoAzar = new JogoAzar();
                                jogadorAux.setJogo(novoJogoAzar,jogadorAux.getnJogadas());
                                novoJogoAzar.setAposta(auxAposta);
                                System.out.println("Jogando Jogo Azar !");
                                rodadaJogoAzar(jogadorAux,novoJogoAzar);
                            }
                        }else{
                            System.out.println("O Jogador não possui jogadas disponíveis !");

                        }
                    }
                }else{
                    System.out.println(this.getJogadores()[i].getNome() + " não possui saldo sulficiente para jogar !");
                }
            }
//        }

    }


    public void rodadaJogoAzar(Humano jogadorAux, JogoAzar jogoAux){
        float resultSaldo = 0;
        char result = 'j';
        int cont = 1;
        int numProc;
        boolean key = false;

        System.out.println(cont + "° jogada: ");
        jogadorAux.jogarDados(2);
        jogoAux.listarDados();
        numProc = jogoAux.calcSum();
        do{
            if (key){
                System.out.println(cont + "° jogada: ");
                jogadorAux.jogarDados(2);
                jogoAux.listarDados();
            }
            if ((jogoAux.calcSum() == 7 && cont == 1 && !key) || (jogoAux.calcSum() == 11 && cont == 1 && !key)){
                result = 'g';
            } else if (jogoAux.calcSum() == 2 || jogoAux.calcSum() == 3 || jogoAux.calcSum() == 12) {
                result = 'p';
            } else if ((numProc == jogoAux.calcSum() )&& key ){
                result = 'g';
            }
            key = true;
            cont ++;

        }while (result == 'j');
        if (result == 'g'){
            System.out.println("Parabéns você Ganhou !");
            jogoAux.setResultado(true);
        }else {
            System.out.println("Que pena, você Perdeu !");
            jogoAux.setResultado(false);
        }
        jogadorAux.setnJogadas(jogadorAux.getnJogadas() + 1);
        resultSaldo = jogoAux.logicaResultado();
        jogadorAux.setSaldo(jogadorAux.getSaldo() + resultSaldo);
        System.out.println("Seu saldo atual é: R$" + jogadorAux.getSaldo());
    }


    public void rodadaJogoGeneralHumano (Humano jogadorAux, JogoGeneral jogoAux) {
        float resultSaldo = 0;
        for(int i = 0; i < 13; i++ ) {
                System.out.print("Quantidade de  jogadas realizadas: " + i + "\n");
                jogadorAux.jogarDados(1);
                jogoAux.jogadaExecutada();
                jogadorAux.escolherJogada(jogoAux);
                System.out.println("-------------------------------------------------------------");
        }
        jogadorAux.setnJogadas(jogadorAux.getnJogadas() + 1);
        jogoAux.jogadaExecutada();
        resultSaldo = jogoAux.logicaResultado();
        jogadorAux.setSaldo(jogadorAux.getSaldo() + resultSaldo);
        System.out.println("Seu saldo atual é: R$" + jogadorAux.getSaldo());
    }


    public boolean verificaJogadasLivre (Jogador jogadorAux){
        return jogadorAux.getnJogadas() < 10;
    }

    public boolean verificaJogadasTodos (){
        boolean resultado = false;
        for (int i = 0; i < this.getQtdParticipantes(); i++ ){
            if (this.verificaJogadasLivre(this.getJogadores()[i])){ // Se alguem tiver jogadas livre ele acaba com o for!
                resultado = true;
                i = this.getQtdParticipantes();
            }
        }
        return resultado;
    }



//    Printa a cartela na tela
//    public void mostrarCartela() {
//        System.out.print("Jogador:");
//        for (int i = 0; i < this.qtdParticipantes; i++) {
//            System.out.print("  " + this.jogadores[i].getNome());
//            if (this.jogadores[i].getTipoJogador() == 1) {
//                System.out.print("(H)");
//            } else {
//                System.out.print("(M)");
//            }
//        }
//        System.out.println();
//        for (int i = 1; i <= 13; i++) {
//            System.out.print(i + ":        ");
//            for (int j = 0; j < this.qtdParticipantes; j++) {
//                for (int k = 0; k < (this.jogadores[j].getNome().length() / 2); k++) {
//                    if (k == 0) {
//                        System.out.print(" ");
//                    } else {
//                        System.out.print("   ");
//
//                    }
//                }
//                if (this.jogadores[j].getJogo().jogadas[i - 1] < 0) {
//                    System.out.print("-");
//                } else {
//                    System.out.print(this.jogadores[j].getJogo().jogadas[i - 1]);
//                }
//
//            }
//            System.out.println("");
//        }
//        System.out.println("---------------------------------------------------");
//        System.out.print("Total:      ");
//        for (int i = 0; i < this.qtdParticipantes; i++) {
//            for (int l = 0; l < (this.jogadores[i].getNome().length() / 2); l++) {
//                if (l == 0) {
//                    System.out.print(" ");
//                } else {
//                    System.out.print("   ");
//
//                }
//            }
//            if (this.jogadores[i].totalPontos() < 0) {
//                System.out.print("-");
//            } else {
//                System.out.print(this.jogadores[i].totalPontos());
//            }
//        }
//        System.out.println();
//    }

    //Executa as rodadas

//    public void executarRodada() {
//        int chaveFim = 0;
//        for (int i = 0; i < this.qtdParticipantes; i++) {
//            this.jogadores[i].setJogadas(0);
//            this.jogadores[i].novoJogo();
//        }
//        do {
//            for (int i = 0; i < this.qtdParticipantes; i++) {
//                if (this.jogadores[i].getJogadas() < 13) {
//                    if (this.jogadores[i].getTipoJogador() == 1) {
//                        Scanner sc = new Scanner(System.in);
//                        System.out.println("Vez do jogador: " + this.jogadores[i].getNome());
//                        this.jogadores[i].jogarDados();
//                        System.out.println("Digite a jogada desejada: ");
//                        int jogada = sc.nextInt();
//                        this.jogadores[i].escolherJogada(jogada);
//                        this.jogadores[i].mostrarJogadasExecutadas();
//                        System.out.println("-------------------------------------------------------------");
//                    } else {
//                        System.out.println("Vez do jogador: " + this.jogadores[i].getNome());
//                        this.jogadores[i].jogarDados();
//                        int jogada = this.jogadores[i].getJogo().jogadaMaquina();
//                        System.out.println("Jogada escolhida: " + jogada);
//                        this.jogadores[i].escolherJogada(jogada);
//                        this.jogadores[i].mostrarJogadasExecutadas();
//                        System.out.println("-------------------------------------------------------------");
//                    }
//                    this.jogadores[i].setJogadas(this.jogadores[i].getJogadas() + 1);
//                } else {
//                    System.out.println("Jogador " + this.jogadores[i].getNome() + " já finalizou o jogo!");
//                }
//            }
//
//            for (int i = 0; i < this.qtdParticipantes; i++) {
//                if (this.jogadores[i].getJogadas() == 13) {
//                    chaveFim++;
//                } else {
//                    chaveFim = 0;
//                }
//            }
//        } while (chaveFim < this.qtdParticipantes);
//    }

    //Grava em arquivo
    public void gravarEmArquivo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        String nomeArquivo = sc.nextLine();
        File arquivo = new File(nomeArquivo + ".data");
        try {
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            fout.close();
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }

    }

    //Ler arquivos
    public void lerDeArquivo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        String nomeArquivo = sc.nextLine();
        File arquivo = new File(nomeArquivo + ".data");
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);
            Campeonato c = (Campeonato) oin.readObject();
            oin.close();
            fin.close();
            this.jogadores = c.jogadores;
            this.qtdParticipantes = c.qtdParticipantes;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
        }

    }


    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador[] jogadores) {
        this.jogadores = jogadores;
    }

    public int getQtdParticipantes() {
        return qtdParticipantes;
    }

    public void setQtdParticipantes(int qtdParticipantes) {
        this.qtdParticipantes = qtdParticipantes;
    }

}
