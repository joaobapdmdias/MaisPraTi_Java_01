package service;

import java.util.List;
import java.util.Scanner;

import exception.SistemaException;
import model.Cliente;
import model.Veiculo;
import model.Venda;
import model.Vendedor;
import repository.VendaRepository;
import repository.VendedorRepository;

public class VendedorService {
    private VendedorRepository repository;
    private VendaRepository vendaRepository;
    private Scanner sc;

    public VendedorService(Scanner sc) {
        this.sc = sc;
        this.repository = new VendedorRepository();
        this.vendaRepository = new VendaRepository();
    }

    public void criarVendedor() {
        System.out.println("Digite o nome");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Digite o endereco");
        String endereco = sc.nextLine();
        System.out.println("Digite o cpf");
        String cpf = sc.next();
        System.out.println("Digite a senha");
        String senha = sc.next();

        System.err.println("Digite o salário");
        double salario = sc.nextDouble();
        Vendedor vendedor = new Vendedor(nome, endereco, cpf, senha, salario);

        repository.salvar(vendedor);
    }

    public void mostrarTodosVendedores() {
        repository.buscarTodos().forEach(vendedor -> System.out.println(vendedor));
    }

    public void adicionarVenda(int idVendedor, Veiculo veiculo, int diasAlugado, Cliente cliente) {
        Vendedor vendedor = repository.buscarPorId(idVendedor, true);

        if (vendedor == null) {
            throw new SistemaException("Vendedor não localizado!");
         }
        double comissao = veiculo.getValorDiario() * diasAlugado * Vendedor.BONIFICACAO;

        vendedor.setComissao(vendedor.getComissao() + comissao);
        vendedor.addVendas();

        // VendaRepository.salvar(new Venda(vendedor, veiculo, cliente)));
        vendaRepository.salvar(new Venda(vendedor, veiculo, cliente));
        repository.salvar(vendedor);
        
    }

    public Vendedor procurarVendedor(String cpf) {
        Vendedor vendedor = repository.buscarPorCpf(cpf);

        if (vendedor == null) {
            throw new SistemaException("Vendedor não localizado");
        }

        return vendedor;
    }

    public void mostrarDetalhesVendedor(Vendedor vendedor) {
        System.out.println("Seu total de vendas é: " + vendedor.getVendas());
        System.out.println("Seu salário + comissão é: R$" + vendedor.getSalario() + vendedor.getComissao());
    }

    public void mostrarVendasVendedor(Vendedor vendedor) {
        List<Venda> todasVendas = vendaRepository.buscarVendasPorVendedor(vendedor.getId());

        // todasVendas.removeIf(venda -> venda.getVendedor().getId() != vendedor.getId());

        todasVendas.forEach(System.out::println);
    }

    public void removerUmVendedor(int opcaoVendedor) {
        repository.remover(opcaoVendedor);
    }
}
