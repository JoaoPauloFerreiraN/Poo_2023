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
            Jogador j;
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome do jogador: ");
            String nome = sc.nextLine();
            System.out.println("Digite o tipo do jogador [1 - Humano ou 2 - Maquina]: ");
            int tipo = sc.nextInt();
            if (tipo == 1) {
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
                 j = new Humano(nome, tipo, cpf, agencia, conta, numero);

            }else {
                 j = new Maquina(nome,tipo);
            }
            this.setJogadores(j,this.getQtdParticipantes());
            System.out.printf(this.jogadores[this.getQtdParticipantes()].toString());
            this.setQtdParticipantes(this.getQtdParticipantes()+1);
        } else {
            System.out.println("Número máximo de jogadores atingido!");
        }
    }

    //Remnove um jogador pelo nome
    public void removerJogador() {
        boolean key = false;
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
                    System.out.println("Jogador "+nome+" removido com sucesso!");
                    key = true;
                    break;
                }
            }
            if(!key){
                System.out.println("Jogador não encontrado !");
            }
        } else {
            System.out.println("Não há jogadores cadastrados!");
        }
    }

    public void imprimirExtratosDosResultados(int tipoJogo, int tipoJogador){
        Jogador jogadorAux;
        switch (tipoJogo) {
            case 1 -> { // todos
                if (tipoJogador == 1) {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        imprimeExtratoTodosJogos(jogadorAux);
                        System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");
                    }
                } else if (tipoJogador == 2) {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        if (jogadorAux instanceof Humano) {
                            imprimeExtratoTodosJogos(jogadorAux);
                            System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");

                        }
                    }
                } else {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        if (jogadorAux instanceof Maquina) {
                            imprimeExtratoTodosJogos(jogadorAux);
                            System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");

                        }
                    }
                }
            }
            case 2 -> {
                if (tipoJogador == 1) {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        imprimeExtratoJogoGeneral(jogadorAux);
                        System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");

                    }

                } else if (tipoJogador == 2) {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        if (jogadorAux instanceof Humano) {
                            imprimeExtratoJogoGeneral(jogadorAux);
                            System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");

                        }
                    }
                } else {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        if (jogadorAux instanceof Maquina) {
                            imprimeExtratoJogoGeneral(jogadorAux);
                            System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");
                        }
                    }
                }
            }
            case 3 -> {
                if (tipoJogador == 1) {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        imprimeExtratoAzar(jogadorAux);
                        System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");

                    }

                } else if (tipoJogador == 2) {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        if (jogadorAux instanceof Humano) {
                            imprimeExtratoAzar(jogadorAux);
                            System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");
                        }
                    }
                } else {
                    for (int i = 0; i < this.getQtdParticipantes(); i++) {
                        jogadorAux = this.getJogadores()[i];
                        if (jogadorAux instanceof Maquina) {
                            imprimeExtratoAzar(jogadorAux);
                            System.out.println("Saldo Final: R$" + jogadorAux.getSaldo() + "\n\n");
                        }
                    }
                }
            }
        }
    }

    public void imprimeExtratoTodosJogos(Jogador jogadorAux){
        System.out.println("Jogador: " + jogadorAux.getNome());
        for (int j = 0; j < jogadorAux.getnJogadas(); j++) {
            JogoDados jogoAux = jogadorAux.getJogo()[j];
            printname(jogadorAux, jogoAux,j);
        }
    }

    private void printname(Jogador jogadorAux, JogoDados jogoAux, int j) {
        printNomeJogo(jogoAux, j);
        jogoAux.jogadaExecutada();
        System.out.println("Saldo antes da partida: R$ " +
                calcSaldo(j, jogadorAux));
        System.out.println("Valor Apostado: R$ " + jogoAux.getAposta());
        if (jogoAux.isResultado()) {
            System.out.println("Resultado: Venceu!\n");
        } else {
            System.out.println("Resultado: Perdeu!\n");
        }
    }

    public void imprimeExtratoJogoGeneral(Jogador jogadorAux ){
        JogoDados jogoAux;
        System.out.println("Jogador: " + jogadorAux.getNome());
        for (int j = 0; j < jogadorAux.getnJogadas(); j++) {
            jogoAux = jogadorAux.getJogo()[j];
            if( jogoAux instanceof JogoGeneral){
                printname(jogadorAux, jogoAux, j);
            }
        }

    }

    public void imprimeExtratoAzar(Jogador jogadorAux ){
        JogoDados jogoAux;
        System.out.println("Jogador: " + jogadorAux.getNome());
        for (int j = 0; j < jogadorAux.getnJogadas(); j++) {
            jogoAux = jogadorAux.getJogo()[j];
            if( jogoAux instanceof JogoAzar){
                printname(jogadorAux, jogoAux, j);
            }
        }
    }

    public void printNomeJogo(JogoDados jogoAux, int j){
        System.out.println("Jogo " + (j + 1) + " : " + jogoAux.getNomeJogo());
    }

    public void executarRodadasApostas(){
        Scanner sc = new Scanner(System.in);
            for (int i = 0; i < this.getQtdParticipantes(); i++){
                if(this.getJogadores()[i].getSaldo() > 0) {
                    if (this.getJogadores()[i] instanceof Humano) {
                        Humano jogadorAux = (Humano) this.getJogadores()[i];
                        System.out.println("\n\nVez do Jogador: " + jogadorAux.getNome());
                        if (this.verificaJogadasLivre(jogadorAux)) {
                            System.out.println("Saldo disponivel: R$" + jogadorAux.getSaldo());
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
                            System.out.println("Informe o Jogo que deseja jogar:\n 1 - Jogo General e 2 - Jogo Azar.\n");
                            int auxTipoJogo = sc.nextInt();
                            if (auxTipoJogo == 1) {
                                rodadaJogoGeneralHumano(jogadorAux, initJogoGeneral(jogadorAux,auxAposta));
                            } else {
                                rodadaJogoAzar(jogadorAux,initJogoAzar(jogadorAux, auxAposta));
                            }
                        }else{
                            System.out.println("O Jogador não possui jogadas disponíveis !");

                        }
                    }else { //Jogador maquina
                        Maquina jogadorAux = (Maquina) this.getJogadores()[i];
                        System.out.println("Vez da Maquina: " + jogadorAux.getNome());
                        if (this.verificaJogadasLivre(jogadorAux)) {
                            int jogoRandom;
                            float auxAposta = (float) (Math.round((Math.random() * (jogadorAux.getSaldo() - 1)) * 100.0) / 100.0);
                            System.out.println("Saldo disponivel: R$" + jogadorAux.getSaldo());
                            System.out.println("O valor apostado foi de: R$" + auxAposta);
                            jogoRandom = (int) Math.floor(Math.random()*2)+1;
                            System.out.println("Informe o Jogo que deseja jogar:\n 1 - Jogo General e 2 - Jogo Azar.");
                            if(jogoRandom == 1){
                                rodadaJogoGeneralMaquina(jogadorAux, initJogoGeneral(jogadorAux,auxAposta));
                            } else {
                                rodadaJogoAzar(jogadorAux,initJogoAzar(jogadorAux, auxAposta));

                            }
                        }
                    }
                }else{
                    System.out.println(this.getJogadores()[i].getNome() + " não possui saldo sulficiente para jogar !");
                }
            }
            if(this.getQtdParticipantes() == 0){
                System.out.println("Não há jogadores no campeonato!");
            }

    }

    public JogoGeneral initJogoGeneral(Jogador jogadorAux, float auxAposta){
        JogoGeneral novoJogoGeneral = new JogoGeneral();
        jogadorAux.setJogo(novoJogoGeneral,jogadorAux.getnJogadas());
        novoJogoGeneral.setAposta(auxAposta);
        System.out.println("Jogando Jogo General !");
        return novoJogoGeneral;
    }

    public JogoAzar initJogoAzar (Jogador jogadorAux, float auxAposta){
        JogoAzar novoJogoAzar = new JogoAzar();
        jogadorAux.setJogo(novoJogoAzar,jogadorAux.getnJogadas());
        novoJogoAzar.setAposta(auxAposta);
        System.out.println("Jogando Jogo Azar !");
        return novoJogoAzar;
    }

    public void rodadaJogoAzar(Jogador jogadorAux, JogoAzar jogoAux){
        float resultSaldo;
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
        System.out.println();
    }

    public void rodadaJogoGeneralHumano (Humano jogadorAux, JogoGeneral jogoAux) {
        float resultSaldo;
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
        System.out.println();
    }

    public void rodadaJogoGeneralMaquina(Maquina jogadorAux, JogoGeneral jogoAux){
        float resultSaldo;
        for(int i = 0; i < 13; i++ ) {
            System.out.print("Quantidade de  jogadas realizadas: " + i + "\n");
            jogadorAux.jogarDados(1);
            jogoAux.jogadaExecutada();
            jogadorAux.aplicarEstrategia(jogoAux);
            System.out.println("-------------------------------------------------------------");
        }
        jogadorAux.setnJogadas(jogadorAux.getnJogadas() + 1);
        jogoAux.jogadaExecutada();
        resultSaldo = jogoAux.logicaResultado();
        jogadorAux.setSaldo(jogadorAux.getSaldo() + resultSaldo);
        System.out.println("Seu saldo atual é: R$" + jogadorAux.getSaldo());
        System.out.println();
    }

    public boolean verificaJogadasLivre (Jogador jogadorAux){
        return jogadorAux.getnJogadas() < 10;
    }

    public void imprimeSaldo(int tipo){
        System.out.println("-------SALDOS---------");
        switch (tipo) {
            case 1 -> {
                for (int i = 0; i < this.getQtdParticipantes(); i++) {
                    Jogador jogadorAux = this.getJogadores()[i];
                    System.out.println(jogadorAux.getNome() + " possui R$ " + jogadorAux.getSaldo());
                }
            }
            case 2 -> {
                for (int i = 0; i < this.getQtdParticipantes(); i++) {
                    Jogador jogadorAux = this.getJogadores()[i];
                    if (jogadorAux instanceof Humano) {
                        System.out.println(jogadorAux.getNome() + " possui R$ " + jogadorAux.getSaldo());
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < this.getQtdParticipantes(); i++) {
                    Jogador jogadorAux = this.getJogadores()[i];
                    if (jogadorAux instanceof Maquina) {
                        System.out.println(jogadorAux.getNome() + " possui R$ " + jogadorAux.getSaldo());
                    }
                }
            }
        }
        System.out.println("----------------");

    }

    public float calcSaldo(int partida, Jogador jogadorAux){
        float saldoPartida = jogadorAux.getSaldo();
        for (int i = jogadorAux.getnJogadas()-1; i >= partida; i--) {
            if(jogadorAux.getJogo()[i].isResultado()) {
                saldoPartida = saldoPartida - jogadorAux.getJogo()[i].getAposta();
            }else {
                saldoPartida = saldoPartida + jogadorAux.getJogo()[i].getAposta();
            }
        }
        return  (float) (Math.round(saldoPartida * 100.0) / 100.0);
    }



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
            System.err.println("Erro: " + e);
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
            System.err.println("Erro: " + e);
        }

    }


    public Jogador[] getJogadores() {
        return jogadores;
    }

      public int getQtdParticipantes() {
        return qtdParticipantes;
    }

    public void setQtdParticipantes(int qtdParticipantes) {
        this.qtdParticipantes = qtdParticipantes;
    }

    public void setJogadores(Jogador jogadores,int posicao) {
        this.jogadores[posicao] = jogadores;
    }

}
