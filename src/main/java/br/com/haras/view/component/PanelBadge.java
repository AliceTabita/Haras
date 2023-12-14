package br.com.haras.view.component;

import br.com.haras.model.enums.Status;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBadge extends JPanel{
    private int raioCantos;
    private Color bgColor; 
    private Color fontColor;
    private JLabel label;
    private String labelText;
    
    public PanelBadge(String label, Color bgColor, Color fontColor) {
        super(new BorderLayout());
        
        this.init(label, bgColor, fontColor);
    }
    
    private void init(String label, Color bgColor, Color fontColor){
        
        this.bgColor = new Color(bgColor.getRed(),bgColor.getGreen(),bgColor.getBlue(),200);
        this.fontColor = fontColor;
        this.labelText = label;
        this.label = new JLabel(this.labelText);
        this.label.setFont(new Font("sansserif", Font.BOLD, 10));
        this.label.setForeground(Color.WHITE);
        
        this.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        this.setBackground(this.bgColor );
        this.add(this.label, BorderLayout.CENTER);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setOpaque(false);

        Graphics2D g2 = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 36, 36);

        // Pinte o painel com as bordas curvadas
        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        // Desenhe a borda do painel
        //g2.setColor(getForeground());
        //g2.draw(roundedRectangle);

        g2.dispose();
    };

    /**
     * @return the raioCantos
     */
    public int getRaioCantos() {
        return raioCantos;
    }

    /**
     * @param raioCantos the raioCantos to set
     */
    public void setRaioCantos(int raioCantos) {
        this.raioCantos = raioCantos;
        this.repaint();
    }

    /**
     * @return the bgColor
     */
    public Color getBgColor() {
        return bgColor;
    }

    /**
     * @param bgColor the bgColor to set
     */
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
        this.repaint();
    }

    /**
     * @return the fontColor
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * @param fontColor the fontColor to set
     */
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
        this.repaint();
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
        this.repaint();
    }

    /**
     * @return the labelText
     */
    public String getLabelText() {
        return labelText;
    }

    /**
     * @param labelText the labelText to set
     */
    public void setLabelText(String labelText) {
        this.labelText = labelText;
        this.repaint();
    }
}
