public class Banco {
    private ContaBancaria2 [] banc = new ContaBancaria2[10];
    private double result = 0;

    public Banco (ContaBancaria2[] contas){
        this.banc = contas;
    }
    void total () {
        int i = 0;
        for (ContaBancaria2 b : banc) {
            result += b.getSaldo();
            i++;
        }
    }

    public double getSaldoTotal() { return result; }


}
