import java.util.Scanner;

public class Aluno {
    private String nome;
    private long matricula;
    private double[] notas;
    private int contador;
    private Scanner scanner = new Scanner(System.in);

    public Aluno (String nome, long matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new double[3];
        this.contador = 0;
    }

    private void checaIntegridade(double nota) throws Exception{
        double sum = 0;

        for (int i = 0; i < this.contador; i++) {
            sum += this.notas[i];
        }
        if ((sum + nota) > 100 ) {
            throw new Exception("A Soma das notas supera 100.");
        }
    }

    private void atualizaNotas(double nota) {
        this.notas[this.contador] = nota;
        this.contador += 1;
        System.out.println("Nota " + this.contador + " = " + nota);
    }

    public void adicionarNota() {
        boolean adiciona = true;

        System.out.println(String.format("Insira a nota %d do aluno %s", this.contador + 1, this.nome));
        double nota = scanner.nextDouble();

        while (adiciona) {
            try {
                checaIntegridade(nota);
                atualizaNotas(nota);
                adiciona = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, insira um valor válido.");
                nota = scanner.nextDouble();
            }
        }
    }

}