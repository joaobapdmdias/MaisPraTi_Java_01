package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Cliente;
import model.Veiculo;
import model.Venda;
import repository.ClienteRepository;
import repository.VeiculoRepository;
import repository.VendaRepository;

public class ClienteService {

    ClienteRepository repository;
    VeiculoRepository veiculoRepository;
    VendaRepository vendaRepository;
    Scanner sc;

    public ClienteService(Scanner sc) {
        this.sc = sc;
        this.repository = new ClienteRepository();
        this.veiculoRepository = new VeiculoRepository();
        this.vendaRepository = new VendaRepository();
    }

    public Cliente procurarCliente(String cpf) {
        Cliente cliente = repository.buscarPorCpf(cpf);

        if (cliente == null) {
            return this.criarCliente(cpf);
        }
        else {
            return cliente;
        }
    }

    public boolean confereSenha(Cliente cliente, String senha) {
        return cliente.getSenha().equals(senha);
    }

    public Cliente criarCliente(String cpf) {
        System.out.println("Digite seu nome");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Digite seu endereco");
        String endereco = sc.nextLine();
        System.out.println("Digite sua senha");
        String senha = sc.next();

        Cliente cliente = new Cliente(nome, endereco, cpf, senha);

        repository.salvar(cliente);
        
        return cliente;
    }

    public void alugarVeiculo(Cliente cliente, Veiculo veiculo, int diasAlugado) {
        cliente.getVeiculosAlugados().add(veiculo);
        cliente.setValorDebito(cliente.getValorDebito() + veiculo.getValorDiario() * diasAlugado);
        repository.salvar(cliente);

        System.out.println("Veículo alugado com sucesso. Dia da entrega: " 
                            + LocalDate.now().plusDays(diasAlugado).
                            format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

        public void devolverVeiculo(Cliente cliente, Veiculo veiculo) {
            Venda venda = vendaRepository.buscarPeloClienteEVeiculo(cliente.getId(), veiculo.getId());
            venda.setEntregue(true);
            vendaRepository.salvar(venda);
        }

    public void mostrarVeiculosEDebitos(Cliente cliente) {
        mostrarVeiculosAlugados(cliente);
        System.out.println("Seu total de débito: R$" + cliente.getValorDebito());
    }

    public void mostrarVeiculosAlugados(Cliente cliente) {
        // cliente = repository.buscarPorId(cliente.getId());
        // cliente.getVeiculosAlugados().forEach(System.out::println);
        veiculoRepository.buscarVeiculosPeloClienteId(cliente.getId()).forEach(System.out::println);
        veiculoRepository.buscarVeiculosPeloClienteId(cliente.getId());
    }
    
}
