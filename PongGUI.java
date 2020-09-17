import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PongGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        PongGame temp = new PongGame();
        f.setVisible(true);
        f.setSize(600+20,600+20);
        f.getContentPane().add(new PongGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(temp);
        temp.init(600,600);
        temp.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
