package Screens;

import Dao.DaoEstoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverProduto extends JFrame{
    private JTextField codigo;
    private JButton verificarButton;
    private JButton confirmarButton;
    private JButton voltarHome;

    public RemoverProduto(){

        setTitle("Remover Produto");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaçamento entre os componentes

        // Initialize components
        codigo = new JTextField(20);
        verificarButton = new JButton("Verificar");
        confirmarButton = new JButton("Confirmar");
        voltarHome = new JButton("Voltar");

        // Add components to the layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Código do Produto:"), gbc);
        gbc.gridx = 1;
        add(codigo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(verificarButton, gbc);

        gbc.gridy = 2;
        add(confirmarButton, gbc);

        gbc.gridy = 3;
        add(voltarHome, gbc);

        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DaoEstoque daoEstoque = new DaoEstoque();
                String codigoProduto = codigo.getText();
                if (!codigoProduto.isEmpty()) {
                    boolean produtoExiste = daoEstoque.BuscarProdutoBool(codigoProduto);

                    if (produtoExiste) {
                        JOptionPane.showMessageDialog(null, "O produto com codigo " + codigoProduto +
                                "existe");
                    } else {
                        JOptionPane.showMessageDialog(null, "o Produto não foi localizado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "por favor preencha o campo Codigo para procurarmos");
                }
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcoes ={"sim","não"};
                DaoEstoque daoEstoque = new DaoEstoque();
                String codigoProduto = codigo.getText();

                if (!codigoProduto.isEmpty()) {
                    boolean produtoExiste = daoEstoque.BuscarProdutoBool(codigoProduto);

                    if (produtoExiste) {
                        int escolha = JOptionPane.showOptionDialog(null,
                                "Você quer apagar todos os dados do codigo" + codigo,
                                "Apagar?",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                null,
                                opcoes,
                                opcoes[1]);
                        if (escolha == JOptionPane.YES_OPTION){
                            JOptionPane.showMessageDialog(null,"excluindo todos os dados do codigo" +codigo);
                            daoEstoque.RemoverProduto(String.valueOf(codigo));
                        }else{
                            JOptionPane.showMessageDialog(null, "acao cancelada");
                        }
                    }
                }
            }
        });


        voltarHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object opcoes[] = {"sim","não"};
                if (codigo.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fechando o programa");
                    RemoverProduto.this.dispose();
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
                        JOptionPane.showMessageDialog(null, "Apagando o dados e fechando");
                        RemoverProduto.this.dispose();
                        new HomeScreen().setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null, "Ação Cancelada");
                    }
                }
            }
        });
    }
}
