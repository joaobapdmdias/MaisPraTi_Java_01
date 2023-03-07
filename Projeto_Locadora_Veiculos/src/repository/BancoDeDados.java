package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BancoDeDados {

    private static File file = new File("DB.credentials");
    private static Scanner sc;
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/alguel_veiculos_jan23";
    private static String usuario;
    private static String senha;

    public static void obterCredenciais() {
        try {
            sc = new Scanner(file);
            usuario = sc.nextLine();
            senha = sc.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection obterConexao() {
        obterCredenciais();
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, usuario, senha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void fecharConexao() {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String statusConexao() {
        try {
            return connection != null && !connection.isClosed() ? "Está aberta" : "Está fechada";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Erro ao verificar";
    }
}
