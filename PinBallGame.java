import javax.swing.*;
import java.applet.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.IOException;
import javax.swing.event.*;
import java.awt.event.KeyListener;
public class PinBallGame extends JPanel implements Runnable,KeyListener
{    
    Thread runner; 
    private Image Buffer;
    private Graphics gBuffer;
    private char c = 'e';
    int width,height;
    PinBallBall B1;
    PinBallPaddle P1,P2;
    PinBallRectangle R1,R2,R3,R4,R5;
    PinBallRectangle[] rArray;
    boolean leftKey;
    boolean rightKey;
    boolean downKey;
    boolean spaceKey;
    int points,points2;
    int count,count2;
    Random gen = new Random();
    PinBallBall[] bArray;
    int pValue;
    int z;
    boolean t;
    int lifes;
    public void init(int W,int H)
    {  
        width=W;
        height=H;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        B1 = new PinBallBall(1,width-57,645,14);
        P1 = new PinBallPaddle(180,625,255,640);
        P2 = new PinBallPaddle(300,640,375,625);
        R1 = new PinBallRectangle(-2,width-35,0,15,700);
        R2 = new PinBallRectangle(-2,width-80,80,15,620);
        R3 = new PinBallRectangle(-2,0,625,180,40);
        R4 = new PinBallRectangle(-2,375,625,140,40);
        R5 = new PinBallRectangle(-2,width-80,0,15,80);
        rArray = new PinBallRectangle[10];
        for(int i=0; i<rArray.length; i++)
        {
            rArray[i] = new PinBallRectangle(-1,gen.nextInt(450),gen.nextInt(450),gen.nextInt(60)+10,gen.nextInt(60)+10);
        }
        bArray = new PinBallBall[5];
        for(int i=0; i<bArray.length; i++)
        {
            bArray[i] = new PinBallBall(-1,gen.nextInt(450),gen.nextInt(450),gen.nextInt(18)+10);
        }
        count = 0;
        count2 = 0;
        addKeyListener(this);
        points = 0;
        points2 = 0;
        pValue = 0;
        lifes = 1;
        z = 0;
        t = false;
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
            if(leftKey){P1.moveLeftPaddle();}
            if(rightKey){P2.moveRightPaddle();}
            if(downKey){B1.launchBall(width,height);}
            repaint();
            try {runner.sleep(25);}
            catch (Exception e) { }   
            gBuffer.setColor(Color.black);
            gBuffer.fillRect(0,0,width,height);
            if((B1.getX() != width-57)||(B1.getY() != 645))
            {
                B1.movePinBallBall(width,height);
                B1.update();
            }
            if(B1.getX()+B1.getDiameter()<R5.getX())
            {
                count = 1;
                count2 = 1;
            }
            if(count == 1)
            {
                R5.ballCollision(B1);
                repaint();
            }
            R1.ballCollision(B1);
            repaint();
            R2.ballCollision(B1);
            repaint();
            R3.ballCollision(B1);
            repaint();
            R4.ballCollision(B1);
            repaint();
            P1.ballCollision(B1);
            repaint();
            P2.ballCollision(B1);
            repaint();
            for(int i=0; i<rArray.length; i++)
            {
                if(rArray[i].ballCollision(B1))
                {
                    int temp = rArray[i].getColor();
                    if(temp == 2)
                    {
                        pValue = 5;
                    }else{
                        if(temp == 3)
                        {
                            pValue = 10;
                        }else{
                            if(temp == 4)
                            {
                                pValue = 15;
                            }else{
                                if(temp==5)
                                {
                                    pValue = 20;
                                }
                            }
                        }
                    }
                    points = points + pValue;
                    points2 = points2 + pValue;
                }
                repaint();
            }
            for(int i=0; i<bArray.length; i++)
            {
                if(bArray[i].BallCollision(B1))
                {
                    int temp = bArray[i].getColor();
                    if(temp == 2)
                    {
                        pValue = 5;
                    }else{
                        if(temp == 3)
                        {
                            pValue = 10;
                        }else{
                            if(temp == 4)
                            {
                                pValue = 15;
                            }else{
                                if(temp==5)
                                {
                                    pValue = 20;
                                }
                            }
                        }
                    }
                    points = points + pValue;
                    points2 = points2 + pValue;
                }
                repaint();
            }
            for(int i=0; i<rArray.length; i++)
            {
                rArray[i].paint(gBuffer);
            }
            for(int i=0; i<bArray.length; i++)
            {
                bArray[i].paint(gBuffer);
            }
            if(points2 >= 100)
            {
                for(int i=0; i<rArray.length; i++)
                {
                    rArray[i] = new PinBallRectangle(-1,gen.nextInt(450),gen.nextInt(450),gen.nextInt(60)+10,gen.nextInt(60)+10);
                }
                for(int i=0; i<bArray.length; i++)
                {
                    bArray[i] = new PinBallBall(-1,gen.nextInt(450),gen.nextInt(450),gen.nextInt(18)+10);
                }
                points2 = 0;
            }
            repaint();
            B1.paint(gBuffer);
            R1.paint(gBuffer);
            R2.paint(gBuffer);
            R3.paint(gBuffer);
            R4.paint(gBuffer);
            if(count2==1)
            {
                R5.paint(gBuffer);
            }
            P1.paint(gBuffer);
            P2.paint(gBuffer);
            repaint();
            String pointValue = String.valueOf(points);
            gBuffer.setFont(new Font("Calibri",20,50));
            gBuffer.drawString(pointValue,20,40);
            repaint();
            if(B1.getY()>height+10)
            {
                lifes = lifes - 1;
                count = 0;
                count2 = 0;
            }
            repaint();
            if(lifes==0)
            {
                String s1 = "Game Over";
                String s2 = "You got " +points +" points";
                String s3 = "New High Score!";
                String s4 = "Space to continue";
                gBuffer.setFont(new Font("Calibri",20,50));
                gBuffer.drawString(s1,50,50);
                gBuffer.drawString(s2,50,110);
                gBuffer.drawString(s4,50,160);
                PinBallHS temp = new PinBallHS();
                try{
                    t = temp.checkHS(points,t);
                    if(t)
                    {
                        gBuffer.drawString(s3,50,220);
                    }
                }catch( IOException io ) {}
                if(spaceKey){endGame();break;}
                repaint();
            }
            repaint();
        }//while(true)
    }//run    
    public void endGame()
    {
        while(z==0)
        {
            PinBallGUI r = new PinBallGUI();
            JFrame p = r.getFrame();
            p.setVisible(false);
            p.dispose();
            JavaGames t = new JavaGames();
            t.setVisible(true);
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
            case KeyEvent.VK_LEFT:
            leftKey = true;
            break;
            case KeyEvent.VK_RIGHT:
            rightKey = true;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = true;
            break;
            case KeyEvent.VK_DOWN:
            downKey = true;
            break;
        }
    }
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
            leftKey = false;
            break;
            case KeyEvent.VK_RIGHT:
            rightKey = false;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = false;
            break;
            case KeyEvent.VK_DOWN:
            downKey = false;
            break;
        }
    }
    public void keyTyped(KeyEvent e) 
    {
        c = e.getKeyChar();
        repaint();
    }
}