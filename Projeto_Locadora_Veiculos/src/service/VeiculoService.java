package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import exception.SistemaException;
import model.Veiculo;
import model.Veiculo.Combustivel;
import model.Veiculo.Segmento;
import model.Veiculo.Status;
import repository.VeiculoRepository;

public class VeiculoService {

    VeiculoRepository repository;
    Scanner sc;

    public VeiculoService(Scanner sc) {
        this.sc = sc;
        repository = new VeiculoRepository();
    }

    public void criarVeiculo() {
        System.out.println("Digite a placa");
        String placa = sc.next();
        if (this.checarPlaca(placa)) {
            throw new SistemaException("Placa já cadastrada!");
        }
        System.out.println("Digite a cor");
        String cor = sc.next();
        System.out.println("Digite a marca");
        sc.nextLine();
        String marca = sc.nextLine();
        System.out.println("Digite o modelo");
        String modelo = sc.nextLine();
        System.out.println("Digite o ano");
        int ano = sc.nextInt();
        System.out.println("Digite o segmento");
        String segmentoString = sc.next();
        Segmento segmento = Segmento.valueOf(segmentoString.toUpperCase());
        System.out.println("Digite o tipo de combustível");
        String combustivelString = sc.next();
        Combustivel combustivel = Combustivel.valueOf(combustivelString.toUpperCase());
        System.out.println("Digite o valor da diária");
        double diaria = sc.nextDouble();

        this.repository.salvar(new Veiculo(placa, cor, marca, modelo, ano, segmento, combustivel, diaria));

        System.out.println("Veículo adicionado com sucesso!");
    }

    private boolean checarPlaca(String placa) {
        List<Veiculo> todosVeiculos = repository.buscarTodos("WHERE placa = " + placa);
        
        return todosVeiculos.stream().anyMatch(veiculo -> veiculo.getPlaca().equals(placa));
    }

    public void mostrarTodosVeiculosLivres() {
        this.repository.buscarTodos("WHERE status = 'livre' ").forEach(System.out::println);

    }

    public void mostrarTodosVeiculos() {
        repository.buscarTodos(null).forEach(System.out::println);
    }

    public Veiculo buscaVeiculoPorId(Integer id) {
        Veiculo veiculo = repository.buscarPorId(id);

        if (veiculo == null) {
            throw new SistemaException("Veículo não localizado!");
        }

        return veiculo;
    }
    
    public void statusAlugado(Veiculo veiculo, int diasAlugado) {
        veiculo.setStatus(Status.ALUGADO);
        veiculo.setDataEntrega(LocalDate.now().plusDays(diasAlugado));
        repository.salvar(veiculo);
    }

    public void statusLivre(Veiculo veiculo) {
        veiculo.setStatus(Status.LIVRE);
        veiculo.setDataEntrega(null);
        repository.salvar(veiculo);
    }

    public void removerUmVeiculo(int opcaoVeiculo) {
        this.repository.deletar(opcaoVeiculo);
    }
}