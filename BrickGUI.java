import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BrickGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        BrickGame gui = new BrickGame();
        f.setSize(600+20,600+20);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.getContentPane().add(new BrickGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(gui);
        gui.init(600,600);
        gui.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
