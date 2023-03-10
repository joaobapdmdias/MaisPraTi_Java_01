package repository;

import java.sql.Connection;
import java.sql.Date;
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
    }

    public void salvar(Veiculo veiculo) {
        Veiculo veiculoBD = buscarPorId(veiculo.getId());
        connection = BancoDeDados.obterConexao();
        String query;
        if (veiculoBD == null) {
            //
            query = "INSERT INTO veiculo (placa, cor, marca, modelo, ano, segmenteo, combustivel, status, data_entrega,"
                  + " valor_diario) values (?,?,?,?,?,?,?,?,?,?)";
        } else {
            //
            query = "UPDATE veiculo SET placa = ?, cor = ?, marca = ?, modelo = ?, ano = ?, segmenteo = ?, "
                  + "combustivel = ?, status = ?, data_entrega = ?, valor_diario = ? WHERE id = " + veiculoBD.getId();
        }

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getCor());
            ps.setString(3, veiculo.getMarca());
            ps.setString(4, veiculo.getModelo());
            ps.setInt(5, veiculo.getAno());
            ps.setString(6, veiculo.getSegmento().toString());
            ps.setString(7, veiculo.getCombustivel().toString());
            ps.setString(8, veiculo.getStatus().toString());
            ps.setDate(9, veiculo.getDataEntrega() == null ? null : Date.valueOf(veiculo.getDataEntrega()));
            ps.setDouble(10, veiculo.getValorDiario());

            if (ps.executeUpdate() == 1) {
                System.out.println("Veículo salvo com sucesso!");
            } else {
                System.out.println("Erro ao salvar o sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }





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
        connection = BancoDeDados.obterConexao();
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

    public List<Veiculo> buscarVeiculosPeloClienteId(int idCliente) {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        String query = "SELECT veiculo.* FROM `veiculo` " +
                       "INNER JOIN venda ON venda.id_veiculo = veiculo.id " +
                       "WHERE veiculo.status = 'ALUGADO' AND venda.entrege = false AND id_cliente = " + idCliente;
        connection = BancoDeDados.obterConexao();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
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

                listaVeiculos.add(new Veiculo(id, placa, cor, marca, modelo,
                                  ano, segmento, combustivel, valorDiario, status));

            }
            return listaVeiculos;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }
        
        return null;
    }
}
