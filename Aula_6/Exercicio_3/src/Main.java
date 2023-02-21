import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        int opcao;
        Scanner sc = new Scanner(System.in);
        List<Compra> compras = new ArrayList<>();

        compras.add(new Compra("bolsa", LocalDate.parse("2021-10-10")));
        compras.add(new Compra("saia", LocalDate.parse("2021-08-05")));
        compras.add(new Compra("bermuda", LocalDate.parse("2023-03-12")));

        do {
            System.out.println("\nEscolha a acao a ser tomada:");
            System.out.println("1 - Inserir uma nova compra");
            System.out.println("2 - Ver as compras em um dia específico");
            System.out.println("3 - Sair do sistema e finalizar\n");
            opcao = sc.nextInt(); 
            switch (opcao) {
                case 1:
                    // inserir nova compra
                    System.out.println("Descrição da compra: ");
                    sc.nextLine();
                    String descricao = sc.nextLine();
                    System.out.println("Insira a data em que a compra foi feita no padrão YYYY-MM-DD");
                    String dataCompraString = sc.nextLine();
                    try {
                        LocalDate dataCompra = LocalDate.parse(dataCompraString);
                        compras.add(new Compra(descricao, dataCompra));
                    } catch (DateTimeParseException e) {
                        System.out.println("Entrada invalida. Use o formato YYYY-MM-DD e uma data existente.");
                    }
                    break;
                case 2:
                    // ver compras em algum dia especifico
                    System.out.println("Insira a data para visulizar as compras (padrão YYYY-MM-DD)");
                    sc.nextLine();
                    String dataCompraStr = sc.nextLine();
                    try {
                        LocalDate dataCompra = LocalDate.parse(dataCompraStr);
                        List<Compra> comprasFiltradas = compras.stream().filter(compra -> (compra.getDataCompra().compareTo(dataCompra))==0?true:false).collect(Collectors.toList());
                        System.out.println("Ver compras no dia: " + dataCompra);
                        comprasFiltradas.forEach(System.out::println);
                    } catch (DateTimeParseException e) {
                        System.out.println("Entrada invalida. Use o formato YYYY-MM-DD e uma data existente.");
                    }                    
                    break;
                case 3:
                    //  sair do sistema e finalizar
                    System.out.println("Encerrando o sistema...");
                    break;            
                default:
                    // print invalid value and ask again
                    System.out.println("Entrada inválida, digite um núemro de 1 a 3");
                    break;
            }
        } while (opcao !=3);
        
        sc.close();
    }
}
