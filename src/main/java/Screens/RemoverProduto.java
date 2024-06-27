package Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverProduto extends JFrame{
    private JTextField codigo;
    private JButton verificarButton;
    private JButton confirmarButton;
    private JButton voltarHome;

    public RemoverProduto(){

    


        voltarHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object opcoes[] = {"sim","não"};
                if (codigo.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fechando o programa");
                    RemoverProduto.this.dispose();
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
