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
    public void sacar(double valor) throws ContaException {
        System.out.println("Sacando " + valor + " reais");
        if (this.saldo - valor < 0) {
            throw new ContaException("Operação cancelada, saldo insuficiente");
        }
        else {
            this.saldo -= valor;
        }
    }
    @Override
    public void verExtrato() {
        System.out.println("saldo: " + saldo);
        System.out.println("titular: " + titular);
        System.out.println("tipo de conta: conta salário");
        
    }
    @Override
    public void depositar(double valor) throws ContaException{
        
        System.out.println("Depositando " + valor + " reais");

        if (valor > 10000) {
            throw new ContaException("Operação cancelada, depósito acima de 10000");
        }
        else {
            this.saldo += valor;
        } 
    }
    
    
}
