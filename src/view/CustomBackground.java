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
import javax.swing.Timer;

import model.Board;


/**
 * @author Ben Russell
 * @version 1.0
 */
public class CustomBackground extends JPanel {
    /** the red RBG value. */
    public static final int RED = 132;
    /** the blue RBG value. */
    public static final int BLUE = 245;
    /** the green RBG value. */
    public static final int GREEN = 132;
    /** constant for the x coordinates to place the image at. */
    public static final int IMAGE_X = 40;
    /**default serial id. */
    private static final long serialVersionUID = 1L;
    /** an image for the background.*/
    private Image myImage;
    
    /**
     * constructor.
     * @param theBoard represents the game board
     * @param theTimer the timer
     */
    public CustomBackground(final Board theBoard, final Timer theTimer) {
        super();
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT);
        setPreferredSize(d);
        setImage();
        setBackground(new Color(RED, BLUE, GREEN));
        final GamePanel gp = new GamePanel(theBoard, theTimer);
        
        gp.setOpaque(false);
        add(gp);
    }
    /**
     * set the image.
     */
    private void setImage() {
        try {
            myImage = 
                 new ImageIcon(getClass().getResource("/homeroninnertube.gif")).getImage();
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
        g2D.setBackground(Color.WHITE);
        if (Objects.nonNull(myImage)) {
            g2D.drawImage(myImage, IMAGE_X + 2, IMAGE_X - 2, GamePanel.PANEL_WIDTH / 2
                          , GamePanel.PANEL_WIDTH / 2, this);
        }
    }
}
