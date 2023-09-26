import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        PessoaGravar agenda = new PessoaGravar();
        Scanner teclado = new Scanner(System.in);
        int opcao;
        do {
            System.out.printf("Digite:\n" +
                    "1 - Incluir pessoas\n" +
                    "2 - Listar pessoas\n" +
                    "3 - Excluir pessoa\n" +
                    "4 - Gravar agenda\n" +
                    "5 - Ler agenda\n" +
                    "6 - Sair do programa");
                    opcao = teclado.nextInt();
            switch (opcao){
                case 1:
                    String nome;
                    String cpf ;
                    System.out.print("Digite o nome:\n");
                    teclado.nextLine();
                    nome = teclado.nextLine();
                    System.out.print("Digite o CPF:\n");
                    cpf = teclado.nextLine();
                    Pessoa p = new Pessoa(nome,cpf);
                    agenda.incluir(p);
                    break;
                case 2:
                    agenda.listar();
                    break;
                case 3:
                    System.out.print("Digite o nome:\n");
                    teclado.nextLine();
                    nome = teclado.nextLine();
                    agenda.delete(nome);
                    break;
                case 4:
                    agenda.gravar();
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }while (opcao != 6);
    }
}