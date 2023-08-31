package br.com.haras.view;

import javax.swing.*;

public class FrEquinos extends JFrame{
    private JPanel PnHeader;
    private JPanel PnBody;
    private JPanel PnFooter;
    private JPanel PnEquinos;

    public FrEquinos(){
        this.setSize(960,720);
        this.setLocationRelativeTo(this);
        this.setContentPane(PnEquinos);
        this.setVisible(true);
    }
}
