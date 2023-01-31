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

    public void notas() {
        
        double min, max;

        if (this.nota1 < this.nota2) {
            min = this.nota1;
            max = this.nota2;
        }
        else {
            min = this.nota2;
            max = this.nota1;
        }

        if (this.nota3 < min) {
            min = this.nota3;
        } 
        else if (this.nota3 > max) {
            max = this.nota3;
        }

        System.out.println("O nome do aluno é: " + this.nome);
        System.out.println("A sua maior nota foi: " + max);
        System.out.println("A sua menor nota foi: " + min);
        System.out.println("A sua média foi: " + (this.nota1 + this.nota2 + this.nota3) / 3);
    }
}
