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

    //Printa a cartela na tela
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

}
