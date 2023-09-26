
public class Main {
    public static void main(String[] args) {
        Complexo c1, c2,c3;

        c1 = new Complexo();
        c2 = new Complexo(3,4);
        c3 = new Complexo();
        c1.inicializaNumero(1,2);
        c3.inicializaNumero(1,2);
        c1.imprimeNumero();
        c2.imprimeNumero();
        System.out.println(c1.eIgual(c2));
        System.out.println(c1.eIgual(c3));
        c1.soma(c2);
        c1.subtrai(c3);
        c1.multiplica(c2);
        c1.divide(c3);
    }
}