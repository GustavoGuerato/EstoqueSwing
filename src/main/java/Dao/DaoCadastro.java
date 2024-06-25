package Dao;

import connection.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoCadastro {

    public void cadastrarCliente(String usuario, String senha) {
        String sql = "INSERT INTO cliente (usuario, senha) VALUES (?, ?)";

        try (Connection connection = SingleConnection.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar cliente no banco de dados", e);
        }
    }
}
