public class Complexo {
    private int real;
    private int imagi;
    public  Complexo (){
        real = 0;
        imagi = 0;
    }
    public Complexo(int r){
        this.real = r;
        this.imagi = 0;
    }
    public Complexo(int r, int i){
        this.real = r;
        this.imagi = i;

    }
    void inicializaNumero (int r, int i){
        this.real = r;
        this.imagi=i;
    }
    void imprimeNumero(){
        System.out.println(this.real + "+" + this.imagi + " i");
    }
    boolean eIgual(Complexo c){
        if(this.real == c.real && this.imagi == c.imagi)
            return true;
        else
            return false;
    }
    void soma(Complexo c){
         double a,b;
        a = this.real + c.real;
        b = this.imagi + c.imagi;
        System.out.println(a + "+" + b + " i");
    }
    void subtrai(Complexo c){
        double a,b;
        a = this.real - c.real;
        b = this.imagi - c.imagi;
        System.out.println(a + "+" + b + " i");
    }
    void multiplica(Complexo c){
        double a,b;
        a = (this.real * c.real) - (this.imagi *c.imagi);
        b = (this.real * c.imagi) + (this.imagi * c.real);
        System.out.println(a + "+" + b + " i");
    }
    void divide(Complexo c){
        double a,b;
        a = ((this.real*c.real)+(this.imagi*c.imagi))/(Math.pow(c.real,2) + Math.pow(c.imagi,2));
        b =  ((this.imagi*c.real)-(this.real*c.imagi))/(Math.pow(c.real,2) + Math.pow(c.imagi,2));
        System.out.println(a + "+" + b + " i");
    }


}
