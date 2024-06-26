package Screens;

import connection.SingleConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginScreen extends JFrame {
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private JButton cadastroButton;

    public LoginScreen() {
        setTitle("Tela de Login");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaçamento entre os componentes

        // Label e campo de usuário
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome"), gbc);

        usuarioField = new JTextField();
        usuarioField.setPreferredSize(new Dimension(200, 30));  // Definindo tamanho preferido
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(usuarioField, gbc);

        // Label e campo de senha
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Senha"), gbc);

        senhaField = new JPasswordField();
        senhaField.setPreferredSize(new Dimension(200, 30));  // Definindo tamanho preferido
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(senhaField, gbc);

        // Botão de login
        loginButton = new JButton("Logar");
        loginButton.setPreferredSize(new Dimension(200, 30));  // Definindo tamanho preferido
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);

        // Botão de cadastro
        cadastroButton = new JButton("Cadastrar");
        cadastroButton.setPreferredSize(new Dimension(200, 30));  // Definindo tamanho preferido
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(cadastroButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioField.getText().isEmpty() && senhaField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "preencha ambos os campos");
                }else if(usuarioField.getText().isEmpty() || senhaField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "falta preencher um dos 2 campos");
                }else{
                    JOptionPane.showMessageDialog(null, "login autorizado, seja bem vindo");
                    LoginScreen.this.dispose();
                    new HomeScreen().setVisible(true);
                }
                String usuario = usuarioField.getText();
                verificarCliente(usuario);
            }
        });

       cadastroButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                LoginScreen.this.dispose();
                new CadastroScreen().setVisible(true);
           }
       });
    }

    private void verificarCliente(String usuario) {
        String sql = "SELECT 1 FROM cliente WHERE usuario = ?";
        try (Connection connection = SingleConnection.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Usuário encontrado!");
                } else {
                    JOptionPane.showMessageDialog(this, "Usuário não encontrado!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao verificar usuário: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}
