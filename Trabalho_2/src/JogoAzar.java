import java.io.Serializable;

public class JogoAzar extends JogoDados implements Serializable{
//    private float valorAposta;

    public JogoAzar() {
        super(2,"JogoAzar");
//        setValorAposta(vA);
    }

//    public float getValorAposta() {
//        return valorAposta;
//    }
//
//    public void setValorAposta(float valorAposta) {
//        this.valorAposta = valorAposta;
//    }
//
    public void rolarDados(){
        for (int i = 0; i < 2; i++){
            this.getDados()[i].roll();
        }
        this.sortDados(2);
    }

    public void listarDados(){
        System.out.print(this.getDados()[0].getSideUP());
        System.out.print(" e " + this.getDados()[1].getSideUP());
        System.out.println(" = " + calcSum());
        System.out.println();
    }

    public int calcSum (){
        return this.getDados()[0].getSideUP() + this.getDados()[1].getSideUP();
    }


    @Override
    public void jogadaExecutada() {

    }
    @Override
    public float logicaResultado(){
        float result = 1;
        if(this.isResultado()){
            result = this.getAposta();
        }else{
            result = -1 * this.getAposta();
        }
        return result;
    }
}
