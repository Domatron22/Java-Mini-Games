import javax.swing.*;
import java.awt.*;
import java.applet.*;
public class PinBallGUI extends JFrame 
{
    static JFrame f = new JFrame();
    public static void main(String[] args)
    {
        PinBallGame temp = new PinBallGame();
        f.setVisible(true);
        f.setSize(600,700+20);
        f.getContentPane().add(new PinBallGame());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(temp);
        temp.init(600,700);
        temp.start();
    }
    public JFrame getFrame()
    {
        return f;
    }
}
