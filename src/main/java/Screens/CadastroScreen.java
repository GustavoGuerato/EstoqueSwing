package Screens;

import javax.swing.*;
import java.awt.*;

public class CadastroScreen extends JFrame {
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private JButton cadastroButton;

    public CadastroScreen() {
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
