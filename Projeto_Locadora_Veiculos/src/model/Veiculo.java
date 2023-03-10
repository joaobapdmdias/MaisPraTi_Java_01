package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import utils.Contador;

public class Veiculo {
    public enum Status {LIVRE, ALUGADO}
    public enum Segmento {CARRO, MOTO, CAMINHAO}
    public enum Combustivel {GASOLINA, ALCOOL, HIBRIDO, ELETRICO}
    private int id, ano;
    private String placa, cor, marca, modelo;
    private Status status;
    private LocalDate dataEntrega;

    private Segmento segmento;
    private Combustivel combustivel;
    private double valorDiario;
 
    public Veiculo(String placa, String cor, String marca, String modelo, int ano, Segmento segmento, Combustivel combustivel, double valorDiario) {
        this.status = Status.LIVRE;
        this.placa = placa;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.segmento = segmento;
        this.combustivel = combustivel;
        this.valorDiario = valorDiario;
    }
    public Veiculo(int id, String placa, String cor, String marca, String modelo, int ano, Segmento segmento,
            Combustivel combustivel, double valorDiario, Status status) {
        this(placa, cor, marca, modelo, ano, segmento, combustivel, valorDiario);
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getValorDiario() {
        return valorDiario;
    }
    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    public Segmento getSegmento() {
        return segmento;
    }
    public Combustivel getCombustivel() {
        return combustivel;
    }
    
    @Override
    public String toString() {
        return id + "-" + marca + "-" + modelo + "-" + placa + "-" + cor
                  + "- " + combustivel + "- diária R$" 
                  + valorDiario 
                  + (dataEntrega != null ? ( " Data Entrega: " + dataEntrega.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))) : ""); 
    }
}
