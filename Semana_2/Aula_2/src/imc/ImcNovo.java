package imc;

public class ImcNovo extends Imc {
    public ImcNovo(double peso, double altura) {
        super(peso, altura);
    }
    public String classificacao () {
        this.calculaImc();
        if (this.imc < 16) return "magreza grave";
        if (this.imc < 17) return "magreza moderada";
        if (this.imc < 18.5) return "magreza leve";
        if (this.imc < 25) return "saudável";
        if (this.imc < 30) return "sobrepeso";
        if (this.imc < 35) return "obesidade grau I";
        if (this.imc < 39.9) return "obesidade grau II";
        return "obesidade grau III";
    }
}
