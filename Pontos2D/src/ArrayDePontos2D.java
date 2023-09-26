public class ArrayDePontos2D {
    private Ponto2D [] array;

    public ArrayDePontos2D (int numMax){
        array = new Ponto2D[numMax];
    }

    public int tamanho(){ return array.length;}

    public void modifica(int posicao, Ponto2D ponto){
        if((posicao >= 0) && (posicao < array.length)){
            array[posicao] = ponto;
        }
    }

    public Ponto2D valor(int posicao){
        if((posicao >= 0) && (posicao < array.length)){
            return array[posicao];
        }
        return null;
    }

    public String toString(){
        String resultado = "O array tem " + array.length + " elementos: \n";
        for(Ponto2D p : array){
            resultado += p;
        }
        return resultado;
    }
}
