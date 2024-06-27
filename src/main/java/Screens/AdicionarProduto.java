package Screens;

import Dao.DaoCadastro;
import Dao.DaoEstoque;

import javax.swing.*;
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

    public AdicionarProduto(){

        addProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DaoEstoque daoEstoque = new DaoEstoque();
                String nomeProduto = nome.getText();
                String codigoProduto = codigo.getText();
                String validadeProduto = validade.getText();
                
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

}
