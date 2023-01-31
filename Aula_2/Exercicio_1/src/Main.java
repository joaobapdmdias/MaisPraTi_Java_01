public class Main {
    public static void main(String[] args) throws Exception {
        Jogador bom = new Jogador("Suarez");
        Jogador ruim = new Jogador("Alemão");

        bom.adicionarGol(30);
        bom.adicionarAssistencia(23);
        
        ruim.adicionarGol(3);
        ruim.adicionarAssistencia(2);

        System.out.println("Para o jogador " + ruim.nome + ", ");
        ruim.verGol();
        ruim.verAssistencia();

        System.out.println("Para o jogador " + bom.nome + ", ");
        bom.verGol();
        bom.verAssistencia();
    }
}
