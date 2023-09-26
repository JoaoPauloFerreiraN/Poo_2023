// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Ponto2D p1 = new Ponto2D(1,1);
        Ponto2D p2 = new Ponto2D(1,2);
        Ponto2D p3 = new Ponto2D(3,1);

        ArrayDePontos2D bancoPontos = new ArrayDePontos2D(4);

        bancoPontos.modifica(0,p1);
        bancoPontos.modifica(2,p2);
        bancoPontos.modifica(3,p3);

        System.out.printf(bancoPontos.toString());
    }
}
//
// public class ArrayDePontos2D {
//    private Ponto2D [] array;
//
//    public ArrayDePontos2D (int numMax){
//        array = new Ponto2D[numMax];
//    }
//
//    public int tamanho(){ return array.length;}
//
//    public void modifica(int posicao, Ponto2D ponto){
//        if((posicao >= 0) && (posicao < array.length)){
//            array[posicao] = ponto;
//        }
//    }
//
//    public Ponto2D valor(int posicao){
//        if((posicao >= 0) && (posicao < array.length)){
//            return array[posicao];
//        }
//        return null;
//    }
//
//    public String toString(){
//        String resultado = "O array tem " + array.length + " elementos: \n";
//        int interador = 0;
//        for(Ponto2D p : array){
//            resultado += array[interador]+" ";
//            interador++;
//        }
//        return resultado;
//    }
//}
