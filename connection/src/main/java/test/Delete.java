package test;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;

public class Delete {
    private static final String URL = "jdbc:postgresql://localhost:5432/validusers";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    public static void main(String[] args) {

        // Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection to PostgreSQL established successfully!");

            // Executar consulta
            String sql = "DELETE from users WHERE ID = 3 ";

            try (Statement stmt = conexao.createStatement()) {
                int rowsAffected = stmt.executeUpdate(sql);
                if(rowsAffected == 0) {
                    System.out.println("No user found with this ID");
                }else{
                    System.out.println("Number of rows deleted: " + rowsAffected);
                }

            } catch (SQLException e) {
                System.err.println("Error executing the query: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }
}
