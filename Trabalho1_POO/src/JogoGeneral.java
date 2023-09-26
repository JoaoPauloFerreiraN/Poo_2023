public class JogoGeneral {
    private Dados [] d;
//    private int jogadas;

    public JogoGeneral(){
        this.d = new Dados[5];
        for (int i = 0; i < 5; i++){
            this.d[i] = new Dados();
        }
    }
    public void rolarDados(){
        for (int i = 0; i < 5; i++){
            this.d[i].roll();
            System.out.printf(this.d[i].toString());
        }
    }

    public Dados[] getD() {
        return d;
    }
}
