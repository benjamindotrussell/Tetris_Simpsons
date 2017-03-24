/*
  * TCSS 305 - Project Tetris
 */
package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import model.Board;


/**
 * Class generates the GUI.
 * @author Ben Russell
 * @version 1.0
 */
public class TetrisGUI {
    /** the initial delay for the timer. */
    public static final int INITIAL_DELAY = 200; 
    /** the normal delay for the timer. */
    public static final int DELAY = 1100; 

    /** an instance of the game board. */
    private final Board myBoard;
    /**
     * constructor.
     */
    public TetrisGUI() {
        myBoard = new Board();
    }
    /**
     * set of the GUI. 
     */
    public void start() {
        final JFrame frame = new JFrame("Homer's Totally Tubular Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);
        final ImageIcon image = new ImageIcon("images/homersimpson.gif");
        final Image largeImage =
                       image.getImage().getScaledInstance(16, -8, java.awt.Image.SCALE_SMOOTH);
        
        frame.setIconImage(largeImage);
        final Timer timer = new Timer(DELAY, event -> myBoard.step()); 
        final CustomBackground cp = new CustomBackground(myBoard, timer);
        final GameInfoPanel gip = new GameInfoPanel(myBoard, timer);
        frame.setLayout(new FlowLayout());
        frame.add(cp);
        frame.add(gip);
        final KeyListener k = new KeyPressListener(myBoard, timer);
        frame.addKeyListener(k);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
//        final PreviewPanel p = new PreviewPanel();
//        myBoard.addObserver(p);
        
        timer.setInitialDelay(INITIAL_DELAY);
        
    }
}
