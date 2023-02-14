public class ContaCorrente implements ContaBancaria{
    private double saldo;
    private String titular;

    public ContaCorrente (String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    public ContaCorrente (String titular) {
        this.titular = titular;
    }
    
    @Override
    public void sacar(double valor) throws ContaException {
        System.out.println("Sacando " + valor + " reais");
        if (this.saldo - valor - 10 < 0) {
            throw new ContaException("Operação cancelada, saldo insuficiente");
        }
        else {
            this.saldo -= valor;
            this.saldo -= 10;  /* taxa */
        }
    }
    @Override
    public void verExtrato() {
        System.out.println("saldo: " + saldo);
        System.out.println("titular: " + titular);
        System.out.println("tipo de conta: conta corrente");
        
    }
    @Override
    public void depositar(double valor) throws ContaException{
        double acrescimo;
        
        System.out.println("Depositando " + valor + " reais");

        if (valor <= 10000) {
            acrescimo = 0.01;
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
