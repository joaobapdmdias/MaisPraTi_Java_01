import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre com o número de posições");
        int posicoes = entrada.nextInt();

        int[] dados = new int[posicoes];

        for(int i = 0; i < dados.length; i++) {
            System.out.println("Entre com o próximo número");
            dados[i] = entrada.nextInt();
        }

        System.out.println("Entre com operação:");
        System.out.println("1 - listar em order");
        System.out.println("2 - listar invertido");
        System.out.println("3 - exibir números menores que 5");
        System.out.println("4 - exibir até primeiro numero menor que 5");

        int operacao = entrada.nextInt();
        switch(operacao) {
            case 1:
                for(int i = 0; i < dados.length; i++) {
                    System.out.println(dados[i]);
                }
                break;
            case 2:
                for(int i = dados.length-1; i >= 0; i--) {
                    System.out.println(dados[i]);
                }
                break;
            case 3:
                for(int i = 0; i < dados.length; i++) {
                    if (dados[i] >= 5) {
                        continue;
                    }
                    System.out.println(dados[i]);
                }
                break;
            case 4:
                for(int i = 0; i < dados.length; i++) {
                    if (dados[i] >= 5) {
                        break;
                    }
                    System.out.println(dados[i]);
                }
                break;
            default:
                System.out.println("comando inválido");
        }
    entrada.close();
    }
}
