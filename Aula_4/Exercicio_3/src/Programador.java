public class Programador extends Funcionario {
    
    public Programador(String nome) {
        this.valorBonificacao = 0.05;
        this.nome = nome;
    }

    public double totalReceber() {
        return (this.valorHora + this.totalHoras) * (1 + this.valorBonificacao);
    }
}
