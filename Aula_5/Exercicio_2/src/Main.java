import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        double valor = 4000;
        List<ContaBancaria> listaContas = new ArrayList<>();
        ContaCorrente cc = new ContaCorrente("Joãozinho", 0);
        ContaPoupanca cp = new ContaPoupanca("Mariazinha", 1000);
        ContaSalario cs = new ContaSalario("Lassi", 1000);
        
        listaContas.add(cc);
        listaContas.add(cp);
        listaContas.add(cs);

        for (ContaBancaria conta : listaContas) {
            try {
                conta.sacar(200);
                conta.depositar(valor);
                conta.verExtrato();
            }
            catch (ContaException e) {
                System.out.println("Atenção, seu código gerou um erro: " + e.getMessage());
            }
            finally {
                System.out.println("\n");
                valor += valor;
            }
        }
    }
}
