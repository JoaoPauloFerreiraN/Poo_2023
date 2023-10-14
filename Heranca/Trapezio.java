class Trapezio extends Quadrilatero {
    public Trapezio(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    @Override
    public double calculararea() {
        // Implemente o calculo da area de um trapezio aqui.
        double baseMaior = Math.sqrt(Math.pow(this.getX1() - this.getX2(), 2) + Math.pow(this.getY1() - this.getY2(), 2));
        double baseMenor = Math.sqrt(Math.pow(this.getX3() - this.getX4(), 2) + Math.pow(this.getY3() - this.getY4(), 2));
        double altura = Math.abs(this.getY1() - this.getY3());
        return 0.5 * (baseMaior + baseMenor) * altura;
    }
}

