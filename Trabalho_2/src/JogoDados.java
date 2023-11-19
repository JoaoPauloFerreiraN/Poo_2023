
//Classe JogoDados: Herdada por General ou Azar e implementa estatistica;
import java.io.Serializable;

abstract class JogoDados implements Estatistica, Serializable {
    private int nDados;
    private String  nomeJogo;
    private float aposta;
    private Dado[] dados;
    private boolean resultado; // true = venceu  false= perdeu
    private int[] dadosEstatistic;

    public JogoDados (int nD, String nJ){
        this.nomeJogo = nJ;
        this.nDados = nD;
        this.dados = new Dado[nD];
        for (int i = 0; i < nD; i++){
            this.dados[i] = new Dado();
        }
        dadosEstatistic = new int[numFaces];
    }

    //Metodo para rolar e organizar os dados em ordem crescente para melhor visualização.
   abstract public void rolarDados();

    //Metodo para imprimir os dados.
    abstract public void listarDados();

    abstract public void jogadaExecutada();

    //Metodo para organizar os dados em ordem crescente para melhor visualização.
    public void sortDados(int x){
        int aux;
        if (x == 1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    if (this.getDados()[j].getSideUP() > this.getDados()[j + 1].getSideUP()) {
                        aux = this.getDados()[j].getSideUP();
                        this.getDados()[j].setSideUP(this.getDados()[j + 1].getSideUP());
                        this.getDados()[j + 1].setSideUP(aux);
                    }
                }
            }
        }else{
            if(this.getDados()[0].getSideUP() > this.getDados()[1].getSideUP()){
                aux = this.getDados()[0].getSideUP();
                this.getDados()[0].setSideUP(this.getDados()[1].getSideUP());
                this.getDados()[1].setSideUP(aux);
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

    public void setAposta(float aposta){ this.aposta = aposta;}

    public float getAposta(){ return aposta;}

    public Dado[] getDados() {
        return dados;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public int[] getDadosEstatistic() {
        return dadosEstatistic;
    }

    public void setDadosEstatistic(int[] dadosEstatistic) {
        this.dadosEstatistic = dadosEstatistic;
    }


    @Override
    public void somarFacerSorteadas(int[] estatistica) {
        int face;
        for(int i = 0; i < getnDados(); i++){
            face = this.getDados()[i].getSideUP();
            estatistica[face-1]+=1;
        }
        setDadosEstatistic(estatistica);
    }

    @Override
    public void imprimeEstatisticas() {
        for (int i = 0; i < numFaces; i++){
            System.out.println((i+1) + ":" + getDadosEstatistic()[i]);
        }
    }

    abstract public float logicaResultado();
}
