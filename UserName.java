import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;
import java.io.*;
public class UserName extends JFrame
{
    private JMenuBar menuBar;
    private JButton Continue;
    private JTextField textfield1;
    private JTextField userName;
    String user;
    boolean spaceKey;
    public UserName() throws IOException
    {
        this.setTitle("Java Games");
        this.setSize(500,400);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(8,8,252));
        Continue = new JButton();
        Continue.setBounds(192,206,90,35);
        Continue.setBackground(new Color(255,255,255));
        Continue.setForeground(new Color(0,0,0));
        Continue.setEnabled(true);
        Continue.setFont(new Font("sansserif",0,12));
        Continue.setText("Continue");
        Continue.setVisible(true);
        textfield1 = new JTextField();
        textfield1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textfield1.setBounds(137,68,216,52);
        textfield1.setBackground(new Color(0,168,251));
        textfield1.setForeground(new Color(0,0,0));
        textfield1.setEditable(false);
        textfield1.setFont(new Font("SansSerif",0,22));
        textfield1.setText("    Enter your name");
        textfield1.setVisible(true);
        userName = new JTextField();
        userName.setBounds(137,135,216,52);
        userName.setBackground(new Color(255,255,255));
        userName.setForeground(new Color(0,0,0));
        userName.setEnabled(true);
        userName.setFont(new Font("SansSerif",0,22));
        userName.setText("");
        userName.setVisible(true);
        contentPane.add(Continue);
        contentPane.add(textfield1);
        contentPane.add(userName);
        Continue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                user = userName.getText();
                Continue(user);
            }
        });
        if(spaceKey){Continue(user);}
        getRootPane().setDefaultButton(Continue);
        add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    private void Continue (String user)
    {
        HighScores.currentUser(user);
        dispose();
        try{
            NewHS h = new NewHS();
        }catch(IOException io){}
        JFrame temp = new JavaGames();
    }
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_SPACE:
            spaceKey = true;
            break;
        }
    }
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_SPACE:
            spaceKey = false;
            break;
        }
    }
     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try{
                    new UserName();
                }catch( IOException io ){}
            }
        });
    }
}