import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.io.IOException;
public class PongGame extends JPanel implements Runnable,KeyListener
{
    Thread runner; 
    private Image Buffer;
    private Graphics gBuffer;
    private char c = 'e';
    int width,height;
    PongBall B1;
    PongRectangle R1,R2;
    boolean downKey;
    boolean upKey;
    boolean spaceKey;
    boolean wKey;
    boolean sKey;
    boolean oneKey;
    boolean twoKey;
    Paddle p;
    int player1,player2;
    int play;
    int z;
    public void init(int W,int H)
    {  
        width=W;
        height=H;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        B1 = new PongBall(-1);
        R1 = new PongRectangle(1,0,195);
        R2 = new PongRectangle(1,width-35,195);
        addKeyListener(this);
        player1 = 0;
        player2 = 0;
        play = 0;
        z = 0;
    }
    public void start()
    { 
        if (runner == null)
        {   
            runner = new Thread (this);
            runner.start();
        }
    }
    public void stop()
    {  
        runner = null;
    }
    public void run() 
    {  
        while(true)
        {
            try {runner.sleep(25);}
            catch (Exception e) { }    
            gBuffer.setColor(Color.black);
            gBuffer.fillRect(0,0,width,height);
            String s1 = "Hit 1 for single player";
            String s2 = "Hit 2 for co-op playing";
            gBuffer.setColor(Color.blue);
            gBuffer.setFont(new Font("Calibri",20,50));
            gBuffer.drawString(s1,75,120);
            gBuffer.drawString(s2,75,190);
            if(oneKey){play=1;}
            if(play==1)
            {
                gBuffer.setColor(Color.black);
                gBuffer.fillRect(0,0,width,height);
                if(upKey){R1.moveUp();}
                if(downKey){R1.moveDown();}
                B1.movePongBall(width,height);
                R2.moveRectangle(545,height);
                if(R1.ballCollision(B1))
                {
                    player1 = player1 + 1;
                }
                if(R2.ballCollision(B1))
                {
                    player2 = player2 + 1;
                }
                gBuffer.setFont(new Font("Calibri",20,50));
                gBuffer.setColor(Color.blue);
                String p1score = String.valueOf(player1);
                gBuffer.drawString(p1score,0,40);
                String p2score = String.valueOf(player2);
                gBuffer.drawString(p2score,width-50,40);
                B1.paint(gBuffer);
                R1.paint(gBuffer);
                R2.paint(gBuffer);
                if(player1 == 10)
                {
                    String temp = "Player 1 Wins!";
                    gBuffer.drawString(temp,20,250);
                    gBuffer.drawString("Hit space to continue",20,310);
                    if(spaceKey){endGame();break;}
                }
                if(player2 == 10)
                {
                    String temp = "Player 2 Wins!";
                    gBuffer.drawString(temp,20,250);
                    gBuffer.drawString("Hit space to continue",20,310);
                    if(spaceKey){endGame();break;}
                }
                repaint();
            }
            if(twoKey){play=2;}
            if(play==2)
            {
                gBuffer.setColor(Color.black);
                gBuffer.fillRect(0,0,width,height);
                if(upKey){R2.moveUp();}
                if(downKey){R2.moveDown();}
                if(wKey){R1.moveUp();}
                if(sKey){R1.moveDown();}
                B1.movePongBall(width,height);
                if(R1.ballCollision(B1))
                {
                    player1 = player1 + 1;
                }
                if(R2.ballCollision(B1))
                {
                    player2 = player2 + 1;
                }
                gBuffer.setFont(new Font("Calibri",20,50));
                gBuffer.setColor(Color.blue);
                String p1score = String.valueOf(player1);
                gBuffer.drawString(p1score,0,40);
                String p2score = String.valueOf(player2);
                gBuffer.drawString(p2score,width-50,40);
                B1.paint(gBuffer);
                R1.paint(gBuffer);
                R2.paint(gBuffer);
                if(player1 == 10)
                {
                    String temp = "Player 1 Wins!";
                    gBuffer.drawString(temp,20,250);
                    gBuffer.drawString("Hit space to continue",20,310);
                    if(spaceKey){endGame();break;}
                }
                if(player2 == 10)
                {
                    String temp = "Player 2 Wins!";
                    gBuffer.drawString(temp,20,250);
                    gBuffer.drawString("Hit space to continue",20,310);
                    if(spaceKey){endGame();break;}
                }
                repaint();
            }
            repaint();
        }//while(true)
    }//run    
    public void endGame()
    {
        while(z==0)
        {
            PongGUI r = new PongGUI();
            JFrame p = r.getFrame();
            p.setVisible(false);
            p.dispose();
            //try{
                JavaGames t = new JavaGames();
                t.setVisible(true);
            //}catch( IOException io){}
            z++;
        }
    }
    public void update(Graphics g)
    {  
        paint(g);
    } 
    public void paint(Graphics g)
    {
        g.drawImage(Buffer,0,0, this);
    }
    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
    public void keyPressed(KeyEvent e) 
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            upKey = true;
            break;
            case KeyEvent.VK_DOWN:
            downKey = true;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = true;
            break;
            case KeyEvent.VK_1:
            oneKey = true;
            break;
            case KeyEvent.VK_2:
            twoKey = true;
            break;
            case KeyEvent.VK_W:
            wKey = true;
            break;
            case KeyEvent.VK_S:
            sKey = true;
            break;
        }
    }
    public void keyReleased(KeyEvent e) 
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            upKey = false;
            break;
            case KeyEvent.VK_DOWN:
            downKey = false;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = false;
            break;
            case KeyEvent.VK_1:
            oneKey = false;
            break;
            case KeyEvent.VK_2:
            twoKey = false;
            break;
            case KeyEvent.VK_W:
            wKey = false;
            break;
            case KeyEvent.VK_S:
            sKey = false;
            break;
        }
    }
    public void keyTyped(KeyEvent e) 
    {
        c = e.getKeyChar();
        repaint();
    }

}