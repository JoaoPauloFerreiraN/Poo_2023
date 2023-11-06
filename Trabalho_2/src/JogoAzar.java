public class JogoAzar extends JogoDados{
    private float valorAposta;

    public JogoAzar(float vA) {
        super(2,"JogoAzar");
        setValorAposta(vA);
    }

    public float getValorAposta() {
        return valorAposta;
    }

    public void setValorAposta(float valorAposta) {
        this.valorAposta = valorAposta;
    }
    public void rolarDados(){
        for (int i = 0; i < 2; i++){
            this.getDados()[i].roll();
        }
        this.sortDados();
    }
    public void listarDados(){
        for (int i = 0; i < 2; i++){
            System.out.print(this.getDados()[i].getSideUP() + " ");
        }
        System.out.println();
    }

    @Override
    public void jogadaExecutada() {

    }


    @Override
    public String toString() {
        return "JogoAzar{" +
                "valorAposta=" + valorAposta +
                '}';
    }
}
