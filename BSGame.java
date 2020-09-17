import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
public class BSGame extends JPanel implements Runnable,KeyListener
{    
    Thread runner; 
    private Image Buffer;
    private Graphics gBuffer;
    private char c = 'e';
    int width,height;
    BSBall ball;
    ArrayList balls;
    BSBall bTemp;
    int bx,by,bw,bh;
    boolean leftKey;
    boolean rightKey;
    boolean spaceKey;
    boolean upKey;
    int points;
    int start;
    int z,n;
    boolean t;
    BSPaddle p;
    BSRectangle paddle;
    int timer;
    public void init(int W,int H)
    {  
        width=590;
        height=590;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        balls = new ArrayList();
        bx = 5;
        by = 5;
        bw = 20;
        bh = 10;
        int count = 0;
        for(int i = 0; i < 160;i++)
        {
            bTemp = new BSBall(bx,by,-1);
            bx = bx + 25;
            count++;
            if(count == 32)
            {
                by = by + 15;
                bx = 5;
                count = 0;
            }
            balls.add(bTemp);
        }
        addKeyListener(this);
        points = 0;
        start = 0;
        z = 0;
        t = false;
        p = new BSPaddle();
        ball= new BSBall(p.getX(),p.getY(),69);
        n=0;
        paddle = new BSRectangle(225,550,35,60,0,0);
        timer = 1000;
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
            if(upKey){n = 1;}
            if(leftKey){p.moveLeft();}
            if(rightKey){p.moveRight();}
            if(spaceKey){start=1;}
            repaint();
            try {runner.sleep(25);}
            catch (Exception e) { }   
            gBuffer.setColor(Color.black);
            gBuffer.fillRect(0,0,width,height);
            gBuffer.setColor(Color.blue);
            gBuffer.setFont(new Font("Calibri",20,50));
            gBuffer.drawString("Hit Space key to start",50,50);
            if(start!=0)
            {
                if(n == 1)
                {
                    ball.shoot(p.getX(),p.getY(),p.getX2(),p.getY2(),p);
                }
                if(ball.getY()<0)
                {
                    ball.respawn(p);
                    n=0;
                }
                gBuffer.setColor(Color.black);
                gBuffer.fillRect(0,0,width,height);
                for(int j = 0; j < balls.size();j++)
                {
                    bTemp = (BSBall)balls.get(j);
                    if(bTemp.BSBallCollision(ball))
                    {
                        balls.remove(j);
                        points = points + 1;
                        n = 0;
                        //break;
                    }
                }
                String P = String.valueOf(points);
                String T = String.valueOf(timer);
                gBuffer.setColor(Color.blue);
                gBuffer.setFont(new Font("Calibri",20,60));
                gBuffer.drawString(P,0,540);
                gBuffer.drawString(T,450,540);
                for(int i = 0; i < balls.size();i++)
                {
                    bTemp = (BSBall)balls.get(i);
                    bTemp.paint(gBuffer);
                }
                ball.paint(gBuffer);
                p.paint(gBuffer);
                paddle.paint(gBuffer);
                if(timer<=0)
                {
                    String s1 = "Game Over";
                    String s2 = "You lose!";
                    String s5 = "You win!";
                    String s3 = "You got " +points +" Points";
                    String s4 = "Hit space key to continue";
                    try{
                        t = BSHS.checkHS(points, t);
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
                timer = timer - 1;
            }
            repaint();
        }//while(true)
    } //run    
    public void endGame()
    {
        while(z==0)
        {
            BSGUI r = new BSGUI();
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
