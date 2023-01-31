public class Jogador {
    String nome;
    int gols;
    int assistencias;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void adicionarGol(int gols) {
        this.gols = gols;
    }
    public void adicionarAssistencia(int assistencias) {
        this.assistencias = assistencias;
    }

    public void verGol() {
        System.out.println("O número de gols é: " + this.gols);
    }
    public void verAssistencia() {
        System.out.println("O número de assistências é: " + this.assistencias);
    }
}
