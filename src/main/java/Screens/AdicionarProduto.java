package Screens;

import Dao.DaoEstoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarProduto extends JFrame {
    private JTextField nome;
    private JTextField codigo;
    private JTextField validade;
    private JTextField quantidade;
    private JTextField preco;
    private JButton addProduto;
    private JButton voltarHome;

    public AdicionarProduto() {
        setTitle("Adicionar Produto");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Initialize components
        nome = new JTextField(20);
        codigo = new JTextField(20);
        validade = new JTextField(20);
        quantidade = new JTextField(20);
        preco = new JTextField(20);
        addProduto = new JButton("Adicionar Produto");
        voltarHome = new JButton("Voltar");

        // Add components to the layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        add(nome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Código:"), gbc);
        gbc.gridx = 1;
        add(codigo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Validade:"), gbc);
        gbc.gridx = 1;
        add(validade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Quantidade:"), gbc);
        gbc.gridx = 1;
        add(quantidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Preço:"), gbc);
        gbc.gridx = 1;
        add(preco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(addProduto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(voltarHome, gbc);

        // Add action listeners
        addProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DaoEstoque daoEstoque = new DaoEstoque();
                String nomeProduto = nome.getText();
                String codigoProduto = codigo.getText();
                String validadeProduto = validade.getText();
                String quantidadeProduto = quantidade.getText();
                String precoProduto = preco.getText();

                if (!nomeProduto.isEmpty() && !codigoProduto.isEmpty() && !validadeProduto.isEmpty()
                        && !quantidadeProduto.isEmpty() && !precoProduto.isEmpty()) {

                    boolean produtoExiste = daoEstoque.BuscarProdutoBool(codigoProduto);

                    if (!produtoExiste) {
                        daoEstoque.AdicionarProduto(nomeProduto, codigoProduto, validadeProduto, quantidadeProduto, precoProduto);
                        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto com código " + codigoProduto + " já existe no estoque.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos antes de adicionar o produto.");
                }
            }
        });

        voltarHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcoes = {"Sim", "Não"};
                if (nome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Voltando para o menu principal");
                    AdicionarProduto.this.dispose();
                    new HomeScreen().setVisible(true);
                } else {
                    int escolha = JOptionPane.showOptionDialog(null,
                            "Você quer apagar todos os dados e voltar para o menu principal?",
                            "Apagar?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            opcoes,
                            opcoes[1]);

                    if (escolha == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Apagando tudo e voltando para o menu inicial");
                        AdicionarProduto.this.dispose();
                        new HomeScreen().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ação cancelada");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdicionarProduto().setVisible(true);
            }
        });
    }
}
