import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String continuar = "";
        String nome;
        double nota;
        long matricula;
        Scanner scanner = new Scanner(System.in);
        HashMap<Long, Aluno> alunos = new HashMap<>();

        do {
            System.out.println("Entre com o nome do aluno");
            scanner.next();
            nome = scanner.nextLine();
            System.out.println("Entre com a nota do aluno");
            nota = scanner.nextDouble();
            System.out.println("Entre com a matricula do aluno");
            matricula = scanner.nextLong();
            alunos.put(matricula, new Aluno(nome, nota, matricula));
            System.out.println("Pressione s para continuar inserido alunos, " +
                               "qualquer outra tecla para cancelar");
            continuar = scanner.next();
        }
        while (continuar.equals("s"));
        
        scanner.close();
    }
}
