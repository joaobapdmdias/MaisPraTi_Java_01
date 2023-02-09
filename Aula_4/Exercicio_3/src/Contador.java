public class Contador extends Funcionario {
    
    public Contador(String nome) {
        this.valorBonificacao = 0.03;
        this.nome = nome;
    }

    public double totalReceber() {
        return (this.valorHora + this.totalHoras) * (1 + this.valorBonificacao);
    }
}
