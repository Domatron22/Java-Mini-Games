import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TrollRunGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        TrollRunGame gui = new TrollRunGame();
        f.setSize(810+10,510+40);
        f.getContentPane().add(new TrollRunGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        f.add(gui);
        gui.init(810,510);
        gui.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
