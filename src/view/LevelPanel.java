/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Board;

/**
 * generate a panel that displays the current level.
 * @author Ben Russell
 * @version 1.0
 */
public class LevelPanel extends JPanel implements Observer {

    /**default serial id.*/
    private static final long serialVersionUID = 1L;
    /** 
     * constructor.
     */
    public LevelPanel() {
        super();
        final Dimension d = new Dimension(50, 20);
        setPreferredSize(d);
        
    }
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        final Font font = new Font(null, NewGamePanel.TEN
                                   , NewGamePanel.TEN * 2 - 2);        
        g2D.setFont(font);
        g2D.setPaint(Color.RED);
        g2D.drawString("Lv. ", InfoPanel.FIVE, NewGamePanel.TEN * 2 - InfoPanel.FIVE);
        //g2D.drawString(myScore.toString(), 20, 15);
    }
    @Override
    public void update(final Observable theObservable, final Object theData) {
        if (theObservable instanceof Board || theData instanceof List) {
            System.out.print(theData);
        }
    }
    
}
