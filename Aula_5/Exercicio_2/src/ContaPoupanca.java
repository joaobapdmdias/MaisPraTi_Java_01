public class ContaPoupanca implements ContaBancaria{
    private double saldo;
    private String titular;

    public ContaPoupanca (String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    public ContaPoupanca (String titular) {
        this.titular = titular;
    }
    
    @Override
    public void sacar(double valor) throws ContaException {
        System.out.println("Sacando " + valor + " reais");
        if (this.saldo - valor - 5 < 0) {
            throw new ContaException("Operação cancelada, saldo insuficiente");
        }
        else {
            this.saldo -= valor;
            this.saldo -= 5;  /* taxa */
        }
    }
    @Override
    public void verExtrato() {
        System.out.println("saldo: " + saldo);
        System.out.println("titular: " + titular);
        System.out.println("tipo de conta: conta poupança");
        
    }
    @Override
    public void depositar(double valor) throws ContaException{
        double acrescimo;
        
        System.out.println("Depositando " + valor + " reais");

        if (valor <= 10000) {
            acrescimo = 0.03;
        }
        else {
            acrescimo = 0;
        }

        if (valor > 10000) {
            throw new ContaException("Operação cancelada, depósito acima de 10000");
        }
        else {
            valor += acrescimo;
            this.saldo += valor;
        } 
    }
    
    
}
