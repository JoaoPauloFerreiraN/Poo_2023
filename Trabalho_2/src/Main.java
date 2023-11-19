import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

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
            System.out.println();
            switch (opcao) {
                case 1 -> c.incluirJogador();
                case 2 -> c.removerJogador();
                case 3 -> c.executarRodadasApostas();
                case 4 -> {
                    int opcao2;
                    System.out.println("""
                            Você deseja visualizar o saldo de qual tipo de jogadores ?
                            Digite a opcao desejada:
                            1- Para todos os jogadores;
                            2- Apenas para os jogadores Humanos;
                            3- Apenas para os jogadores Maquina;""");
                    opcao2 = sc.nextInt();
                    c.imprimeSaldo(opcao2);
                }
                case 5 -> {
                    int opcao3;
                    int opcao4;
                    System.out.println("""
                            Você deseja visualizar o extrato para qual jogo ?
                            Digite a opcao desejada:
                            1- Para todos os jogos;
                            2- Apenas para o Jogo General;
                            3- Apenas para o Jogo de Azar;""");
                    opcao3 = sc.nextInt();
                    System.out.println("""
                            Você deseja visualizar o extrato de qual tipo de jogadores ?
                            Digite a opcao desejada:
                            1- Para todos os jogadores;
                            2- Apenas para os jogadores Humanos;
                            3- Apenas para os jogadores Maquina;""");
                    opcao4 = sc.nextInt();
                    c.imprimirExtratosDosResultados(opcao3, opcao4);
                }
                case 6 -> {
                    int opcao5;
                    System.out.println("""
                            Como deseja visualizar as estatisticas ?
                            Digite a opcao desejada:
                            1- Por jogador;
                            2- Por jogos escolhidos por cada jogador;
                            3- Total por jogos;
                            4- Total do campeonato;""");
                    opcao5 = sc.nextInt();
                    c.imprimeEstatisticas(opcao5);
                }
                case 7 -> c.gravarEmArquivo();
                case 8 -> c.lerDeArquivo();
                case 9 -> System.out.println();
                default -> System.out.println("Opção inválida!");
            }
        }while(opcao != 9);

    }
}