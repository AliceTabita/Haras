package br.com.haras.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrInicio extends JFrame {
    private JPanel PnInicio;
    private JPanel PnHeader;
    private JPanel PnBody;
    private JPanel PnButtonsContainer;
    private JButton BtnModuloProprietario;
    private JButton BtnModuloEquino;
    private JButton BtnModuloEventos;
    private JButton BtnModuloTratamentos;
    private JButton BtnModuloDoencas;
    private JButton BtnModuloAnuncio;


    public FrInicio(){
        this.setSize(960,720);
        this.setLocationRelativeTo(this);
        this.setContentPane(PnInicio);
        this.setVisible(true);
        BtnModuloProprietario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
