/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.haras.view.component;

import br.com.haras.model.Anuncio;
import br.com.haras.model.Cliente;
import br.com.haras.model.Equino;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import net.miginfocom.swing.MigLayout;

public class PanelImageSlider extends javax.swing.JLayeredPane {

    /**
     * Creates new form PanelImageSlider
     */
    private int indiceAnuncioAtual = 0;

    private Anuncio[] anuncios;

    public PanelImageSlider() {
        initComponents();
        //TODO criar metodo para chamada da controler e buscar a lista de anuncios
        
        this.atualizaInformacoes();

        Timer timeout = new Timer(5,taskPerformer);
        timeout.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JLabel();
        next = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        imageCotainer = new javax.swing.JLabel();
        detalhes = new javax.swing.JPanel();

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/sliderControls/back.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/sliderControls/next.png"))); // NOI18N
        next.setMaximumSize(new java.awt.Dimension(40, 40));
        next.setMinimumSize(new java.awt.Dimension(40, 40));
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });

        imageCotainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Image_not_available.png"))); // NOI18N

        detalhes.setPreferredSize(new java.awt.Dimension(368, 0));

        javax.swing.GroupLayout detalhesLayout = new javax.swing.GroupLayout(detalhes);
        detalhes.setLayout(detalhesLayout);
        detalhesLayout.setHorizontalGroup(
            detalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        detalhesLayout.setVerticalGroup(
            detalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(imageCotainer, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageCotainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(detalhes, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(back)
                .addGap(18, 18, 18)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(248, 248, 248))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        this.back();
    }//GEN-LAST:event_backMouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        this.next();
    }//GEN-LAST:event_nextMouseClicked

    ActionListener taskPerformer = (ActionEvent evt) -> {
        next();
    };

    private ImageIcon getImage(String path){
        try{
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            return new ImageIcon(image);
            
        }catch (IOException exp) {
            exp.printStackTrace();
    }
    return new ImageIcon(getClass().getResource("/imgs/Image_not_available.png")); 
    }
    
    
    private void atualizaImagem() {
         //TODO alterar para puxar o bytearray da imagem
        ImageIcon icon = new ImageIcon(this.anuncios[this.indiceAnuncioAtual].getEquino().getNome());
        Image imagemAtual = icon.getImage().getScaledInstance(this.imageCotainer.getWidth(), this.imageCotainer.getHeight(), Image.SCALE_SMOOTH);

        this.imageCotainer.setIcon(new ImageIcon(imagemAtual));

    }

    private void atualizaDetalhes() {
        Anuncio anuncio = this.anuncios[this.indiceAnuncioAtual];
        Equino equino = anuncio.getEquino();
        Cliente anunciante = anuncio.getAnunciante();

        this.detalhes.setLayout(new MigLayout("wrap", "push[center]push", "[]10[]10[]10[]10[]push"));
        this.detalhes.add(new JLabel("Detalhes: "));
        this.detalhes.add(new JLabel("Animal: " + equino.getNome()));
        this.detalhes.add(new JLabel("Anunciante: " + anunciante.getNome()));
         
        String[] valor = (anuncio.getVlAnuncio().toString()+"00").split("\\.");
        JLabel animalPrice = new JLabel("R$ "+valor[0] +","+valor[1].substring(0, 2));
        animalPrice.setFont(new Font("Arial", Font.BOLD, 16));
        this.detalhes.add(animalPrice);
    }

    private void atualizaInformacoes() {
        this.atualizaImagem();
        this.atualizaDetalhes();
    }

    public void next() {
        this.indiceAnuncioAtual += 1;
        this.atualizaInformacoes();
    }

    public void back() {
        this.indiceAnuncioAtual -= 1;
        this.atualizaInformacoes();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JPanel body;
    private javax.swing.JPanel detalhes;
    private javax.swing.JLabel imageCotainer;
    private javax.swing.JLabel next;
    // End of variables declaration//GEN-END:variables

}
