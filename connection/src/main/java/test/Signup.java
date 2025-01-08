package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//Criar usuario.
public class Signup {
    // Definindo as credenciais de conexão com o banco
    private static final String URL = "jdbc:postgresql://localhost:5432/validusers";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        // Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection to PostgreSQL established successfully!");

            // Criando a query SQL com parâmetros
            String sql = "INSERT INTO users (username, password) VALUES ('criando', 'criei')";

            try (Statement stmt = conexao.createStatement()) {
                int rowsAffected = stmt.executeUpdate(sql);  // Executa a consulta
                System.out.println(rowsAffected + " row(s) inserted.");
            } catch (SQLException e) {
                System.out.println("Error executing SQL statement.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
