import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SnakeGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        SnakeGame gui = new SnakeGame();
        f.setSize(510+10,510+10);
        f.getContentPane().add(new SnakeGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        f.add(gui);
        gui.init(510,510);
        gui.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
