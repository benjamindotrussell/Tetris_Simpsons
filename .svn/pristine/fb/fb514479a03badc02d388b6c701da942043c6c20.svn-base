/*
 * TCSS 305 - Project Tetris
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Block;
import model.Board;


/**
 * this panel draws the game.
 * 
 * @author Ben Russell
 * @version 1.0
 */
public class GamePanel extends JPanel implements Observer {
    /** constant value to set the piece at a correct y coordinate. */
    public static final int THREE_SEVENTY_FOUR = 374;
    /** the initial width of the panel. */
    public static final int PANEL_WIDTH = 201;
    /** the initial height of the panel. */
    public static final int PANEL_HEIGHT = 400;
    /** constant size of a block. */
    public static final int BLOCK_SIZE = 20;
    /**default serial id. */
    private static final long serialVersionUID = 1L;
    /** the board data. */
    private List<?> myBoardData;
    /** the Timer. */
    private final Timer myTimer;
    /** the game over splash screen. */
    private final GameOverPanel myGOP;
    /**
     * constructor.
     * @param theBoard representation of the game board
     * @param theTimer the Timer.
     */
    public GamePanel(final Board theBoard, final Timer theTimer) {
        super();
        setup();
        theBoard.addObserver(this);
        myTimer = theTimer;
        myGOP = new GameOverPanel();
        myGOP.setVisible(false);
        add(myGOP);
        setFocusable(true);
        addKeyListener(new KeyPressListener(theBoard, theTimer));
    }
    /**
     * set up the panel.
     */
    private void setup() {
        final Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
    }
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        if (Objects.nonNull(myBoardData)) {
            for (int i = 0; i < myBoardData.size(); i++) {
                final Block[] b = (Block[]) myBoardData.get(i);
                for (int j = 0; j < b.length; j++) {
                    if (b[j] != null) {
                        g2D.setPaint(paintBrick(b[j]));
                        g2D.fillRect(j * BLOCK_SIZE, THREE_SEVENTY_FOUR - i * BLOCK_SIZE
                                     , BLOCK_SIZE, BLOCK_SIZE);
                        g2D.setPaint(Color.BLACK);
                        g2D.drawRect(j * BLOCK_SIZE, THREE_SEVENTY_FOUR - i * BLOCK_SIZE
                                     , BLOCK_SIZE, BLOCK_SIZE);
                    }
                }
            }
        }
    }
    
    @Override
    public void update(final Observable theObservable, final Object theArg) {
        myBoardData = new ArrayList<Block[]>();
        if (theObservable instanceof Board) {
            if (theArg instanceof Boolean) {
                myTimer.stop();                
                myGOP.setVisible(true); 
            } else if (theArg instanceof List<?>) {                
                myBoardData = (List<?>) theArg;
            }
        }
        repaint();
    }
    /** 
     * method that sets the color of each brick.
     * 
     * @param theBlock the current block.
     * @return color the color of the brick
     */
    public Color paintBrick(final Block theBlock) {
        Color color = Color.WHITE;
        if (theBlock == Block.L) {        
            color = Color.BLUE;
        } else if (theBlock == Block.S) {
            color = Color.RED;
        } else if (theBlock == Block.Z) {
            color = Color.CYAN;
        } else if (theBlock == Block.J) {
            color = Color.YELLOW;
        } else if (theBlock == Block.T) {
            color = Color.PINK;
        } else if (theBlock == Block.I) {
            color = Color.DARK_GRAY;
        } else if (theBlock == Block.O) {
            color = Color.GREEN;
        }
        return color;
    }

    /**
     * inner class to generate a game over panel.
     * @author Ben Russell
     * @version 1.0
     */
    class GameOverPanel extends JPanel {
        
        /**default serial id. */
        private static final long serialVersionUID = 1L;
        /** the game over panel. */
        private final JPanel myPanel;
        /**
         * constructor.
         */
        public GameOverPanel() {
            super();
            myPanel = this;
            final JLabel l = new JLabel();
            final ImageIcon image = new ImageIcon("images/homer-doh.jpg");
            
            final Image largeImage =
                           image.getImage().getScaledInstance(PANEL_WIDTH, PANEL_HEIGHT
                                                              , java.awt.Image.SCALE_SMOOTH);
            final ImageIcon scaledImage = new ImageIcon(largeImage);
            l.setIcon(scaledImage);
            setLayout(new BorderLayout());
            add(l, BorderLayout.CENTER);
            addMouseListener(new MouseAdapter() {                
                @Override
                public void mousePressed(final MouseEvent theArg) {
                    myPanel.setVisible(false);
                }
            });
        }
    }
}
