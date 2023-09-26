import javax.sound.midi.Soundbank;
import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String cpf;
    private  int posicao;

    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf  = cpf;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void imprimirDados(){
        System.out.printf("Nome: " + nome + " " + "CPF: " + cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }
}
