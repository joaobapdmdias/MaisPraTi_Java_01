public class ContaSalario implements ContaBancaria{
    private double saldo;
    private String titular;

    public ContaSalario (String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    public ContaSalario (String titular) {
        this.titular = titular;
    }
    
    @Override
    public void sacar(double valor) {
        System.out.println("Sacando " + valor + " reais");
        this.saldo -= valor;
    }
    @Override
    public void verExtrato() {
        System.out.println("saldo: " + saldo);
        System.out.println("titular: " + titular);
        System.out.println("tipo de conta: conta salário");
        
    }
    @Override
    public void depositar(double valor) {
        
        System.out.println("Depositando " + valor + " reais");
        this.saldo += valor;

        
    }
    
    
}
