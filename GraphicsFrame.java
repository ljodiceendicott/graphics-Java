/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ljodi937.shapes;

/**
 *
 * @author jodic
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.FontMetrics;

public class GraphicsFrame extends javax.swing.JFrame {

    /**
     * Creates new form GraphicsFrame
     */
    public GraphicsFrame() {
        initComponents();
    }
@Override 
    public void paint(Graphics g) { 
        // if you don't call super, bad things happen.  Comment it out and see.
        super.paint(g);
        
        // the JVM actually calls paint() with a Graphics2D instance, which 
        // has more methods than a Graphics instance so it is safe to cast it
        Graphics2D g2 = (Graphics2D)g; 
        
        // https://docs.oracle.com/javase/tutorial/2d/text/renderinghints.html
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        
        // https://docs.oracle.com/javase/tutorial/2d/text/fonts.html#logical-fonts
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        g2.setFont(font); 

        // from https://docs.oracle.com/javase/tutorial/2d/text/measuringtext.html
        // get metrics from the graphics
        FontMetrics metrics = g.getFontMetrics(font);
        // get the height/advance of a line of text in this
        // font and render context
        int textH = metrics.getHeight();
        int textW = metrics.stringWidth("Hello Graphics2D!");
        
        // I'm doing some basic math to try to center this (but it's not exact
        // because JFrames have window Frames as part of their size...)
        int textX = this.getWidth()/2 - textW/2;
        int textY = this.getHeight()/2 - textH/2;

        // draw the string!
        g2.drawString("This is a Test", textX, textY); 
        g.drawRect(32, 32, 20, 20);
        g.drawOval(64, 64, 20, 20);
        g.drawLine(32,32,84,84);
        g.drawLine(40,70,84,84);
        g.drawLine(75,60,84,84);
        //before the adjustments
        g.drawOval(textX, textY, textW, textH);
        //after some adjustment
        g.drawOval(textX-20,textY-textH,textW+20,textH);
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(GraphicsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
