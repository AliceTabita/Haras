/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.haras.view.Raca;

import br.com.haras.controller.RacaController;
import br.com.haras.model.Cliente;
import br.com.haras.model.Evento;
import br.com.haras.model.Raca;
import br.com.haras.model.tables.TMCliente;
import br.com.haras.view.EditEventoDialog;
import br.com.haras.view.FrMenu;
import br.com.haras.view.component.Message;
import br.com.haras.view.component.swing.ButtonOutLine;
import br.com.haras.view.component.swing.MyFormattedTextField;
import br.com.haras.view.component.swing.MyTextField;
import br.com.haras.view.component.swing.TableDark;
import br.com.haras.view.equino.PanelCoverEquino;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author alice
 */
public class FrRaca extends javax.swing.JFrame {

    MigLayout layout;
    PanelCoverEquino cover;
    ButtonOutLine btnVoltar;
    RacaPn racaPn ;
    private RacaController racaController = new RacaController();
    /**
     * Creates new form FrRaca
     */
    public FrRaca() {
        initComponents();
        init();
    }
    private void init(){
        ActionListener eventSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        };
       
        layout = new MigLayout("fill");
        racaPn = new RacaPn(eventSave);
        bg.setLayout(layout);
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
        bg.add(racaPn,"width 80%, pos 0al 0 n 100%");
       

        this.setVisible(true);
    }
    private void save(){
         try{
            
            HashMap<String, String> raca = racaPn.getInfoRaca();
           
            String retorno = racaController.save(raca.get("idRaca"),raca.get("nome"),raca.get("descricao"),raca.get("vlBaseRaca"));
            
            if(retorno!=null){
                showMessage(Message.MessageType.ERROR, retorno);
            }else{
                showMessage(Message.MessageType.SUCCESS,"Raça salva com sucesso.");
                racaPn.atualizarTabelaRaca();
            }
            
        }catch(Exception e){
           e.printStackTrace();
           showMessage(Message.MessageType.ERROR,"Erro ao salvar raça, tente novamente.");
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
            .addGap(0, 846, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(FrRaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrRaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrRaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrRaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrRaca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
 class RacaPn extends javax.swing.JPanel {
     

    public RacaPn(ActionListener evtSave) {
        initComponents();
        init(evtSave);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    private void init(ActionListener evtSave){
        
        this.setBackground(new Color(255,255,255));
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new MigLayout("fill","[center]","push[center]push"));
        panelTitulo.setBackground(new Color (204, 83, 18));
        JLabel titulo = new JLabel("Gerenciar Raças");
        titulo.setFont(new Font("sansserif",3,36));
        titulo.setForeground(Color.white);
        panelTitulo.add(titulo);
      
        layout = new MigLayout("wrap","[center]","[top]push[]10[]10[]push[]push[]");
        setLayout(layout);
        this.add(panelTitulo,"span,w 100%,h 15%, pad -10 -15 0 5, wrap");
        
        JLabel lblNome = new JLabel("Nome/Raça");
        lblNome.setFont(new Font("sansserif",1,15));
        lblNome.setForeground(new Color(74,37,20));
        edtNome = new MyTextField();
        this.add(lblNome,"center,split 2,gapright 20");
        this.add(edtNome,"w 30%,center");
        
        JLabel lblVlBaseRaca = new JLabel("Valor base");
        lblVlBaseRaca.setFont(new Font("sansserif",1,15));
        lblVlBaseRaca.setForeground(new Color(74,37,20));
        edtVlBaseRaca = new MyFormattedTextField();
        try{
            maskFormatter = new MaskFormatter("R$ ###,##");
            maskFormatter.install(edtVlBaseRaca);
        }catch(Exception e){
            //log
        }
        this.add(lblVlBaseRaca,"center, split 2, gapright 20");
        this.add(edtVlBaseRaca,"w 30%,center");
    
        
        JLabel lblDesc = new JLabel("Descrição");
        lblDesc.setFont(new Font("sansserif",1,15));
        lblDesc.setForeground(new Color(74,37,20));
        edtDesc = new MyTextField();
        this.add(lblDesc,"center, split 2, gapright 20");
        this.add(edtDesc,"w 40%,center");
        
        this.btnCancelar = new ButtonOutLine();
        btnCancelar.setBackground(new Color(204,0 , 0));
        btnCancelar.setForeground(new Color(204, 0, 0));
        btnCancelar.setFocusable(false);
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev){
                edtVlBaseRaca.setValue("");
                edtNome.setText("");
                edtDesc.setText("");
                maskFormatter.install(edtVlBaseRaca);
                racaEdit = new Raca();
                infoRaca.clear();
                
            }
        });
        this.add(btnCancelar," w 20%, center,split,gapleft 10");
        
        this.btnSalvar = new ButtonOutLine();
        btnSalvar.setBackground(new Color(0, 153, 0));
        btnSalvar.setForeground(new Color(0, 153, 0));
        btnSalvar.setFocusable(false);
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(evtSave);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev){
                infoRaca.put("vlBaseRaca", edtVlBaseRaca.getText());
                infoRaca.put("nome", edtNome.getText());
                infoRaca.put("descricao",  edtDesc.getText());
                infoRaca.put("idRaca", String.valueOf( racaEdit.getIdRaca()).trim());
 
            }
        });
        
        this.add(btnSalvar,"w 20%, center");
        
        table = new TableDark();
        atualizarTabelaRaca();
        JScrollPane scrollPane = new JScrollPane(table);
        table.fixTable(scrollPane);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    JTable target = (JTable) evt.getSource();
                    int row = target.getSelectedRow();
                    Raca raca =(Raca) table.getModel().getValueAt(row, -1);
                    edtDesc.setText(raca.getDescricao());
                    edtNome.setText(raca.getNome());
                    edtVlBaseRaca.setValue(raca.getVlBaseRaca().toString());
                    racaEdit = raca;
                }
            }
        });
        this.add(scrollPane,"skip, w 95%, h 30%,pad 0 -15 10 -2");
       
    }
    public void atualizarTabelaRaca(){  
        table.setModel(racaController.atualizarTabela());
    }
    public HashMap<String,String> getInfoRaca(){
        return infoRaca;
    }
    private MigLayout layout;
    private MyTextField edtNome;
    private MyTextField edtDesc;
    private MyFormattedTextField edtVlBaseRaca;
    private ButtonOutLine btnCancelar;
    private ButtonOutLine btnSalvar;
    private TableDark table;
    private RacaController racaController = new RacaController();
    private Raca racaEdit = new Raca();
    private HashMap<String,String> infoRaca = new HashMap<>();
    private MaskFormatter maskFormatter;
    // Variables declaration - do not modify                     
    // End of variables declaration 
}
    

