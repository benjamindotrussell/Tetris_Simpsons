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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Board;



/**
 * class generates a new game panel.
 * @author Ben Russell
 * @version 1.0
 */
public class NewGamePanel extends JPanel {
    /** constant for the number ten. */
    public static final int TEN = 10;
   
    /**default serial id.*/
    private static final long serialVersionUID = 1L;
    /**
     * constructor.
     * @param theBoard the board
     * @param theTimer the swing timer
     */
    public NewGamePanel(final Board theBoard, final Timer theTimer) {
        super();
        setBackground(Color.BLACK);
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH - 10, 30);
        setPreferredSize(d);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent theArg) {
                if (!theTimer.isRunning()) {
                    theBoard.newGame();
                    theTimer.start();
                }
            }
        });
    }
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setPaint(Color.YELLOW);
        final Font font = new Font("Bold", TEN, TEN + TEN);
        g2D.setFont(font);
        g2D.drawString("New Game", PreviewPanel.FIFTY, TEN + TEN);
    }
    
}
