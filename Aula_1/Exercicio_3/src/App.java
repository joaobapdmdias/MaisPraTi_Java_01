import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        
        float salario_bruto, salario_liquido;

        Locale locale = new Locale("en", "US");
        Locale.setDefault(locale);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o salário bruto (em reais): ");
        salario_bruto = scanner.nextFloat();

        if (salario_bruto < 1000) {
            salario_liquido = salario_bruto * 0.94f;
        }
        else if (salario_bruto < 2500) {
            salario_liquido = salario_bruto * 0.92f;
        }
        else if (salario_bruto < 4800) {
            salario_liquido = salario_bruto * 0.9f;
        }
        else {
            salario_liquido = salario_bruto * 0.85f;
        }

        System.out.println("O salário líquido é R$" + salario_liquido);
    }
}
