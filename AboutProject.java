import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AboutProject extends JFrame
{
    private JTextField Graphical,Graphical2;
	private JTextField Pong,Pong2;
	private JTextField Trapped,Trapped2;
	private JTextField Frogger,Frogger2;
	private JTextField Brick,Brick2;
	private JTextField PinBall,PinBall2;
	private JTextField Hocky,Hocky2;
	private JTextField Snake,Snake2;
	private JTextField BS,BS2;
	private JTextField Slot,Slot2;
	private JTextField Troll,Troll2;
	private JTextField Space,Space2;
	private JButton exit;
	public AboutProject()
	{
	    setTitle("About");
		setSize(600,500);
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(1000,440));
		contentPane.setBackground(new Color(8,8,252));
		Graphical = new JTextField();
		Graphical.setBounds(104,22,109,37);
		Graphical.setBackground(new Color(0,168,251));
		Graphical.setForeground(new Color(0,0,0));
		Graphical.setEditable(false);
		Graphical.setFont(new Font("sansserif",0,12));
		Graphical.setText("App Development");
		Graphical.setVisible(true);
		Pong = new JTextField();
		Pong.setBounds(104,205,109,37);
		Pong.setBackground(new Color(0,168,251));
		Pong.setForeground(new Color(0,0,0));
		Pong.setEditable(false);
		Pong.setFont(new Font("sansserif",0,12));
		Pong.setText("Pong Game");
		Pong.setVisible(true);
		Frogger = new JTextField();
		Frogger.setBounds(104,83,109,37);
		Frogger.setBackground(new Color(0,168,251));
		Frogger.setForeground(new Color(0,0,0));
		Frogger.setEditable(false);
		Frogger.setFont(new Font("sansserif",0,12));
		Frogger.setText("Frogger Game");
		Frogger.setVisible(true);
		Trapped = new JTextField();
		Trapped.setBounds(104,144,109,37);
		Trapped.setBackground(new Color(0,168,251));
		Trapped.setForeground(new Color(0,0,0));
		Trapped.setEditable(false);
		Trapped.setFont(new Font("sansserif",0,12));
		Trapped.setText("Trapped Game");
		Trapped.setVisible(true);
		Graphical2 = new JTextField();
		Graphical2.setBounds(252,22,109,37);
		Graphical2.setBackground(new Color(0,168,251));
		Graphical2.setForeground(new Color(0,0,0));
		Graphical2.setEditable(false);
		Graphical2.setFont(new Font("sansserif",0,12));
		Graphical2.setText("Zack Cecere");
		Graphical2.setVisible(true);
		Pong2 = new JTextField();
		Pong2.setBounds(252,205,109,37);
		Pong2.setBackground(new Color(0,168,251));
		Pong2.setForeground(new Color(0,0,0));
		Pong2.setEditable(false);
		Pong2.setFont(new Font("sansserif",0,12));
		Pong2.setText("Tom Trainor");
		Pong2.setVisible(true);
		Frogger2 = new JTextField();
		Frogger2.setBounds(252,83,109,37);
		Frogger2.setBackground(new Color(0,168,251));
		Frogger2.setForeground(new Color(0,0,0));
		Frogger2.setEditable(false);
		Frogger2.setFont(new Font("sansserif",0,12));
		Frogger2.setText("Zack Cecere");
		Frogger2.setVisible(true);
		Trapped2 = new JTextField();
		Trapped2.setBounds(252,144,109,37);
		Trapped2.setBackground(new Color(0,168,251));
		Trapped2.setForeground(new Color(0,0,0));
		Trapped2.setEditable(false);
		Trapped2.setFont(new Font("sansserif",0,12));
		Trapped2.setText("Mike D");
		Trapped2.setVisible(true);
		Brick = new JTextField();
		Brick.setBounds(104,266,109,37);
		Brick.setBackground(new Color(0,168,251));
		Brick.setForeground(new Color(0,0,0));
		Brick.setEditable(false);
		Brick.setFont(new Font("sansserif",0,12));
		Brick.setText("Brick Breaker");
		Brick.setVisible(true);
		Brick2 = new JTextField();
		Brick2.setBounds(252,266,109,37);
		Brick2.setBackground(new Color(0,168,251));
		Brick2.setForeground(new Color(0,0,0));
		Brick2.setEditable(false);
		Brick2.setFont(new Font("sansserif",0,12));
		Brick2.setText("Zack Cecere");
		Brick2.setVisible(true);
		PinBall = new JTextField();
		PinBall.setBounds(104,324,109,37);
		PinBall.setBackground(new Color(0,168,251));
		PinBall.setForeground(new Color(0,0,0));
		PinBall.setEditable(false);
		PinBall.setFont(new Font("sansserif",0,12));
		PinBall.setText("Pin Ball");
		PinBall.setVisible(true);
		PinBall2 = new JTextField();
		PinBall2.setBounds(252,324,109,37);
		PinBall2.setBackground(new Color(0,168,251));
		PinBall2.setForeground(new Color(0,0,0));
		PinBall2.setEditable(false);
		PinBall2.setFont(new Font("sansserif",0,12));
		PinBall2.setText("Zack Cecere");
		PinBall2.setVisible(true);
		Troll = new JTextField();
		Troll.setBounds(504,205,109,37);
		Troll.setBackground(new Color(0,168,251));
		Troll.setForeground(new Color(0,0,0));
		Troll.setEditable(false);
		Troll.setFont(new Font("sansserif",0,12));
		Troll.setText("Troll run");
		Troll.setVisible(true);
		Troll2 = new JTextField();
		Troll2.setBounds(652,205,109,37);
		Troll2.setBackground(new Color(0,168,251));
		Troll2.setForeground(new Color(0,0,0));
		Troll2.setEditable(false);
		Troll2.setFont(new Font("sansserif",0,12));
		Troll2.setText("Zack Cecere");
		Troll2.setVisible(true);
		Hocky = new JTextField();
		Hocky.setBounds(504,324,109,37);
		Hocky.setBackground(new Color(0,168,251));
		Hocky.setForeground(new Color(0,0,0));
		Hocky.setEditable(false);
		Hocky.setFont(new Font("sansserif",0,12));
		Hocky.setText("Pong Hockey");
		Hocky.setVisible(true);
		Hocky2 = new JTextField();
		Hocky2.setBounds(652,324,109,37);
		Hocky2.setBackground(new Color(0,168,251));
		Hocky2.setForeground(new Color(0,0,0));
		Hocky2.setEditable(false);
		Hocky2.setFont(new Font("sansserif",0,12));
		Hocky2.setText("Nick Headen");
		Hocky2.setVisible(true);
		
		Space = new JTextField();
		Space.setBounds(504,22,109,37);
		Space.setBackground(new Color(0,168,251));
		Space.setForeground(new Color(0,0,0));
		Space.setEditable(false);
		Space.setFont(new Font("sansserif",0,12));
		Space.setText("Space Game");
		Space.setVisible(true);
		Space2 = new JTextField();
		Space2.setBounds(652,22,109,37);
		Space2.setBackground(new Color(0,168,251));
		Space2.setForeground(new Color(0,0,0));
		Space2.setEditable(false);
		Space2.setFont(new Font("sansserif",0,12));
		Space2.setText("Dominic Triano");
		Space2.setVisible(true);
		Snake = new JTextField();
		Snake.setBounds(504,83,109,37);
		Snake.setBackground(new Color(0,168,251));
		Snake.setForeground(new Color(0,0,0));
		Snake.setEditable(false);
		Snake.setFont(new Font("sansserif",0,12));
		Snake.setText("Snake");
		Snake.setVisible(true);
		Snake2 = new JTextField();
		Snake2.setBounds(652,83,109,37);
		Snake2.setBackground(new Color(0,168,251));
		Snake2.setForeground(new Color(0,0,0));
		Snake2.setEditable(false);
		Snake2.setFont(new Font("sansserif",0,12));
		Snake2.setText("Zack Cecere");
		Snake2.setVisible(true);
		BS = new JTextField();
		BS.setBounds(504,144,109,37);
		BS.setBackground(new Color(0,168,251));
		BS.setForeground(new Color(0,0,0));
		BS.setEditable(false);
		BS.setFont(new Font("sansserif",0,12));
		BS.setText("Bubble Shooter");
		BS.setVisible(true);
		BS2 = new JTextField();
		BS2.setBounds(652,144,109,37);
		BS2.setBackground(new Color(0,168,251));
		BS2.setForeground(new Color(0,0,0));
		BS2.setEditable(false);
		BS2.setFont(new Font("sansserif",0,12));
		BS2.setText("Zack Cecere");
		BS2.setVisible(true);
		Slot = new JTextField();
		Slot.setBounds(504,266,109,37);
		Slot.setBackground(new Color(0,168,251));
		Slot.setForeground(new Color(0,0,0));
		Slot.setEditable(false);
		Slot.setFont(new Font("sansserif",0,12));
		Slot.setText("Slot Machine");
		Slot.setVisible(true);
		Slot2 = new JTextField();
		Slot2.setBounds(652,266,109,37);
		Slot2.setBackground(new Color(0,168,251));
		Slot2.setForeground(new Color(0,0,0));
		Slot2.setEditable(false);
		Slot2.setFont(new Font("sansserif",0,12));
		Slot2.setText("Zack Cecere");
		Slot2.setVisible(true);
		exit = new JButton();
		exit.setBounds(378,385,109,37);
		exit.setBackground(new Color(0,168,251));
		exit.setForeground(new Color(0,0,0));
		exit.setEnabled(true);
		exit.setFont(new Font("sansserif",0,12));
		exit.setText("Exit");
		exit.setVisible(true);
		exit.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent evt){
		      Exit(evt);
		    }
		});
		contentPane.add(Hocky);
		contentPane.add(Hocky2);
		contentPane.add(Space);
		contentPane.add(Space2);
		contentPane.add(Snake);
		contentPane.add(Snake2);
		contentPane.add(BS);
		contentPane.add(BS2);
		contentPane.add(Slot);
		contentPane.add(Slot2);
		contentPane.add(Troll);
		contentPane.add(Troll2);
		contentPane.add(PinBall);
		contentPane.add(PinBall2);
		contentPane.add(Brick);
		contentPane.add(Brick2);
		contentPane.add(Graphical);
		contentPane.add(Graphical2);
		contentPane.add(Pong);
		contentPane.add(Pong2);
		contentPane.add(Frogger);
		contentPane.add(Frogger2);
		contentPane.add(Trapped);
		contentPane.add(Trapped2);
		contentPane.add(exit);
		getContentPane().add(contentPane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void Exit(ActionEvent evt)
	{
	    this.dispose();
	}
    public static void main(String[] args)
    {
        new AboutProject();
    }
}