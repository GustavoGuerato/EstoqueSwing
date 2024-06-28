package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarProduto extends JFrame {
    private JTextField codigo;
    private JTextField novoNome;
    private JTextField novaValidade;
    private JTextField novaQuantidade;
    private JTextField novoPreco;
    private JButton voltarHome;
    private JButton mudarProduto;

    public AtualizarProduto() {
        setTitle("Atualizar Produto");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Adicionando os componentes à interface
        JLabel labelCodigo = new JLabel("Código do Produto:");
        codigo = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelCodigo, gbc);
        gbc.gridx = 1;
        add(codigo, gbc);

        JLabel labelNovoNome = new JLabel("Novo Nome:");
        novoNome = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelNovoNome, gbc);
        gbc.gridx = 1;
        add(novoNome, gbc);

        JLabel labelNovaValidade = new JLabel("Nova Validade:");
        novaValidade = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelNovaValidade, gbc);
        gbc.gridx = 1;
        add(novaValidade, gbc);

        JLabel labelNovaQuantidade = new JLabel("Nova Quantidade:");
        novaQuantidade = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(labelNovaQuantidade, gbc);
        gbc.gridx = 1;
        add(novaQuantidade, gbc);

        JLabel labelNovoPreco = new JLabel("Novo Preço:");
        novoPreco = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(labelNovoPreco, gbc);
        gbc.gridx = 1;
        add(novoPreco, gbc);

        mudarProduto = new JButton("Atualizar Produto");
        voltarHome = new JButton("Voltar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(mudarProduto, gbc);
        gbc.gridx = 1;
        add(voltarHome, gbc);

        voltarHome.addActionListener(new ActionListener() {
            Object opcoes[] = {"sim","não"};
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!codigo.getText().isEmpty()) {
                   JOptionPane.showMessageDialog(null ,"fechando o programa");
                   AtualizarProduto.this.dispose();
                   new HomeScreen().setVisible(true);
                }else {
                    int escolha = JOptionPane.showOptionDialog(null,
                            "Você quer apagar todos os dados e voltar para o menu principal?",
                            "Apagar?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            opcoes,
                            opcoes[1]);
                    if (escolha == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "apagando todos os dados e fechando o programa");
                        AtualizarProduto.this.dispose();
                        new HomeScreen().setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null,"acao cancelada");
                    }
                }
            }
        });

    }

}
