import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BSGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        BSGame gui = new BSGame();
        f.setSize(600+10,600+40);
        f.getContentPane().add(new BSGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        f.add(gui);
        gui.init(580,580);
        gui.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
