import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
public class SnakeGame extends JPanel implements Runnable,KeyListener
{    
    Thread runner; 
    private Image Buffer;
    private Graphics gBuffer;
    private char c = 'e';
    int width,height;
    boolean leftKey;
    boolean rightKey;
    boolean spaceKey;
    boolean upKey;
    boolean downKey;
    SnakeRectangle s;
    ArrayList se;
    SnakeRectangle stemp;
    int points;
    int start;
    int z;
    boolean t;
    int count;
    SnakeRectangle stemp2;
    SnakeRectangle snew;
    ArrayList test;
    public void init(int W,int H)
    {  
        width=W;
        height=H;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        addKeyListener(this);
        points = 0;
        start = 0;
        z = 0;
        t = false;
        se = new ArrayList();
        for(int i=0; i<5; i++)
        {
            stemp = new SnakeRectangle(-1);
            se.add(stemp);
        }
        test = new ArrayList();
        for(int i=0; i<1; i++)
        {
            stemp2 = new SnakeRectangle(250,250,25,25,2,2);
            test.add(stemp2);
        }
        s = (SnakeRectangle)test.get(0);
        count = 1;
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
            if(rightKey){s.moveRight();}
            if(leftKey){s.moveLeft();}
            if(upKey){s.moveUP();}
            if(downKey){s.moveDown();}
            if(spaceKey){start++;}
            repaint();
            try {runner.sleep(25);}
            catch (Exception e) { }   
            gBuffer.setColor(Color.black);
            gBuffer.fillRect(0,0,width,height);
            gBuffer.setColor(Color.blue);
            gBuffer.setFont(new Font("Calibri",20,50));
            gBuffer.drawString("Hit Space to start",50,50);
            if(start!=0)
            {
                gBuffer.setColor(Color.black);
                gBuffer.fillRect(0,0,width,height);
                for(int i=0; i<se.size(); i++)
                {
                    stemp = (SnakeRectangle)se.get(i);
                    if(stemp.collision(s))
                    {
                        stemp.setMove(true);
                        test.add(stemp);
                        se.remove(stemp);
                        snew = new SnakeRectangle(-1);
                        se.add(snew);
                        points = points + 10;
                    }
                }
                for(int i=0; i<test.size(); i++)
                {
                    if(i==1)
                    {
                        stemp = (SnakeRectangle)test.get(i);
                        if(rightKey){stemp.setX(s.getX()-25);stemp.setY(s.getY());}
                        if(leftKey){stemp.setX(s.getX()+25);stemp.setY(s.getY());}
                        if(upKey){stemp.setY(s.getY()+25);stemp.setX(s.getX());}
                        if(downKey){stemp.setY(s.getY()-25);stemp.setX(s.getX());}
                    }else{
                        if(i>1)
                        {
                            stemp2 = (SnakeRectangle)test.get(i);
                            stemp = (SnakeRectangle)test.get(i-1);
                            if(rightKey){stemp2.setX(stemp.getX()-25);stemp2.setY(stemp.getY());}
                            if(leftKey){stemp2.setX(stemp.getX()+25);stemp2.setY(stemp.getY());}
                            if(upKey){stemp2.setY(stemp.getY()+25);stemp2.setX(stemp.getX());}
                            if(downKey){stemp2.setY(stemp.getY()-25);stemp2.setX(stemp.getX());}
                        }
                    }
                }
                if(s.getX()<=0){count=2;}//s.setX(s.getX()+2);count = 2;}
                if(s.getX()+25>=510){count=2;}//s.setX(s.getX()-2);count = 2;}
                if(s.getY()<=0){count=2;}//s.setY(s.getY()+2);count = 2;}
                if(s.getY()+25>=510){count=2;}//s.setY(s.getY()-2);count = 2;}
                if(count==2)
                {
                    String s1 = "Game Over";
                    String s2 = "You lose!";
                    String s5 = "You win!";
                    String s3 = "You got " +points +" Points";
                    String s4 = "Hit space key to continue";
                    gBuffer.setColor(Color.blue);
                    try{
                        t = SnakeHS.checkHS(points, t);
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
                    gBuffer.setFont(new Font("Calibri",20,40));
                    gBuffer.drawString(s4,50,300);
                    if(spaceKey){endGame();break;}
                    repaint();
                }
                for(int i=0; i<test.size(); i++)
                {
                    stemp2 = (SnakeRectangle)test.get(i);
                    stemp2.paint(gBuffer);
                }
                for(int i=0; i<se.size(); i++)
                {
                    stemp = (SnakeRectangle)se.get(i);
                    stemp.paint(gBuffer);
                }
                gBuffer.setFont(new Font("Calibri",20,50));
                gBuffer.setColor(Color.blue);
                gBuffer.drawString(String.valueOf(points),0,height-60);
                repaint();
            }
            repaint();
        }//while(true)
    } //run    
    public void endGame()
    {
        while(z==0)
        {
            SnakeGUI r = new SnakeGUI();
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
            case KeyEvent.VK_UP:
            upKey = true;
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
            case KeyEvent.VK_UP:
            upKey = false;
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
