public class Funcionario {
    private String nome;
    private String funcao;

    public Funcionario(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    public String toString() {
        return "Funcionario [nome=" + this.nome + ", funcao=" + this.funcao + "]";
    }
}
