package Screens;

import Dao.DaoCadastro;
import connection.SingleConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroScreen extends JFrame {
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private JButton cadastroButton;

    public CadastroScreen() {
        setTitle("Tela de Cadastro");
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
        loginButton = new JButton("Cadastrar");
        loginButton.setPreferredSize(new Dimension(200, 30));  // Definindo tamanho preferido
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);

        // Botão de cadastro
        cadastroButton = new JButton("Voltar");
        cadastroButton.setPreferredSize(new Dimension(200, 30));  // Definindo tamanho preferido
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(cadastroButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());
                if (!usuario.isEmpty() && !senha.isEmpty()) {

                    if (verificarCliente(usuario)) {
                        JOptionPane.showMessageDialog(CadastroScreen.this, "Já existe um usuário com esse nome");
                    } else {
                        DaoCadastro daoCadastro = new DaoCadastro();
                        daoCadastro.cadastrarCliente(usuario, senha);
                        JOptionPane.showMessageDialog(CadastroScreen.this, "Usuário cadastrado com sucesso");


                    }
                } else {
                    JOptionPane.showMessageDialog(CadastroScreen.this, "Preencha todos os campos corretamente");
                }
            }
        });

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroScreen.this.dispose(); // Fechar a tela atual
                new LoginScreen().setVisible(true); // Abrir a nova tela
            }
        });
    }

    private boolean verificarCliente(String usuario) {
        String sql = "SELECT 1 FROM cliente WHERE usuario = ?";
        try (Connection connection = SingleConnection.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao verificar usuário: " + e.getMessage());
            return false; // Retornar false em caso de erro para não bloquear a criação de usuário
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroScreen().setVisible(true);
            }
        });
    }
}
