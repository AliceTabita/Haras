/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.haras.view.component;


import br.com.haras.view.component.swing.MyTextField;
import com.raven.swing.MyButton;
import com.raven.swing.MyPasswordField;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author alice
 */
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    
    public PanelLoginAndRegister(ActionListener eventRegister) {
        initComponents();
        initRegister(eventRegister);
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
       
    }
    private void initRegister(ActionListener eventRegister){
        register.setLayout(new MigLayout("wrap","push[center]push","push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Cadastre-se");
        label.setFont(new Font("sansserif",1,30));
        label.setForeground(new Color(74,37,20));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/imgs/user.png")));
        txtUser.setHint("Nome");
        register.add(txtUser,"w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/imgs/email.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail,"w 60%");
        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/imgs/senha.png")));
        txtPassword.setHint("Senha");
        register.add(txtPassword,"w 60%");
        MyButton btn = new MyButton();
        btn.setBackground(new Color(74,37,20));
        btn.setForeground(new Color(250,250,250));
        btn.addActionListener(eventRegister);
        btn.setText("Sign up");
        register.add(btn, "w 40%, h 40");
    }
    private void initLogin(){
        login.setLayout(new MigLayout("wrap","push[center]push","push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Login");
        label.setFont(new Font("sansserif",1,30));
        label.setForeground(new Color(74,37,20));
        login.add(label);
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/imgs/email.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail,"w 60%");
        
        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/imgs/senha.png")));
        txtPassword.setHint("Senha");
        login.add(txtPassword,"w 60%");
        
        JButton btnForget = new JButton("Esqueceu sua senha?");
        btnForget.setForeground(new Color(100,100,100));
        btnForget.setFont(new Font("sanserif",1,12));
        btnForget.setContentAreaFilled(false);
        btnForget.setBorderPainted(false);
        btnForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(btnForget);
        
        MyButton btnEntrar = new MyButton();
        btnEntrar.setBackground(new Color(74,37,20));
        btnEntrar.setForeground(new Color(250,250,250));
        btnEntrar.setText("Entrar");
        login.add(btnEntrar, "w 40%, h 40");
    }
    public void showRegister(boolean show){
        if(show){
            register.setVisible(true);
            login.setVisible(false);
        }else{
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JPanel();
        login = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");
    }// </editor-fold>//GEN-END:initComponents


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
