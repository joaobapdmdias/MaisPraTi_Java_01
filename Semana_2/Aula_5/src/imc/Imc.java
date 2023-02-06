package imc;

public class Imc {
    private double peso;
    private double altura;
    protected double imc;

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        if (peso <= 0) return;
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Imc(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public void calculaImc() {
        this.imc = this.peso / (this.altura * this.altura);
    }
    public double getImc() {
        return this.peso / (this.altura * this.altura);
    }

    

    public String classificacao() {
        this.calculaImc();
        if (this.getImc() < 18.5) return "magreza";
        if (this.getImc() < 24.9) return "normal";
        if (this.getImc() < 29.9) return "sobrepeso";
        if (this.getImc() < 39.9) return "obesidade";
        return "obesidade grave";
    }
}
