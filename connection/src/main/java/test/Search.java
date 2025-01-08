package test;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;

public class Search {
    private static final String URL = "jdbc:postgresql://localhost:5432/validusers";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    public static void main(String[] args) {

        // Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection to PostgreSQL established successfully!");

            // Executar consulta
            String sql = "SELECT * from users order by id asc ";

            try (Statement stmt = conexao.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                // Processar os resultados
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");

                    System.out.printf("ID: %d, Username: %s, Password: %s", id, username, password);
                    System.out.println();

                }

            } catch (SQLException e) {
                System.err.println("Error executing the query: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }
}
