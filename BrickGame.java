import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
public class BrickGame extends JPanel implements Runnable,KeyListener
{    
    Thread runner; 
    private Image Buffer;
    private Graphics gBuffer;
    private char c = 'e';
    int width,height;
    BrickBall B1;
    ArrayList BrickBallList;
    BrickBall temp,temp2;
    ArrayList bricks;
    BrickRectangle rTemp;
    int bx,by,bw,bh;
    BrickRectangle R1,R2;
    boolean leftKey;
    boolean rightKey;
    boolean spaceKey;
    boolean upKey;
    Paddle p;
    int points;
    int start;
    int z;
    boolean t;
    public void init(int W,int H)
    {  
        width=590;
        height=590;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        B1 = new BrickBall(-1);
        p = new Paddle();
        bricks = new ArrayList();
        bx = 5;
        by = 5;
        bw = 20;
        bh = 10;
        int count = 0;
        for(int i = 0; i < 160;i++)
        {
            rTemp = new BrickRectangle(bx,by,bw,bh,0,0);
            bx = bx + 25;
            count++;
            if(count == 32)
            {
                by = by + 15;
                bx = 5;
                count = 0;
            }
            bricks.add(rTemp);
        }
        addKeyListener(this);
        points = 0;
        start = 0;
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
            if(rightKey){p.moveRight();}
            if(leftKey){p.moveLeft();}
            if(upKey){start++;}
            repaint();
            try {runner.sleep(25);}
            catch (Exception e) { }   
            gBuffer.setColor(Color.black);
            gBuffer.fillRect(0,0,width,height);
            gBuffer.setColor(Color.blue);
            gBuffer.setFont(new Font("Calibri",20,50));
            gBuffer.drawString("Hit up arrow to start",50,50);
            if(start!=0)
            {
                gBuffer.setColor(Color.black);
                gBuffer.fillRect(0,0,width,height);
                B1.moveBrickBall(width,height);
                p.ballCollision(B1);
                for(int j = 0; j < bricks.size();j++)
                {
                    rTemp = (BrickRectangle)bricks.get(j);
                    if(rTemp.BrickBallCollision(B1))
                    {
                        bricks.remove(j);
                        points = points + 1;
                        break;
                    }
                }
                String P = String.valueOf(points);
                gBuffer.setColor(Color.blue);
                gBuffer.setFont(new Font("Calibri",20,60));
                gBuffer.drawString(P,0,540);
                for(int i = 0; i < bricks.size();i++)
                {
                    rTemp = (BrickRectangle)bricks.get(i);
                    rTemp.paint(gBuffer);
                }
                B1.paint(gBuffer);
                p.paint(gBuffer);
                if(B1.getY()>height)
                {
                    String s1 = "Game Over";
                    String s2 = "You lose!";
                    String s5 = "You win!";
                    String s3 = "You got " +points +" Points";
                    String s4 = "Hit space key to continue";
                    try{
                        t = BrickHS.checkHS(points, t);
                        if(t==true)
                        {
                            gBuffer.drawString(s5,50,160);
                        }else{
                            if(t==false)
                            {
                                gBuffer.drawString(s2,50,160);
                            }
                        }
                    }catch( IOException io ) {}
                    gBuffer.drawString(s1,50,90);
                    gBuffer.drawString(s3,50,230);
                    gBuffer.setFont(new Font("Calibri",20,50));
                    gBuffer.drawString(s4,50,300);
                    if(spaceKey){endGame();break;}
                }
                repaint();
            }
            repaint();
        }//while(true)
    } //run    
    public void endGame()
    {
        while(z==0)
        {
            BrickGUI r = new BrickGUI();
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
            case KeyEvent.VK_LEFT:
            leftKey = true;
            break;
            case KeyEvent.VK_RIGHT:
            rightKey = true;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = true;
            break;
            case KeyEvent.VK_UP:
            upKey = true;
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
            case KeyEvent.VK_UP:
            upKey = false;
            break;
        }
    }
    public void keyTyped(KeyEvent e) 
    {
        c = e.getKeyChar();
        repaint();
    }
}
