import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SpaceGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        SpaceGame gui = new SpaceGame();
        f.setSize(1200+10,650+40);
        f.getContentPane().add(new SpaceGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        f.add(gui);
        gui.init(650,1200);
        gui.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
