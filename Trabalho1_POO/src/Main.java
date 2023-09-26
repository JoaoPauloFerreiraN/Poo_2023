import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        JogoGeneral j = new JogoGeneral();
       
       while(true){    
        j.rolarDados();
        j.listarDados();

        opcao = sc.nextInt();

        System.out.println(j.validarJogada(opcao));
        System.out.println(j.pontuarJogada(opcao));
       }
        // do{
        //     System.out.println("..:: Menu Interativo ::..");
        //     System.out.println("1 - Incluir jogador");
        //     System.out.println("2 - Remover jogador");
        //     System.out.println("3 - Executar rodada");
        //     System.out.println("4 - Exibir pontuação");
        //     System.out.println("5 - Gravar dados");
        //     System.out.println("6 - Ler dados");
        //     System.out.println("7 - Sair");
        //     System.out.print("Digite a opção desejada: ");
        //     opcao = sc.nextInt();

        //     switch (opcao) {
        //         case 1:
                    
        //             break;
        //         case 2:
                
        //             break;
        //         case 3:
                    
        //             break;
        //         case 4:
                
        //             break;
        //         case 5:
                    
        //             break;
        //         case 6:
                
        //             break;
        //         case 7:

        //             break;
        //         default:
        //             System.out.println("Opção inválida!");
        //             break;
        //     }
        // }while(opcao != 7);
    
    }
}