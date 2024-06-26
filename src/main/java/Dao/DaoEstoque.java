package Dao;

import connection.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoEstoque {

    public void AdicionarProduto(String nome, String codigo, String validade, String quantidade,String preco) {
        String sql = "INSERT INTO produtos (nome,codigo,validade,quantidade, preco) VALUES (?,?,?,?,?)";


        try (Connection connection = SingleConnection.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,nome);
            preparedStatement.setString(2,codigo);
            preparedStatement.setString(3,validade);
            preparedStatement.setString(4,quantidade);
            preparedStatement.setString(5,preco);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
