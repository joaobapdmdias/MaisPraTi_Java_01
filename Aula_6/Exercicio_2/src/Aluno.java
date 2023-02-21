public class Aluno {
    private String nome;
    private double nota;
    private long matricula;
    
    public Aluno(String nome, double nota, long matricula) {
        this.nome = nome;
        this.nota = nota;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
}