package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Cliente;

public class ClienteRepository {
    private Map<Integer, Cliente> repository;
    private Connection connection;

    public ClienteRepository() {
        repository = new HashMap<>();
        Cliente cliente = new Cliente("João", "Rua 4", "12345", "12345");
        repository.put(cliente.getId(), cliente);
    }

    public void salvar(Cliente cliente) {
        connection = BancoDeDados.obterConexao();
        String query = "INSERT INTO cliente (nome, enderenco, cpf, senha) values (?, ?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getSenha());

            int sucesso = ps.executeUpdate();
            if (sucesso == 1) {
                System.out.println("Salvo com sucesso");
            } else {
                System.out.println("Falha ao salvar os dados");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }

    }
    public void remove(Integer id) {
        repository.remove(id);
    }
    public List<Cliente> buscarTodos() {
        return repository.values().stream().collect(Collectors.toList());
    }
    public Cliente buscarPorId (Integer id) {
        return repository.get(id);
    }
    public Cliente buscarPorCpf (String cpf) {
        connection = BancoDeDados.obterConexao();
        String query = "SELECT * FROM cliente WHERE cpf = " + cpf;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String endereco = rs.getString("enderenco");

                return new Cliente(id, nome, endereco, cpf, senha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }

        return null;
    }
}
