/*
 * TCSS 305 - Project Tetris
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * generates a title panel.
 * @author Ben Russell
 * @version 1.0
 */
class TitlePanel extends JPanel {

    /** default serial id. */
    private static final long serialVersionUID = 1L;
    /** an image. */
    private Image myImage;

    /**
     * 
     */
    public TitlePanel() {
        super();
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH, 100);
        setPreferredSize(d);
        setBackground(Color.BLACK);
        try {
            myImage = 
             (new ImageIcon(getClass().getResource("/tetris-logo.jpg"))).getImage();
        } catch (final IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        if (Objects.nonNull(myImage)) {
            g2D.drawImage(myImage, 1, 1
                          , GamePanel.PANEL_WIDTH
                          , GamePanel.PANEL_WIDTH / 2, this);
        }
    }
}
