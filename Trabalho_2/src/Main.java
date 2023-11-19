import java.util.Scanner;
import java.io.Serializable;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        Campeonato c = new Campeonato();

        do{
            System.out.println("..:: Menu Interativo ::..");
            System.out.println("1 - Incluir jogador");
            System.out.println("2 - Remover jogador");
            System.out.println("3 - Executar rodada");
            System.out.println("4 - Imprimir Saldos");
            System.out.println("5 - Imprimir extratos dos resultados");
            System.out.println("6 - Imprimir estatísticas");
            System.out.println("7 - Gravar dados");
            System.out.println("8 - Ler dados");
            System.out.println("9 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    c.incluirJogador();
                    break;
                case 2:
                    c.removerJogador();
                    break;
                case 3:
                    c.executarRodadasApostas();
                    break;
                case 4:
                    int opcao2 = 0;
                    System.out.println("Você deseja visualizar o saldo de qual tipo de jogadores ?\n" +
                            "Digite a opcao desejada:\n" +
                            "1- Para todos os jogadores;\n" +
                            "2- Apenas para os jogadores Humanos;\n" +
                            "3- Apenas para os jogadores Maquina;");
                    opcao2 = sc.nextInt();
                    c.imprimeSaldo(opcao2);
                    break;
                case 5:
                    int opcao3 = 0;
                    int opcao4 = 0;
                    System.out.println("Você deseja visualizar o extrato para qual jogo ?" +
                            "\nDigite a opcao desejada:\n" +
                            "1- Para todos os jogos;\n" +
                            "2- Apenas para o Jogo General;\n" +
                            "3- Apenas para o Jogo de Azar;");
                    opcao3 = sc.nextInt();
                    System.out.println("Você deseja visualizar o extrato de qual tipo de jogadores ?\n" +
                            "Digite a opcao desejada:\n" +
                            "1- Para todos os jogadores;\n" +
                            "2- Apenas para os jogadores Humanos;\n" +
                            "3- Apenas para os jogadores Maquina;");
                    opcao4 = sc.nextInt();
                    c.imprimirExtratosDosResultados(opcao3,opcao4);
                    break;
                case 6:
                    break;
                case 7:
                    c.gravarEmArquivo();
                    break;
                case 8:
                    c.lerDeArquivo();
                    break;
                case 9:

                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 9);

    }
}