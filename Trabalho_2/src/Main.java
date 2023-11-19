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
                    System.out.println("Digite a opcao desejada:\n1-Para todos os jogadores;\n" +
                            "2- Apenas para os jogadores Humanos;\n" +
                            "3- Apenas para os jogadores Maquina;");
                    opcao2 = sc.nextInt();
                    c.imprimeSaldo(opcao2);
                    break;
                case 5:
                    c.imprimirExtratosDosResultados();
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