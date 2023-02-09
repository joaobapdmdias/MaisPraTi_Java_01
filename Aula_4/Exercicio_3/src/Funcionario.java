public abstract class Funcionario {
    protected String nome;
    protected double valorHora;
    protected double totalHoras;
    protected double valorBonificacao;

    public Funcionario() {
        this.nome = "Jão";
        this.valorHora = 15;
        this.totalHoras = 40;
    }

    public abstract double  totalReceber();

    public String getNome() {
        return this.nome;
    }

}
