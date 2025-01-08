package test;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.Scanner;
@Getter
@Setter


public class Signin {
    private static final String URL = "jdbc:postgresql://localhost:5432/validusers";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    private static String username = null;
    private static String password = null;
    private static int id;
    public static void main(String[] args) {
        String validUsername= "bt";
        String validPassword = "123";

        // Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection to PostgreSQL established successfully!");

            // Executar consulta
            String sql = "SELECT * from users order by id asc ";

            try (Statement stmt = conexao.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                // Processar os resultados
                while (rs.next()) {
                    id = rs.getInt("id");
                    username = rs.getString("username");
                    password = rs.getString("password");

                }
                if(username.equals(validUsername) && password.equals(validPassword)){
                    System.out.println("sign-in sucess!");
                    System.out.println("ID: " + id + " | Username: " + username + " | Password: " + password);
                }else{
                    System.out.println("user not found!");
                }

            } catch (SQLException e) {
                System.err.println("Error executing the query: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }
}
