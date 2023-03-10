package model;

import java.time.LocalDate;

import utils.Contador;
import utils.UtilsService;

public class Venda {

    private Integer id;    
    private Vendedor vendedor;
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDate data;
    private Boolean entregue;
    
    public Venda(Integer id, boolean entregue) {
        this.id = id;
        this.entregue = entregue;
    }
    public Venda(Vendedor vendedor, Veiculo veiculo, Cliente cliente) {
        this.vendedor = vendedor;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.data = LocalDate.now();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Boolean getEntregue() {
        return entregue;
    }
    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }
    public String toString() {
        return "Vendedor: " + vendedor.getNome() + "-" + "-Cliente" + cliente.getNome() 
            + "-Veiculo " + veiculo.getModelo() + ", " + veiculo.getMarca() + veiculo.getPlaca()
            + "-Data " + UtilsService.normalizaData(data);
    }
}
