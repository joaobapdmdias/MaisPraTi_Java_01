import java.util.InputMismatchException;
import java.util.Scanner;

import exception.SistemaException;
import model.Admin;
import model.Cliente;
import model.Veiculo;
import model.Vendedor;
import repository.BancoDeDados;
import service.AdminService;
import service.ClienteService;
import service.VeiculoService;
import service.VendedorService;
import utils.Menu;
import utils.UtilsService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BancoDeDados.obterConexao();
        System.out.println(BancoDeDados.statusConexao());
        BancoDeDados.fecharConexao();
        System.out.println(BancoDeDados.statusConexao());

        Scanner sc = new Scanner(System.in);
        int opcao = 5;

        VeiculoService veiculoService = new VeiculoService(sc);
        ClienteService clienteService = new ClienteService(sc);
        VendedorService vendedorService = new VendedorService(sc);
        AdminService adminService = new AdminService(sc);
        boolean senhaCorreta;
        String cpf;
                 
            
        do {
            try {
            Menu.bemVindo();
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite seu cpf: ");
                    cpf = sc.next();
                    Cliente cliente = clienteService.procurarCliente(cpf);

                    System.out.println("Bem vindo Sr. " + cliente.getNome());
                    senhaCorreta = false;
                    do {
                        System.out.println("Digite sua senha:");
                        String senha = sc.next();
                        senhaCorreta = UtilsService.confereSenha(cliente, senha);
                    } while (!senhaCorreta);

                    Menu.menuCliente();

                    int opcaoCliente = sc.nextInt();
                    Veiculo veiculo;
                    switch (opcaoCliente) {
                        case 1:
                            System.out.println("Digite o numero referente a sua escolha");
                            veiculoService.mostrarTodosVeiculosLivres();
                            try {
                                veiculo = veiculoService.buscaVeiculoPorId(sc.nextInt());
                                System.out.println("Por quantos dias você ficará com o veículo?");
                                int diasAlugado = sc.nextInt();
                                clienteService.alugarVeiculo(cliente, veiculo, diasAlugado);
                                veiculoService.statusAlugado(veiculo, diasAlugado);
                                System.out.println("Escolha qual vendedor lhe atendeu: ");
                                vendedorService.mostrarTodosVendedores();
                                int opcaoVendedor = sc.nextInt();
                                vendedorService.adicionarVenda(opcaoVendedor, veiculo, diasAlugado, cliente);
                            } catch (ArithmeticException e) {
                            // } catch (NullPointerException e) {
                                System.out.println("Opção não definida: " + e.getMessage() + "\n");
                            }
                            break;
                        case 2:
                            System.out.println("Seus veiculos atuais: ");
                            clienteService.mostrarVeiculosAlugados(cliente);
                            veiculo = veiculoService.buscaVeiculoPorId(sc.nextInt());
                            clienteService.devolverVeiculo(cliente, veiculo);
                            veiculoService.statusLivre(veiculo);
                            break;
                        case 3:
                            clienteService.mostrarVeiculosEDebitos(cliente);
                            break;                    
                        default:
                            break;
                    }
                    break;
                case 2:
                int opcaoVendedor = sc.nextInt();
                System.out.println("Digite seu cpf: ");
                    cpf = sc.next();
                    Vendedor vendedor = vendedorService.procurarVendedor(cpf);
                    
                    System.out.println("Bem vindo Sr. " + vendedor.getNome());
                    senhaCorreta = false;
                    do {
                        System.out.println("Digite sua senha:");
                        String senha = sc.next();
                        senhaCorreta = UtilsService.confereSenha(vendedor, senha);
                    } while (!senhaCorreta);
                    Menu.menuVendedor();

                    switch (opcaoVendedor) {
                        case 1:
                            vendedorService.mostrarDetalhesVendedor(vendedor);
                            break;
                        case 2:
                            vendedorService.mostrarVendasVendedor(vendedor);
                            break;                    
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Digite seu cpf: ");
                    cpf = sc.next();
                    Admin admin = adminService.procurarAdmin(cpf);

                    System.out.println("Bem vindo Sr. " + admin.getNome());
                    senhaCorreta = false;
                    do {
                        System.out.println("Digite sua senha:");
                        String senha = sc.next();
                        senhaCorreta = UtilsService.confereSenha(admin, senha);
                    } while (!senhaCorreta);
                    
                    Menu.menuAdmin();
                    int opcaoAdmin = sc.nextInt();
                    switch (opcaoAdmin) {
                        case 1:
                            veiculoService.criarVeiculo();
                            break;
                        case 2:
                            veiculoService.mostrarTodosVeiculos();
                            int opcaoVeiculo = sc.nextInt();
                            veiculoService.removerUmVeiculo(opcaoVeiculo);               
                            break;  
                        case 3:
                            vendedorService.criarVendedor();
                            break;
                        case 4:
                            vendedorService.mostrarTodosVendedores();
                            opcaoVendedor = sc.nextInt();
                            vendedorService.removerUmVendedor(opcaoVendedor);
                            break;                  
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            } catch (SistemaException e) {
                System.out.println("Erro no sistema: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Operação não permitida. Tente novamente.");
            } finally {
                System.out.println("--------------------------------");
                System.out.println();
                Thread.sleep(3000);
            }

        } while (opcao != 0);
    }
}
