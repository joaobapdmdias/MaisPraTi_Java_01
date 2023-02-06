public class Aluno {
    String nome;
    double nota1;
    double nota2;
    double nota3;

    public Aluno(String nome, double nota1, double nota2, double nota3) throws IllegalArgumentException{
        if (nota1 + nota2 + nota3 > 100) {
            throw new IllegalArgumentException("Soma das notas pode chegar no máximo a 100, classe não criada.");
        }
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double[] minimax(double a, double b, double c) {
        double min, max;

        if (a < b) {
            min = a;
            max = b;
        }
        else {
            min = b;
            max = a;
        }
        if (c < min) {
            min = c;
        } 
        else if (c > max) {
            max = c;
        }

        double[] min_max = {min, max};

        return  min_max;
    }

    public void notas() {

        double[] min_max = this.minimax(this.nota1, this.nota2, this.nota3);

        System.out.println("O nome do aluno é: " + this.nome);
        System.out.println("A sua maior nota foi: " + min_max[1]);
        System.out.println("A sua menor nota foi: " + min_max[0]);
        System.out.println("A sua média foi: " + (this.nota1 + this.nota2 + this.nota3) / 3);
    }
}
