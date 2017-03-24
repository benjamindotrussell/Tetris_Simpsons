/*
 * TCSS 305 - Project Tetris
 */
package view;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;


/**
 * driver class.
 * @author Ben Russell
 * @version 1.0
 */
public final class TetrisMain {

    /**
     * 
     */
    private TetrisMain() {
        throw new IllegalStateException();
    }

    /**
     * constructor.
     * @param theArgs the command line input.
     */
    public static void main(final String[] theArgs) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (final UnsupportedLookAndFeelException e) {
           
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TetrisGUI().start();
            }
        });
    }

}
