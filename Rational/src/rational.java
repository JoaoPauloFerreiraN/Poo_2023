public class rational {
    private int numerator, denominator;
    private float ratio;

    public rational (){
        denominator = 1;
        numerator =0;
    }

    public rational (int n){
        denominator = 1;
        numerator = n;
    }

    public rational (int n , int d){
        rational r = new rational();
        r.numerator = n;
        r.denominator = d;
        r = reduzir(r);
        this.numerator = r.numerator;
        this.denominator = r.denominator;
    }

    void somar(rational r){
        rational j = this;
        if(this.denominator == r.denominator){
            j.numerator += r.numerator;
            j = reduzir(j);
            this.numerator = j.numerator;
            this.denominator = j.denominator;
        }else{
            j.numerator = ((j.numerator*r.denominator)+(j.denominator*r.numerator));
            j.denominator = (r.denominator* j.denominator);
            j = reduzir(j);
            this.numerator = j.numerator;
            this.denominator = j.denominator;
        }
    }

    void subtrair (rational r){
        rational j = this;
        if(this.denominator == r.denominator){
            j.numerator -= r.numerator;
            j = reduzir(j);
            this.numerator = j.numerator;
            this.denominator = j.denominator;
        }else{
            j.numerator = ((j.numerator*r.denominator)-(j.denominator*r.numerator));
            j.denominator = (r.denominator* j.denominator);
            j = reduzir(j);
            this.numerator = j.numerator;
            this.denominator = j.denominator;
        }

    }

    void multiplicar (rational r){
        rational j = this;
        j.denominator = j.denominator*r.denominator;
        j.numerator = j.numerator*r.numerator;
        j = reduzir(j);
        this.numerator = j.numerator;
        this.denominator = j.denominator;
    }

    void dividir (rational r){
        rational j = new rational();
        j.denominator = r.numerator;
        j.numerator = r.denominator;
        j.multiplicar(this);
        this.numerator = j.numerator;
        this.denominator = j.denominator;
    }

    private rational reduzir( rational r){
        if (r.numerator % r.denominator == 0 || r.denominator % r.numerator == 0 ) {
            if (Math.abs(r.numerator) > Math.abs(r.denominator)) {
                r.numerator = r.numerator /Math.abs( r.denominator);
                r.denominator = r.denominator/Math.abs(r.denominator);
            } else {
                r.denominator = r.denominator /Math.abs( r.numerator);
                r.numerator = r.numerator/Math.abs(r.numerator);
            }
        }
        return r;
    }

    private void ration(){
        ratio = (float)numerator/(float)denominator;
    }

    void imprimir (){
        System.out.println(this.numerator+"/"+this.denominator);
        this.ration();
        System.out.println("Esse número em ponto flutuante é:");
        System.out.printf("%.5f\n", ratio);
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}
