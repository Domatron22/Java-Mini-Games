import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PacManGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        PacManDemo temp = new PacManDemo();
        f.setVisible(true);
        f.setSize(845,485);
        f.getContentPane().add(new BrickGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(temp);
        temp.init(830,450);
        temp.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
