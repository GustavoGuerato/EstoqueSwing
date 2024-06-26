package Dao;

import connection.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void RemoverProduto(String codigo){
        String sql = "DELETE FROM produtos WHERE codigo = ?";

        try (Connection connection = SingleConnection.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, codigo); // Utiliza o código como critério para exclusão

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Registro excluído com sucesso!");
            } else {
                System.out.println("Nenhum registro foi excluído.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void VisualizarEstoque(){
        String sql = "SELECT * FROM produtos";
        try(Connection connection = SingleConnection.conectar();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
