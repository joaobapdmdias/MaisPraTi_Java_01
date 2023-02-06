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

    public String classificacao() {
        this.calculaImc();
        if (this.imc < 18.5) return "magreza";
        if (this.imc < 24.9) return "normal";
        if (this.imc < 29.9) return "sobrepeso";
        if (this.imc < 39.9) return "obesidade";
        return "obesidade grave";
    }
}
