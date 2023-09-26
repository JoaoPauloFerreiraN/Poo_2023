public class UsaContaBancaria2{
    public static void main(String[] args)
    {
        ContaBancaria2 fred = new ContaBancaria2("Fred",1000);
        ContaBancaria2 richard = new ContaBancaria2("Richard",2000);
        //System.out.println(fred);
        //System.out.println(richard);
        fred.transfereDe(richard,3000);
        //System.out.println(fred);
        //System.out.println(richard);
        ContaBancaria2[] contas = {fred, richard};
        Banco teste = new Banco(contas);

        teste.total();
        System.out.print("\n"+teste.getSaldoTotal());
    }
}