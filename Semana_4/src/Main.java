import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String entrada;
        int tiros = 3;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid(10);


        while (loop && (grid.getNumInimigos() > 0) && tiros > 0) {
            System.out.println("Entre com as posições x, y ou FIM para sair");
            entrada = scanner.nextLine();
            if (entrada.equals("FIM")) break;
            int[] posicao = Arrays.stream(entrada.split(",")).mapToInt(n -> Integer.parseInt(n)).toArray();
            grid.alteraGrid(posicao);
            grid.mostraGrid();
            tiros--;
            System.out.println("Inimigos restantes: " + grid.getNumInimigos());
            System.out.println("Tiros restantes: " + tiros);
        }

        scanner.close();
    }
}
