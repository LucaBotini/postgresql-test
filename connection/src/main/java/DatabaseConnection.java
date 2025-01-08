import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    // estabelecendo conexão
    private static final String URL = "jdbc:postgresql://localhost:5432/validusers";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        // Conectar ao banco de dados
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão com PostgreSQL estabelecida com sucesso!");

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
                    if(id == 3){
                        System.out.println("encontrei id 3");
                    }if(id == 7){
                        System.out.println("encontrei id 7");
                    }

                }


            } catch (SQLException e) {
                System.err.println("Erro ao executar a consulta: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
