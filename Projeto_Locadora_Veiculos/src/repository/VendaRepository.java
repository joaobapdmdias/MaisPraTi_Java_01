package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Venda;

public class VendaRepository {
    Map<Integer, Venda> repository;
    private Connection connection;

    public VendaRepository() {
        this.repository = new HashMap<>();
    }

    public void salvar(Venda venda) {
        connection = BancoDeDados.obterConexao();

        if (venda.getId() != null) {
            String query = "UPDATE venda SET entrege = " 
                         + venda.getEntregue() + " WHERE id = " + venda.getId();

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                if (ps.executeUpdate() == 1) {
                    System.out.println("Veículo devolvido com sucesso");
                }
                else {
                    System.out.println("Erro ao devolver o veículo");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } 
        else {
            
            String query = "INSERT INTO venda (id_cliente, id_vendedor, id_veiculo, data, entrege) values (?,?,?,?,?)";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, venda.getCliente().getId());
                ps.setInt(2, venda.getVendedor().getId());
                ps.setInt(3, venda.getVeiculo().getId());
                ps.setDate(4, Date.valueOf(venda.getData()));
                ps.setBoolean(5, false);
                if (ps.executeUpdate() == 1) {
                    System.out.println("Venda salva com sucesso!");
                } else {
                    System.out.println("Erro ao salvar venda!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BancoDeDados.fecharConexao();
            }
        }
        
    }
    public void remove(Integer id) {
        repository.remove(id);
    }
    public List<Venda> buscarTodos() {
        return repository.values().stream().collect(Collectors.toList());
    }
    public Venda buscarPorId (Integer id) {
        return repository.get(id);
    }

    public Venda buscarPeloClienteEVeiculo(int clienteId, int veiculoId) {
        String query = "SELECT * FROM venda WHERE id_cliente = ? AND id_veiculo = ? AND entrege = false";
        connection = BancoDeDados.obterConexao();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, clienteId);
            ps.setInt(2, veiculoId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                boolean entregue = rs.getBoolean("entrege");
                return new Venda(id, entregue);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }

        return null;
    }
}
