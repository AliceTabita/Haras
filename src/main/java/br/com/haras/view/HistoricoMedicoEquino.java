package br.com.haras.view;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

public class HistoricoMedicoEquino extends javax.swing.JFrame {

    



 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jBtnCadastrar = new javax.swing.JButton();
        jBtnLimpar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelDataConsulta = new javax.swing.JLabel();
        jTextFieldConsulta = new javax.swing.JTextField();
        jLabelProprietario = new javax.swing.JLabel();
        jTextFieldProprietario = new javax.swing.JTextField();
        jLabelVeterinario = new javax.swing.JLabel();
        jTextFieldVeterinario = new javax.swing.JTextField();
        jLabelTratamento = new javax.swing.JLabel();
        jTextFieldTratamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorico = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 230, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 249, 249));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NovaLogoHaraas.png"))); // NOI18N
        jPanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 140));

        jBtnCadastrar.setBackground(new java.awt.Color(139, 77, 58));
        jBtnCadastrar.setFont(new java.awt.Font("Montserrat", 1, 10)); // NOI18N
        jBtnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCadastrar.setText("Cadastrar");
        jBtnCadastrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jBtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jBtnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, 30));

        jBtnLimpar.setBackground(new java.awt.Color(139, 77, 58));
        jBtnLimpar.setFont(new java.awt.Font("Montserrat", 1, 10)); // NOI18N
        jBtnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnLimpar.setText("Limpar campos");
        jBtnLimpar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });
        jPanelMenu.add(jBtnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 110, 30));

        jBtnEditar.setBackground(new java.awt.Color(139, 77, 58));
        jBtnEditar.setFont(new java.awt.Font("Montserrat", 1, 10)); // NOI18N
        jBtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEditar.setText("Editar");
        jBtnEditar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jBtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, 30));

        jBtnSalvar.setBackground(new java.awt.Color(139, 77, 58));
        jBtnSalvar.setFont(new java.awt.Font("Montserrat", 1, 10)); // NOI18N
        jBtnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSalvar.setText("Salvar alterações");
        jBtnSalvar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jPanelMenu.add(jBtnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 30));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 540));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HarassEquino.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 660, 80));

        jPanel2.setBackground(new java.awt.Color(244, 233, 208));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNome.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabelNome.setText("NOME");
        jPanel2.add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jTextFieldNome.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        jTextFieldNome.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 160, 20));

        jLabelDataConsulta.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabelDataConsulta.setText("DATA DA CONSULTA");
        jPanel2.add(jLabelDataConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jTextFieldConsulta.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        jTextFieldConsulta.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel2.add(jTextFieldConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 170, -1));

        jLabelProprietario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabelProprietario.setText("PROPRIETÁRIO(A)");
        jPanel2.add(jLabelProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextFieldProprietario.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        jTextFieldProprietario.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel2.add(jTextFieldProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 450, -1));

        jLabelVeterinario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabelVeterinario.setText("VETERINÁRIO(A)");
        jPanel2.add(jLabelVeterinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jTextFieldVeterinario.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        jTextFieldVeterinario.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jTextFieldVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVeterinarioActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldVeterinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 450, -1));

        jLabelTratamento.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabelTratamento.setText("TRATAMENTO");
        jPanel2.add(jLabelTratamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jTextFieldTratamento.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        jTextFieldTratamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel2.add(jTextFieldTratamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 450, -1));

        jTableHistorico.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTableHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Data da Consulta", "Proprietário(a)", "Veterinário(a)", "Tratamento"
            }
        ));
        jScrollPane1.setViewportView(jTableHistorico);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 550, 260));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(125, 67, 28));
        jLabel3.setText("Perfil de Saúde do Equino:");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 660, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarActionPerformed

        String nome = jTextFieldNome.getText();
        String dataConsulta = jTextFieldConsulta.getText();
        String proprietario = jTextFieldProprietario.getText();
        String veterinario = jTextFieldVeterinario.getText();
        String tratamento = jTextFieldTratamento.getText();

        // Chame o método cadastrarHistorico do controlador
      
        // Após cadastrar, você pode atualizar a tabela (se necessário)
        atualizarTabela();

        // Limpar os campos (se necessário)
        limparCampos();
    }


    private void atualizarTabela() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void limparCampos() {
        jTextFieldNome.setText("");
        jTextFieldConsulta.setText("");
        jTextFieldProprietario.setText("");
        jTextFieldVeterinario.setText("");
        jTextFieldTratamento.setText("");
   

    }//GEN-LAST:event_jBtnCadastrarActionPerformed

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVeterinarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVeterinarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(HistoricoMedicoEquino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    //</editor-fold>

    /* Create and display the form */
   
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCadastrar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnLimpar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDataConsulta;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelProprietario;
    private javax.swing.JLabel jLabelTratamento;
    private javax.swing.JLabel jLabelVeterinario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHistorico;
    private javax.swing.JTextField jTextFieldConsulta;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldProprietario;
    private javax.swing.JTextField jTextFieldTratamento;
    private javax.swing.JTextField jTextFieldVeterinario;
    // End of variables declaration//GEN-END:variables

    void setNome(String nome) {
    }

    void setDataConsulta(String dataConsulta) {
    }

    void setProprietario(String proprietario) {
    }

    void setVeterinario(String veterinario) {
    }

    void setTratamento(String tratamento) {
    }
}
