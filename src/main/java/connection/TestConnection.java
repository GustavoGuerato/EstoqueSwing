package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = SingleConnection.conectar()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer a conexão: " + e.getMessage());
        }
    }
}
