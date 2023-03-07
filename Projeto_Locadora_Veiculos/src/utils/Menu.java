package utils;

public class Menu {

    public static void bemVindo() {
        System.out.println("Bem vindo ao sistema de aluguel de veículos");
        System.out.println("1 - cliente");
        System.out.println("2 - vendedor");
        System.out.println("3 - administrador");
        System.out.println("0 - para sair e encerrar");
    }

    public static void menuCliente() {
    System.out.println("1 - Alugar um veículo");
    System.out.println("2 - Devolver um veículo");
    System.out.println("3 - Ver veículos alugados");
    }

    public static void menuVendedor() {
        System.out.println("1 - ver total de vendas e seu salário com comissao");
        System.out.println("2 - ver veículos que você alugou e para qual cliente");       
    }

    public static void menuAdmin() {
        System.out.println("1 - Criar um novo veículo");
        System.out.println("2 - Remover um veículo");
        System.out.println("3 - Criar um novo vendedor");
        System.out.println("4 - Remover um vendedor");
    }
}
