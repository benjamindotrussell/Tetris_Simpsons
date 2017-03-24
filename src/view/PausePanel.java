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

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Board;

/**
 * creates a pause button.
 * @author Ben Russell
 * @version 1.0
 */
public class PausePanel extends JPanel {

    /**default serial id. */
    private static final long serialVersionUID = 1L;
    /**
     * constructor.
     * @param theTimer the timer
     * @param theBoard the board
     */
    public PausePanel(final Board theBoard, final Timer theTimer) {
        super();
        setBackground(Color.BLACK);
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH - 10, 30);
        setPreferredSize(d);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent theArg) {
                if (theTimer.isRunning()) {
                    theTimer.stop();
                    final int i = JOptionPane.showConfirmDialog(null
                                                  , "Would you like to start a new game?"
                                                  , "pause"
                                                  , JOptionPane.YES_NO_OPTION
                                                  , JOptionPane.QUESTION_MESSAGE);
                    if (i == 1) {
                        theTimer.start();
                    } else {
                        theBoard.newGame();
                        theTimer.start();
                    }
                    
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
        final Font font = new Font("Bold", NewGamePanel.TEN, NewGamePanel.TEN * 2);
        g2D.setFont(font);
        g2D.drawString("Pause", PreviewPanel.FIFTY + NewGamePanel.TEN, NewGamePanel.TEN * 2);
    }
}
