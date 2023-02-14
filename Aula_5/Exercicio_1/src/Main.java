public class Main {
    public static void main(String[] args) throws Exception {
        ContaCorrente cc = new ContaCorrente("Joãozinho", 1000);
        ContaPoupanca cp = new ContaPoupanca("Mariazinha", 1000);
        ContaSalario cs = new ContaSalario("Lassi", 1000);

        cc.sacar(200);
        cc.depositar(400);
        cc.verExtrato();
        System.out.println("\n");
        cp.sacar(200);
        cp.depositar(400);
        cp.verExtrato();
        System.out.println("\n");
        cs.sacar(200);
        cs.depositar(400);
        cs.verExtrato();
    }
}
