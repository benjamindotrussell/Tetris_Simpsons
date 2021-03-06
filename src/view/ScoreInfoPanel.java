/*
 * TCSS 305 - Project Tetris
 */
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
 * Score panel. 
 * @author Ben Russell
 * @version 1.0
 */
class ScoreInfoPanel extends JPanel {
    
    /**default serial id.*/
    private static final long serialVersionUID = 1L;
    
    
    /**
     * constructor.
     */
    public ScoreInfoPanel() {
        super();
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH - 10, 16);
        setPreferredSize(d);
        setPanelSize(NewGamePanel.TEN + InfoPanel.FIVE + 1);            
        setBackground(Color.YELLOW);
        addMouseListener(new MouseAdapter() {                
            @Override
            public void mouseEntered(final MouseEvent arg0) {
                setPanelSize(InfoPanel.ONE_HUNDRED);
                
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
        g2D.drawString("Score:" , NewGamePanel.TEN * InfoPanel.FIVE, ten + InfoPanel.FIVE);
        font = new Font(null, NewGamePanel.TEN
                                   , NewGamePanel.TEN + 2);
        g2D.setFont(font);
        g2D.drawString("Each frozen block + 4pts.", InfoPanel.FIVE
                       , InfoPanel.FORTY - ten);
        g2D.drawString("1 Line cleared + 40pts * Lv.", InfoPanel.FIVE, InfoPanel.FIVE * ten);
        g2D.drawString("2 Lines cleared + 100pts * Lv.", InfoPanel.FIVE
                       , InfoPanel.FIVE * ten + ten + 2);
        g2D.drawString("3 Lines cleared + 300pts * Lv.", InfoPanel.FIVE
                       , InfoPanel.FORTY * 2 - ten + InfoPanel.FOUR);
        g2D.drawString("4 Lines cleared + 1200pts * Lv.", InfoPanel.FIVE
                       , InfoPanel.FORTY * 2 + InfoPanel.FOUR + 2);
        
    }
}