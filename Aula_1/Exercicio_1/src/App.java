import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        float a, b, c, max, min;
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        a = scanner.nextFloat();
        System.out.println("Digite um valor: ");
        b = scanner.nextFloat();
        System.out.println("Digite um valor: ");
        c = scanner.nextFloat(); 
        
        scanner.close();

        if (a < b) {
            min = a;
            max = b;
        }
        else {
            min = b;
            max = a;
        }

        if (c < min) {
            min = c;
        } 
        else if (c > max) {
            max = c;
        }

        System.out.println("O maior valor é: " + max);
        System.out.println("O menor valor é: " + min);
    }
}
