import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FroggerGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        FroggerGame gui = new FroggerGame();
        f.setSize(510+10,510+40);
        //f.getContentPane().add(new FroggerGame());
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
