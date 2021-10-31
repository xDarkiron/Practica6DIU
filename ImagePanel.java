package pck_practica6;

/**
 *
 * @author Airam
 * @author Gioele
 * 
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImagePanel extends javax.swing.JPanel {

    private final static int WIDTH_DEFAULT = 500;
    private final static int HEIGHT_DEFAULT = 600;
    private BufferedImage image;

    public ImagePanel() {
        initComponents();
        this.setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            //g.drawImage(image.getScaledInstance(this.getWidth(), this.getHeight(), image.SCALE_SMOOTH), 0, 0, this);
        }
    }

    public void setImage(BufferedImage bi) {
        image = bi;
        repaint();
    }

    public BufferedImage getImage() {
        return image == null ? null : image;
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
            .addGap(0, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}