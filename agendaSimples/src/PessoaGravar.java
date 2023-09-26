import java.io.*;


public class PessoaGravar implements Serializable {
    private Pessoa [] a =  new Pessoa[200];
    private int tamanho;

    void incluir (Pessoa p ){
        if(tamanho <= 200 ) {
            this.a[tamanho] = p;
            p.setPosicao(tamanho);
            tamanho++;
            System.out.print("Pessoa adicionada na agenda com sucesso");
        }else{
            System.out.printf("Agenda Lotada!");
        }

    }

    void listar (){
        for(Pessoa p : a){
            if (p != null) {
                p.imprimirDados();
                System.out.print("\n");
            }
        }
    }

    void delete(String nome){
        for(Pessoa b : a){
            if(b != null ) {
                if (nome.equals(b.getNome())) {
                    this.a[b.getPosicao()] = null;
                    this.tamanho--;
                    System.out.printf("Deletado\n");
                } else {
                    System.out.printf("Nome não encontrado!");
                }
            }
        }
    }

    void gravar (){
        File arquivo = new File("agenda.data");
        try{
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(this);

            oos.flush();
            oos.close();
            fout.close();

            System.out.println("Gravado com sucesso!");

        } catch (Exception erro) {
            System.out.println("eroo: " + erro.toString());
        }
    }


}
