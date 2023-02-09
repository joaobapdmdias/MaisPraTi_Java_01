import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Programador programador = new Programador("João");
        Administrador administrador = new Administrador("Hélio");
        Contador contador = new Contador("Márcia");

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios.add(programador);
        funcionarios.add(administrador);
        funcionarios.add(contador);        

        for (Funcionario funcionario : funcionarios) {
            System.out.println("O total a receber por " + funcionario.getNome() + " é " + funcionario.totalReceber());
        }


    }
}
