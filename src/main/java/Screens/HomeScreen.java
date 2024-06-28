package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {
    private JMenuBar BarraDeMenu;
    private JMenu Estoque;
    private JMenuItem adicionarItem;
    private JMenuItem visualizarEstoque;
    private JMenuItem removerItem;
    private JMenu Logout;
    private JMenuItem logout;

    public HomeScreen() {
        setTitle("Tela de Cadastro");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());

        BarraDeMenu = new JMenuBar();

        Estoque = new JMenu("Estoque");

        adicionarItem = new JMenuItem("Adicionar Item");
        visualizarEstoque = new JMenuItem("Visualizar Estoque");
        removerItem = new JMenuItem("Remover Item");

        Estoque.add(adicionarItem);
        Estoque.add(visualizarEstoque);
        Estoque.add(removerItem);

        Logout = new JMenu("Logout");

        logout = new JMenuItem("Logout");

        Logout.add(logout);

        BarraDeMenu.add(Estoque);
        BarraDeMenu.add(Logout);

        setJMenuBar(BarraDeMenu);


        adicionarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreen.this.dispose();
                new AdicionarProduto().setVisible(true);
            }
        });

        visualizarEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreen.this.dispose();

            }
        });

        removerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreen.this.dispose();
                new RemoverProduto().setVisible(true);
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreen.this.dispose();
                new LoginScreen().setVisible(true);
            }
        });

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }
}
