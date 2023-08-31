package br.com.haras.view.proprietarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrProprietarios extends JFrame {
    private JPanel PnProprietarios;
    private JPanel PnHeader;
    private JPanel PnBody;
    private JTextField TxPesquisa;
    private JPanel PnSearchContainer;
    private JScrollPane SpTableContainer;
    private JTable TbProprietarios;
    private JButton pesquisarButton;
    private JButton novoProrpietarioButton;
    private JButton Editar;
    private JButton deletarButton;
    private JPanel PnActionContainer;
    private JPanel PnTableContainer;

    public FrProprietarios(){
        this.setSize(960,720);
        this.setLocationRelativeTo(this);
        this.setContentPane(PnProprietarios);
        String[][] dados = {{"Nome","123","123","123","123","123","123","123123123123123123123123123123123123123123123123123123123"},
                {"Nome","123","123","123","123","123","123","123"}};
        String[] columns = {"Nome","dado","dado","dado","dado","dado","dado","dado"};
        this.preencheTabelaProprietarios(columns,dados);
        this.SpTableContainer.setViewportView(this.TbProprietarios);
        this.setVisible(true);

        novoProrpietarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DgProprietarios();

            }
        });
    }

        public void preencheTabelaProprietarios(Object[] columns, Object[][] rows){
            this.TbProprietarios.setModel(new DefaultTableModel(rows,columns));
        }
}
