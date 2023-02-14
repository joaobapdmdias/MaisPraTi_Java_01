public interface ContaBancaria {
    public void sacar(double valor) throws ContaException;
    public void verExtrato();
    public void depositar(double valor) throws ContaException;
}