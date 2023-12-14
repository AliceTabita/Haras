/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.haras.view.equino;

import br.com.haras.controller.ClienteController;
import br.com.haras.controller.EquinoController;
import br.com.haras.model.Cliente;
import br.com.haras.view.component.Message;
import br.com.haras.view.component.swing.ButtonOutLine;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import br.com.haras.model.Equino;
import br.com.haras.model.Raca;
import br.com.haras.model.valid.exceptions.InvalidCpfException;
import br.com.haras.model.valid.exceptions.ObjectNotFoundException;
import br.com.haras.view.FrMenu;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
/**
 *
 * @author alice
 */
public class FrEquino extends javax.swing.JFrame {
    private ButtonOutLine btnVoltar;
    /**
     * Creates new form FrEquino
     */
    public FrEquino(Equino equino) {
        //EDITAR
        initComponents();
        ActionListener eventSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        };
        ActionListener eventBuscarProprietario = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPesquisa();
            }
        };
        equinoPn = new EquinoPn(eventSave, equino.toHashmap(),equinoController.atualizaRacas(),equino.getProprietario(), eventBuscarProprietario);

        this.setSize(1080,720);
        init();
       
    }
    public FrEquino() {
        initComponents();
        ActionListener eventSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        };
        ActionListener eventBuscarProprietario = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPesquisa();
            }
        };
        equinoPn = new EquinoPn(eventSave,equinoController.atualizaRacas(), eventBuscarProprietario);
        this.setSize(1080,720);
        init();
       
    }
    private void init(){
        findProprietario = new PanelFindProprietario();
        layout = new MigLayout("fill");
        bg.setLayout(layout);
        equinoController.atualizaRacas();
        cover = new PanelCoverEquino();
        btnVoltar = new ButtonOutLine();
        btnVoltar.setBackground(new Color(255,255,255));
        btnVoltar.setForeground(new Color(255,255,255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev){
                new FrMenu();
                dispose();   
            }
        });
        cover.add(btnVoltar, "center,bottom, pad -20 0 -20 0, w 20%, h 5%");
        bg.add(cover,"width 20%, pos 1al 0 n 100%");
        bg.add(equinoPn,"width 80%, pos 0al 0 n 100%");
        bg.setLayer(findProprietario, JLayeredPane.POPUP_LAYER);
        bg.add(findProprietario,"pos 0 0 100% 100%");
        
        findProprietario.addEvtButtonOk(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    Cliente cli = clienteController.buscarClientePorCpf(findProprietario.getInputCpf());
             
                    equinoPn.setProprietario(cli);
                    showMessage(Message.MessageType.SUCCESS, "Cliente selecionado");
                    findProprietario.setVisible(false);
                    
                }catch(InvalidCpfException e){
                    e.printStackTrace();
                    findProprietario.setMsgWarning("Cpf inválido.");
                    showMessage(Message.MessageType.ERROR, "Erro");
                }catch(ObjectNotFoundException onf){
                    findProprietario.setMsgWarning("Não foi possível localizar um cliente com esse cpf.");
                    showMessage(Message.MessageType.ERROR, "Erro");
                }catch(Exception ex){
                    findProprietario.setVisible(false);
                    showMessage(Message.MessageType.ERROR, "Erro");
                }
                
                
            }
            
        });
        this.setVisible(true);
    }
    private void showPesquisa(){
        this.findProprietario.setVisible(true);
    }
    private void save(){
        try{
            equinoPn.getEquinoInfo();
            HashMap<String, String> eq = equinoPn.getEquinoInfo();
            Cliente cli = equinoPn.getProprietario();
            String retorno = equinoController.save(eq,cli);
         
            if(retorno!=null){
                showMessage(Message.MessageType.ERROR, retorno);
            }else{
                showMessage(Message.MessageType.SUCCESS,"Equino salvo com sucesso.");  
            }
            
        }catch(Exception e){
           e.printStackTrace();
           showMessage(Message.MessageType.ERROR,"Erro ao salvar equino, tente novamente.");
        }
    }
    
    
    private void showMessage(Message.MessageType  messageType, String message){
        Message ms = new Message();
        //ms.setOpaque(true);
        
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin() {
                if(!ms.isShow()){
                    bg.add(ms,"pos 0.5al -30",0);
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;   
                if (ms.isShow()){
                    f= 40 *(1f- fraction);
                }else{
                    f= 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al "+(int)(f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if(ms.isShow()){
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                }else{
                    ms.setShow(true);
                }
            }
            
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrEquino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrEquino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrEquino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrEquino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrEquino(null).setVisible(true);
            }
        });
    }
    private EquinoPn equinoPn;
    private MigLayout layout;
    private PanelCoverEquino cover;
    private EquinoController equinoController = new EquinoController();
    private PanelFindProprietario findProprietario;
    private ClienteController clienteController = new ClienteController();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
