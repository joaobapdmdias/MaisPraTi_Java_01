package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Venda;
import model.Vendedor;

public class VendedorRepository {

    Map<Integer, Vendedor> repository;
    private Connection connection;

    public VendedorRepository() {
        this.repository = new HashMap<>();
    }


    public void salvar(Vendedor vendedor) {
        Vendedor vendedorBD = buscarPorId(vendedor.getId(), true);
        connection = BancoDeDados.obterConexao();
        String query;
        PreparedStatement ps;
        if (vendedorBD == null) {
            query = "INSERT INTO vendedor (nome, endereco, cpf, senha, salario, comissao, vendas)"
                  + " values (?,?,?,?,?,?,?)"; 
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, vendedor.getNome());
                ps.setString(2, vendedor.getEndereco());
                ps.setString(3, vendedor.getCpf());
                ps.setString(4, vendedor.getSenha());
                ps.setDouble(5, vendedor.getSalario());
                ps.setDouble(6, vendedor.getComissao());
                ps.setInt(7, vendedor.getVendas());

                if (ps.executeUpdate() == 1) {
                    System.out.println("Vendedor salvo com sucesso");
                } else {
                    System.out.println("Erro ao salvar o vendedor");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BancoDeDados.fecharConexao();
            }
        } else {
            query = "UPDATE vendedor SET comissao = ?, vendas = ? WHERE id = " + vendedor.getId();
            try {
                ps = connection.prepareStatement(query);
                ps.setDouble(1, vendedor.getComissao());
                ps.setInt(2, vendedor.getVendas());
  
                if (ps.executeUpdate() == 1) {
                    System.out.println("Vendedor atualizado com sucesso");
                } else {
                    System.out.println("Erro ao atualizar o vendedor");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BancoDeDados.fecharConexao();
            }
        }
    }

    public List<Vendedor> buscarTodos() {
        connection = BancoDeDados.obterConexao();
        String query = "SELECT * FROM vendedor";
        List<Vendedor> listaDeVendedores = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String endereco = rs.getString("endereco");
                String cpf = rs.getString("cpf");
                double salario = rs.getDouble("salario");
                double comissao = rs.getDouble("comissao");
                int vendas = rs.getInt("vendas");

                listaDeVendedores.add(new Vendedor(id, nome, endereco, cpf, null, salario, comissao, vendas));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }
        return listaDeVendedores;
    }
    public Vendedor buscarPorId (Integer id, boolean fecharConexao) {
        connection = BancoDeDados.obterConexao();
        String query = "SELECT * FROM vendedor WHERE id = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String endereco = rs.getString("endereco");
                String cpf = rs.getString("cpf");
                double salario = rs.getDouble("salario");
                double comissao = rs.getDouble("comissao");
                int vendas = rs.getInt("vendas");

                 return new Vendedor(id, nome, endereco, cpf, null, salario, comissao, vendas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (fecharConexao) {
                BancoDeDados.fecharConexao();
            }
        }
        return null;
    }

    public Vendedor buscarPorCpf (String cpf) {
        connection = BancoDeDados.obterConexao();
        String query = "SELECT * FROM vendedor WHERE cpf = " + cpf;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String endereco = rs.getString("endereco");
                Double salario = rs.getDouble("salario");
                Double comissao = rs.getDouble("comissao");
                Integer vendas = rs.getInt("vendas");

                return new Vendedor(id, nome, endereco, cpf, senha, salario, comissao, vendas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        }

        return null;
    }

    public void remover(int id) {
        connection = BancoDeDados.obterConexao();
        String query = "DELETE FROM `vendedor` WHERE id = " + id;

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            if (ps.executeUpdate() == 1) {
                System.out.println("Vendedor excluido com sucesso!");
            } else {
                System.out.println("Erro ao excluir vendedor!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.fecharConexao();
        } 
    }
}
