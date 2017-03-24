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
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Block;
import model.Board;
import model.Point;
import model.TetrisPiece;

/**
 * this panel show a next piece.
 * 
 * @author Ben Russell
 * @version 1.0
 */
public class PreviewPanel extends JPanel implements Observer {
    /** constant for the integer 15. */
    public static final int TWENTY_FIVE = 25;
    /** constant for setting the tetris piece at an appropriate spot. */
    public static final int FIFTY = 50;
    /** constant for setting the tetris piece at an appropriate spot. */
    public static final int SEVENTY = 70;
    /**default serial id.*/
    private static final long serialVersionUID = 1L;
    /**the next piece. */
    private TetrisPiece myNextPiece;
    /**
     * constructor.
     */
    public PreviewPanel() {
        super();
        final Dimension d = new Dimension(GamePanel.PANEL_WIDTH, 100);
        setPreferredSize(d);
        setBackground(Color.LIGHT_GRAY);
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        final Font font = new Font("Bold", NewGamePanel.TEN
                                   , NewGamePanel.TEN + 8);
        g2D.setFont(font);
        g2D.drawString("Next Piece Preview", NewGamePanel.TEN + NewGamePanel.TEN
                       , NewGamePanel.TEN + NewGamePanel.TEN);
        if (Objects.nonNull(myNextPiece)) {
            drawPiece(g2D, myNextPiece);
        }
    }
    /**
     * draw a piece on the board.
     * @param theG the graphics
     * @param theP the tetris piece
     */
    private void drawPiece(final Graphics2D theG, final TetrisPiece theP) {
        
        if (theP == TetrisPiece.T) {
            drawT(theG);
        } else if (theP == TetrisPiece.O || theP == TetrisPiece.I) {
            drawOI(theG, theP);
            
        } else if (theP == TetrisPiece.L) {
            drawL(theG);
        } else if (theP == TetrisPiece.J) {
            drawJ(theG);
        } else if (theP == TetrisPiece.S) {
            theG.setPaint(Color.RED);
            theG.fillRect(FIFTY, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.fillRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.fillRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.fillRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.setPaint(Color.BLACK);
            theG.drawRect(FIFTY, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.drawRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.drawRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.drawRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        } else if (theP == TetrisPiece.Z) {
            theG.setPaint(Color.CYAN);
            theG.fillRect(FIFTY, TWENTY_FIVE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.fillRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.fillRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.fillRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.setPaint(Color.BLACK);
            theG.drawRect(FIFTY, TWENTY_FIVE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.drawRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.drawRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
            theG.drawRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        }
    }
    /** 
     * draw an O or I piece.
     * @param theG the graphics
     * @param theP the tetris piece.
     */
    private void drawOI(final Graphics2D theG, final TetrisPiece theP) {
        theG.setPaint(paintBrick(theP.getBlock()));
        for (final Point p : myNextPiece.getPoints()) {
            theG.fillRect(FIFTY + p.x() * GamePanel.BLOCK_SIZE
                         , NewGamePanel.TEN + p.y() * GamePanel.BLOCK_SIZE
                         , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        }
        theG.setPaint(Color.BLACK);
        for (final Point p : myNextPiece.getPoints()) {
            theG.drawRect(FIFTY + p.x() * GamePanel.BLOCK_SIZE
                          , NewGamePanel.TEN +  p.y() * GamePanel.BLOCK_SIZE
                          , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        }
    }

    /** 
     * draw a J piece.
     * @param theG the graphics
     */
    private void drawJ(final Graphics2D theG) {
        theG.setPaint(Color.YELLOW);
        theG.fillRect(FIFTY, TWENTY_FIVE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.setPaint(Color.BLACK);
        theG.drawRect(FIFTY, TWENTY_FIVE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
    }

    /** 
     * draw a L piece.
     * @param theG the graphics
     */
    private void drawL(final Graphics2D theG) {
        theG.setPaint(Color.BLUE);
        theG.fillRect(FIFTY, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.setPaint(Color.BLACK);
        theG.drawRect(FIFTY, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
    }
    /** 
     * draw a T piece.
     * @param theG the graphics
     */
    private void drawT(final Graphics2D theG) {
        theG.setPaint(Color.PINK);
        theG.fillRect(FIFTY, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                     , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE
                     , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                     , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.fillRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                     , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.setPaint(Color.BLACK);
        theG.drawRect(FIFTY, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY + GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
        theG.drawRect(FIFTY + 2 * GamePanel.BLOCK_SIZE, TWENTY_FIVE + GamePanel.BLOCK_SIZE
                      , GamePanel.BLOCK_SIZE, GamePanel.BLOCK_SIZE);
    }

    @Override
    public void update(final Observable theObservable, final Object theArg) {
        if (theObservable instanceof Board && theArg instanceof TetrisPiece) {
            
            myNextPiece = (TetrisPiece) theArg;
            
            repaint();
        }
        
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
    
}
