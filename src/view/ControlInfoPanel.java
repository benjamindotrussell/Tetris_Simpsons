package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/** 
 * inner class that is a JPanel. 
 * @author Ben Russell
 * @version 1.0
 */
class ControlInfoPanel extends JPanel {
    /**default serial id.*/
    private static final long serialVersionUID = 1L;
    
    /**
     * constructor.
     */
    public ControlInfoPanel() {
        super();
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH - 10, 16);
        setPreferredSize(d);
        setPanelSize(NewGamePanel.TEN + InfoPanel.FIVE + 1);            
        setBackground(Color.YELLOW);
        addMouseListener(new MouseAdapter() {                
            @Override
            public void mouseEntered(final MouseEvent arg0) {
                setPanelSize(InfoPanel.ONE_HUNDRED + NewGamePanel.TEN * 2 + 2);
                
            }
            @Override
            public void mouseExited(final MouseEvent arg0) {
                setPanelSize(NewGamePanel.TEN + InfoPanel.FIVE + 2);
            }
        });
    }
    /**
     * set the size of the panel.
     * @param theH the height
     */
    private void setPanelSize(final int theH) {
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH - 10, theH);
        setSize(d);
    }
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        Font font = new Font(null, NewGamePanel.TEN
                                   , NewGamePanel.TEN * 2 - 2);
        
        g2D.setFont(font);
        final int ten = NewGamePanel.TEN;
        g2D.drawString("Controlls" , NewGamePanel.TEN * InfoPanel.FIVE, ten + InfoPanel.FIVE);
        font = new Font(null, NewGamePanel.TEN
                                   , NewGamePanel.TEN + 2);
        g2D.setFont(font);
        g2D.drawString("Left: A", InfoPanel.FIVE, InfoPanel.FORTY - ten - InfoPanel.FOUR);
        g2D.drawString("Right: D", InfoPanel.FIVE, InfoPanel.FORTY - 2);
        g2D.drawString("Down: S", InfoPanel.FIVE, InfoPanel.FIVE * ten);
        g2D.drawString("Hard Drop: W", InfoPanel.FIVE, InfoPanel.FIVE * ten + ten + 2);
        g2D.drawString("Rotate Left: Left Arrow", InfoPanel.FIVE
                       , InfoPanel.FORTY * 2 - ten + InfoPanel.FOUR);
        g2D.drawString("Rotate Right: Right Arrow", InfoPanel.FIVE
                       , InfoPanel.ONE_HUNDRED - ten - InfoPanel.FOUR);
        g2D.drawString("Pause: P", InfoPanel.FIVE, InfoPanel.ONE_HUNDRED - 2);
        g2D.drawString("New Game: N", InfoPanel.FIVE, InfoPanel.ONE_HUNDRED + ten);
        
    }
}
