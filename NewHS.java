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
import java.util.*;
public class NewHS extends JFrame
{
    private JMenuBar menuBar;
    private JButton Continue;
    private JTextField textfield1;
    boolean spaceKey;
    String defualtUser;
    public NewHS() throws IOException
    {
        this.setTitle("Java Games");
        this.setSize(500,400);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400,200));
        int width = 400;
        int height = 200;
        contentPane.setBackground(new Color(8,8,252));
        String sys = System.getProperty("user.home");
        String fileurl = sys +"\\Documents\\JavaGames\\HighScores\\";
        File newfile = new File(fileurl);
        newfile.mkdir();
        File TrappedU = new File(fileurl +"TrappedHS_user.txt");
        boolean Trapped = TrappedU.createNewFile();
        File TrappedS = new File(fileurl +"TrappedHS_score.txt");
        boolean Trapped2 = TrappedS.createNewFile();
        File SpaceU = new File(fileurl +"SpaceHS_user.txt");
        boolean Space = SpaceU.createNewFile();
        File SpaceS = new File(fileurl +"SpaceHS_score.txt");
        boolean Space2 = SpaceS.createNewFile();
        File SnakeU = new File(fileurl +"SnakeHS_user.txt");
        boolean Snake = SnakeU.createNewFile();
        File SnakeS = new File(fileurl +"SnakeHS_score.txt");
        boolean Snake2 = SnakeS.createNewFile();
        File BSU = new File(fileurl +"BSHS_user.txt");
        boolean BS = BSU.createNewFile();
        File BSS = new File(fileurl +"BSHS_score.txt");
        boolean BS2 = BSS.createNewFile();
        File SlotU = new File(fileurl +"SlotHS_user.txt");
        boolean Slot = SlotU.createNewFile();
        File SlotS = new File(fileurl +"SlotHS_score.txt");
        boolean Slot2 = SlotS.createNewFile();
        File TrollU = new File(fileurl +"TrollHS_user.txt");
        boolean Troll = TrollU.createNewFile();
        File TrollS = new File(fileurl +"TrollHS_score.txt");
        boolean Troll2 = TrollS.createNewFile();
        File FroggerU = new File(fileurl +"FroggerHS_user.txt");
        boolean Frogger = FroggerU.createNewFile();
        File FroggerS = new File(fileurl +"FroggerHS_score.txt");
        boolean Frogger2 = FroggerS.createNewFile();
        File BrickU = new File(fileurl +"BrickHS_user.txt");
        boolean Brick = BrickU.createNewFile();
        File BrickS = new File(fileurl +"BrickHS_score.txt");
        boolean Brick2 = BrickS.createNewFile();
        File PinBallU = new File(fileurl +"PinBallHS_user.txt");
        boolean PinBall = PinBallU.createNewFile();
        File PinBallS = new File(fileurl +"PinBallHS_score.txt");
        boolean PinBall2 = PinBallS.createNewFile();

        Continue = new JButton();
        Continue.setBounds(width/2-45,height/2+17,90,35);
        Continue.setBackground(new Color(255,255,255));
        Continue.setForeground(new Color(0,0,0));
        Continue.setEnabled(true);
        Continue.setFont(new Font("sansserif",0,12));
        Continue.setText("Continue");
        Continue.setVisible(true);
        if(PinBall&&PinBall2&&Brick&&Brick2&&Trapped&&Trapped2&&Space&&Space2&&Snake&&Snake2&&BS&&BS2&&Slot&&Slot2&&Troll&&Troll2&&Frogger&&Frogger2)
        {
            try{
                writeNull();
            }catch(IOException io){}
            textfield1 = new JTextField();
            textfield1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            textfield1.setBounds(width/2-122,height/2-52,230,52);
            textfield1.setBackground(new Color(0,168,251));
            textfield1.setForeground(new Color(0,0,0));
            textfield1.setEditable(false);
            textfield1.setFont(new Font("SansSerif",0,22));
            textfield1.setText("Compleate!");
            textfield1.setVisible(true);
            contentPane.add(textfield1);
        }else{
            textfield1 = new JTextField();
            textfield1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            textfield1.setBounds(width/2-122,height/2-52,230,52);
            textfield1.setBackground(new Color(0,168,251));
            textfield1.setForeground(new Color(0,0,0));
            textfield1.setEditable(false);
            textfield1.setFont(new Font("SansSerif",0,22));
            textfield1.setText("Error files already exist");
            textfield1.setVisible(true);
            contentPane.add(textfield1);
        }
            
        contentPane.add(Continue);
        Continue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Continue();
            }
        });
        if(spaceKey){Continue();}
        getRootPane().setDefaultButton(Continue);
        add(contentPane);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(false);
    }
    public void writeNull() throws IOException
    {
        String sys = System.getProperty("user.home");
        String D = sys +"//Documents//JavaGames//HighScores";
        File inputFile = new File(D+"\\PinBallHS_score.txt");
        Scanner scan = new Scanner(inputFile);
        defualtUser = "No User";
        int score = 0;
        FileWriter f1 = new FileWriter(D+"\\PinBallHS_score.txt");
        PrintWriter output = new PrintWriter(f1);
        output.print(score);
        f1.close();
        FileWriter f2 = new FileWriter(D+"\\PinBallHS_user.txt");
        PrintWriter outPut = new PrintWriter(f2);
        outPut.print(defualtUser); 
        f2.close();
        FileWriter f3 = new FileWriter(D+"\\BrickHS_score.txt");
        PrintWriter output1 = new PrintWriter(f3);
        output1.print(score);
        f3.close();
        FileWriter f4 = new FileWriter(D+"\\BrickHS_user.txt");
        PrintWriter outPut2 = new PrintWriter(f4);
        outPut2.print(defualtUser); 
        f4.close();
        FileWriter f5 = new FileWriter(D+"\\TrollHS_score.txt");
        PrintWriter output3 = new PrintWriter(f5);
        output3.print(score);
        f5.close();
        FileWriter f6 = new FileWriter(D+"\\TrollHS_user.txt");
        PrintWriter outPut4 = new PrintWriter(f6);
        outPut4.print(defualtUser); 
        f6.close();
        FileWriter f7 = new FileWriter(D+"\\SpaceHS_score.txt");
        PrintWriter output5 = new PrintWriter(f7);
        output5.print(score);
        f7.close();
        FileWriter f8 = new FileWriter(D+"\\SpaceHS_user.txt");
        PrintWriter outPut6 = new PrintWriter(f8);
        outPut6.print(defualtUser); 
        f8.close();
        FileWriter f9 = new FileWriter(D+"\\TrappedHS_score.txt");
        PrintWriter output7 = new PrintWriter(f9);
        output7.print(score);
        f9.close();
        FileWriter f10 = new FileWriter(D+"\\TrappedHS_user.txt");
        PrintWriter outPut8 = new PrintWriter(f10);
        outPut8.print(defualtUser); 
        f10.close();
        FileWriter c1 = new FileWriter(D+"\\SlotHS_score.txt");
        PrintWriter output9 = new PrintWriter(c1);
        output9.print(score);
        c1.close();
        FileWriter c2 = new FileWriter(D+"\\SlotHS_user.txt");
        PrintWriter outPut10 = new PrintWriter(c2);
        outPut10.print(defualtUser); 
        c2.close();
        FileWriter c3 = new FileWriter(D+"\\SnakeHS_score.txt");
        PrintWriter output11 = new PrintWriter(c3);
        output11.print(score);
        c3.close();
        FileWriter c8 = new FileWriter(D+"\\SnakeHS_user.txt");
        PrintWriter outPut12 = new PrintWriter(c8);
        outPut12.print(defualtUser); 
        c8.close();
        FileWriter c4 = new FileWriter(D+"\\BSHS_score.txt");
        PrintWriter output13 = new PrintWriter(c4);
        output13.print(score);
        c4.close();
        FileWriter c5 = new FileWriter(D+"\\BSHS_user.txt");
        PrintWriter outPut14 = new PrintWriter(c5);
        outPut14.print(defualtUser); 
        c5.close();
        FileWriter c6 = new FileWriter(D+"\\FroggerHS_score.txt");
        PrintWriter output15 = new PrintWriter(c6);
        output15.print(score);
        c6.close();
        FileWriter c7 = new FileWriter(D+"\\FroggerHS_user.txt");
        PrintWriter outPut16 = new PrintWriter(c7);
        outPut16.print(defualtUser); 
        c7.close();
    }
    private void Continue ()
    {
        
        dispose();
    }
     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try{
                    new NewHS();
                }catch( IOException io ){}
            }
        });
    }
}