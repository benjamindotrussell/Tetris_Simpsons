/*
  * TCSS 305 - Project Tetris
 */
package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Board;

/**
 * Class generates a panel for all other info related panels to nest into.
 * @author Ben Russell
 * @version 1.0
 */
public class GameInfoPanel extends JPanel {

    /**default serial id. */
    private static final long serialVersionUID = 1L;
    
    /**
     * constructor.
     * @param theBoard the board
     * @param theTimer the swing timer
     */
    public GameInfoPanel(final Board theBoard, final Timer theTimer) {
        super();
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT);
        setPreferredSize(d);
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, 1));
        add(new TitlePanel());
        add(new InfoPanel(theBoard, theTimer));
        
        final PreviewPanel p = new PreviewPanel();
        add(p);
        theBoard.addObserver(p);
    }

    
}
