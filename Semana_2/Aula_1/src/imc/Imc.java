package imc;

public class Imc {
    public double peso;
    public double altura;
    public double imc;

    public Imc(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public void calculaImc() {
        this.imc = this.peso / (this.altura * this.altura);
    }
}
