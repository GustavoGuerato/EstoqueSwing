package Screens;

import Dao.DaoCadastro;

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
                DaoCadastro daoCadastro = new DaoCadastro();
                
            }
        });


    }

}
