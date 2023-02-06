import java.util.Scanner;

public class Itens {
    String item;
    double valor;

    public Itens () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do item");
        this.item = scanner.next();
        System.out.println("Digite o valor do item " + this.item);
        this.valor = scanner.nextDouble();
    }
}
