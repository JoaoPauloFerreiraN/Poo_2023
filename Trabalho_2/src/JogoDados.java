import java.io.Serializable;

//Classe JogoDados: Herdada por General ou Azar e implementa estatistica;
abstract class JogoDados implements Estatistica {
    private int nDados;
    private String  nomeJogo;
    private float saldo;
    private Dado[] dados;

    public JogoDados (int nD, String nJ){
        this.nomeJogo = nJ;
        this.nDados = nD;
        this.dados = new Dado[nD];
        for (int i = 0; i < nD; i++){
            assert this.dados != null;
            this.dados[i] = new Dado();
        }
    }

    //Metodo para rolar e organizar os dados em ordem crescente para melhor visualização.
   abstract public void rolarDados();

    //Metodo para imprimir os dados.
    abstract public void listarDados();

    abstract public void jogadaExecutada();

    //Metodo para organizar os dados em ordem crescente para melhor visualização.
    public void sortDados(){
        int aux;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 4; j++){
                if(this.getDados()[j].getSideUP() > this.getDados()[j+1].getSideUP()){
                    aux = this.getDados()[j].getSideUP();
                    this.getDados()[j].setSideUP(this.getDados()[j+1].getSideUP());
                    this.getDados()[j+1].setSideUP(aux);
                }
            }
        }
    }

    public boolean tipoDeJogo(){
        return this instanceof JogoGeneral;
    }

    public int getnDados() {
        return nDados;
    }

    public void setnDados(int nDados) {
        this.nDados = nDados;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Dado[] getDados() {
        return dados;
    }

    public void setDados(Dado[] dados) {
        this.dados = dados;
    }

    @Override
    public int somarFacerSorteadas(Dado[] x) {
        return 0;
    }
}
