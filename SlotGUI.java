import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SlotGUI extends JFrame
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        SlotGame gui = new SlotGame();
        f.setSize(510+10,510+40);
        f.getContentPane().add(new SlotGame());
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
