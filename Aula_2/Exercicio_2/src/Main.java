public class Main {
    public static void main(String[] args) throws Exception {

        Aluno aluno = null;

        try {
            aluno = new Aluno("Joãozinho", 30, 20, 40);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        aluno.notas();

    }
}
