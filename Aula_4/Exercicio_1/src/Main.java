import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

        listaFuncionarios.add(new Funcionario("Fulano", "assistente administrativo"));
        listaFuncionarios.add(new Funcionario("Ciclano", "gerente"));
        listaFuncionarios.add(new Funcionario("Beltrano", "escrivão"));
        listaFuncionarios.add(new Funcionario("Dunha", "operador logístico"));
        listaFuncionarios.add(new Funcionario("Joãozinho", "estudante"));
        listaFuncionarios.add(new Funcionario("Amanda", "secreteraria"));
        listaFuncionarios.add(new Funcionario("Renata", "scrum master"));
        listaFuncionarios.add(new Funcionario("Emerson", "programador"));
        listaFuncionarios.add(new Funcionario("Amaral", "diretor"));
        listaFuncionarios.add(new Funcionario("Carol", "supervisora"));

        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario);
        }
    }
}
