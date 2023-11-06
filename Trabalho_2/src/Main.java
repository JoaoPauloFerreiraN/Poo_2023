import java.util.Scanner;

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
            System.out.println("4 - Exibir pontuação");
            System.out.println("5 - Gravar dados");
            System.out.println("6 - Ler dados");
            System.out.println("7 - Sair");
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
                    //c.executarRodada();
                    break;
                case 4:
//                    c.mostrarCartela();
                    break;
                case 5:
                    c.gravarEmArquivo();
                    break;
                case 6:
                    c.lerDeArquivo();
                    break;
                case 7:

                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opcao != 7);

    }
}