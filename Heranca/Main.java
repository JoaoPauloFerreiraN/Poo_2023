public class Main {
    public static void main(String[] args) {
        Quadrilatero quadrilatero = new Quadrilatero(0, 0, 0, 1, 1, 0, 1, 1);
        Trapezio trapezio = new Trapezio(0, 0, 0, 2, 1, 1, 2, 0);
        Paralelogramo paralelogramo = new Paralelogramo(0, 0, 0, 2, 1, 1, 1, 3);
        Retangulo retangulo = new Retangulo(0, 0, 0, 2, 2, 0, 2, 2);
        Quadrado quadrado = new Quadrado(0, 0, 0, 1, 1, 0, 1, 1);

        System.out.println("area do Trapezio: " + trapezio.calculararea());
        System.out.println("area do Paralelogramo: " + paralelogramo.calculararea());
        System.out.println("area do Retangulo: " + retangulo.calculararea());
        System.out.println("area do Quadrado: " + quadrado.calculararea());
    }
}
