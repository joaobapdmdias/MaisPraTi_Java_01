package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import model.Veiculo;
import model.Veiculo.Combustivel;
import model.Veiculo.Segmento;
import model.Veiculo.Status;

public class VeiculoRepository {

    private Connection connection;
    private Map<Integer, Veiculo> repository;
    
    public VeiculoRepository() {
        repository = new HashMap<>();
        this.salvar(new Veiculo("IVX1234", "Preto", "Honda", "Civic", 2018, Segmento.CARRO, Combustivel.GASOLINA, 100));
        this.salvar(new Veiculo("YIX4535", "Branco", "Chevrolet", "Onix", 2017, Segmento.CARRO, Combustivel.GASOLINA, 200));
        this.salvar(new Veiculo("PYS3449", "Vermelho", "Audi", "A3", 2021, Segmento.CARRO, Combustivel.HIBRIDO, 175));
        this.salvar(new Veiculo("IVX1234", "Azul", "Honda", "CG", 2018, Segmento.MOTO, Combustivel.ALCOOL, 120));
    }

    public void salvar(Veiculo veiculo) {
        repository.put(veiculo.getId(), veiculo);
    }

    public void deletar(int id) {
        repository.remove(id);
    }

    public List<Veiculo> buscarTodos(String condicao) {
        connection = BancoDeDados.obterConexao();
        List<Veiculo> listaDeVeiculos = new ArrayList<>();
        String query = "SELECT * FROM `veiculo` ".concat(condicao == null ? "" : condicao);

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");
                String cor = rs.getString("cor");
                Double valorDiario = rs.getDouble("valor_diario");
                int ano = rs.getInt("ano");
                Status status = Status.valueOf(rs.getString("status").toUpperCase());
                Segmento segmento = Segmento.valueOf(rs.getString("segmenteo"));
                Combustivel combustivel = Combustivel.valueOf(rs.getString("combustivel"));

                listaDeVeiculos.add(new Veiculo(id, placa, cor, marca, modelo,
                        ano, segmento, combustivel, valorDiario, status));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }

        return listaDeVeiculos;
        
    }

    public Veiculo buscarPorId(int id) {
        // return repository.get(id);   
        connection = BancoDeDados.obterConexao();
        // List<Veiculo> listaDeVeiculos = new ArrayList<>();
        String query = "SELECT * FROM `veiculo` WHERE id = " +id;

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");
                String cor = rs.getString("cor");
                Double valorDiario = rs.getDouble("valor_diario");
                int ano = rs.getInt("ano");
                Status status = Status.valueOf(rs.getString("status").toUpperCase());
                Segmento segmento = Segmento.valueOf(rs.getString("segmenteo"));
                Combustivel combustivel = Combustivel.valueOf(rs.getString("combustivel"));

                return new Veiculo(id, placa, cor, marca, modelo,
                        ano, segmento, combustivel, valorDiario, status);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }

        return null;     
    }
}
