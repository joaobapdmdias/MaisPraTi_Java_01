public class Administrador extends Funcionario {
    
    public Administrador(String nome) {
        this.valorBonificacao = 0.06;
        this.nome = nome;
    }

    public double totalReceber() {
        return (this.valorHora + this.totalHoras) * (1 + this.valorBonificacao);
    }
}
