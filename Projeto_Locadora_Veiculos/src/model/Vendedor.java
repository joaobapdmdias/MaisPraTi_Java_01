package model;

public class Vendedor extends Pessoa {
    private int vendas;
    private double salario, comissao;
    public static final double BONIFICACAO = 0.05;

    public Vendedor(String nome, String endereco, String cpf, String senha, double salario) {
        super(nome, endereco, cpf, senha);
        this.salario = salario;
    }
    
    public int getVendas() {
        return vendas;
    }
    public void addVendas() {
        vendas++;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public String toString() {
        return super.getId() + "-" + super.getNome(); 
    }
}
