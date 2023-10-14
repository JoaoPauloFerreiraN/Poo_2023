class Quadrilatero {
    private double x1, y1, x2, y2, x3, y3, x4, y4;

    public Quadrilatero(double x1, double y1, double x2, double y2, double x3, double y3, double x4,double y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }
    
    public double calculararea() {
        // Implemente o calculo da area de um quadrilatero aqui (por exemplo, usando a fórmula de area de Shoelace).
        return Math.abs(0.5 * ((x1 * y2 + x2 * y3 + x3 * y4 + x4 * y1) - (y1 * x2 + y2 * x3 + y3 * x4 + y4 * x1)));
    }

    public double getX1 (){
        return this.x1;
    }
    public double getX2 (){
        return this.x2;
    }
    public double getX3 (){
        return this.x3;
    }
    public double getX4 (){
        return this.x4;
    }
    public double getY1 (){
        return this.y1;
    }
    public double getY2 (){
        return this.y2;
    }
    public double getY3 (){
        return this.y3;
    }
    public double getY4 (){
        return this.y4;
    }

}

