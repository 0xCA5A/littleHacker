import javax.swing.JFrame;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;


public class LittleHacker {

    final JFrame jFrame = new JFrame("LittleHacker");

    private void initJFrame(JFrame frame) {
        // Set up the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setUndecorated(true);
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.GREEN);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void run() {
        initJFrame(jFrame);

        final RandomColorStrategy colorStrategy = new RandomColorStrategy();
        final MyKeyEventDispatcher keyEventDispatcher = new MyKeyEventDispatcher(colorStrategy);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
            }
        });
    }

    class MyKeyEventDispatcher implements KeyEventDispatcher {

        private final ColorStrategy colorStrategy;

        MyKeyEventDispatcher(ColorStrategy colorStrategy) {
            this.colorStrategy = colorStrategy;
        }

        @Override
        public boolean dispatchKeyEvent(final KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_TYPED) {
                Color newFrameColor = colorStrategy.getColorByChar(e.getKeyChar());
                jFrame.getContentPane().setBackground(newFrameColor);
                jFrame.repaint();

            }
            // Pass the KeyEvent to the next KeyEventDispatcher in the chain
            return false;
        }
    }

}
