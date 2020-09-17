import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HockyGUI
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        HockyGame gui = new HockyGame();
        f.setSize(1000+10,700+40);
        f.getContentPane().add(new FroggerGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        f.add(gui);
        gui.init(1000,700);
        gui.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
