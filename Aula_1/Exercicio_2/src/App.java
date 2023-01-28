import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Insira o número de maças compradas: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        float preco = 0.3f;
        if (num >= 12) {
            preco = 0.25f;
        }
        float total = num * preco;
        System.out.println("O preço total da compra é de: " + total);
    }
}
