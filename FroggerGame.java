import java.applet.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.io.IOException;
public class FroggerGame extends JPanel implements Runnable,KeyListener
{ 
    Thread runner; 
    private Image Buffer;
    private Graphics gBuffer;
    private char c = 'e';
    int width,height;
    int timer;
    boolean leftKey;
    boolean rightKey;
    boolean upKey;
    boolean downKey;
    int z;
    boolean checkHS;
    int count;
    FroggerBall frog;
    FroggerRectangle r1,r2,r3,r4;
    FroggerRectangle[] R1,R2,c1,c2,c3,c4,c5,c6,c7,c8;
    int tx,ty,tw;
    int lifes;
    int points;
    boolean spaceKey;
    public void init(int W, int H)
    {   
        Random gen = new Random();
        width=W;
        height=H;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        timer = 1000;
        addKeyListener(this);
        z = 0;
        count = 0;
        r1 = new FroggerRectangle(0,0,width,15,1);
        r2 = new FroggerRectangle(0,215,width,15,1);
        r3 = new FroggerRectangle(0,365,width,15,1);
        r4 = new FroggerRectangle(0,450,width,15,1);
        R1 = new FroggerRectangle[24];
        tx = 0;
        ty = 75;
        points = 0;
        for(int i=0; i<R1.length; i++)
        {
            R1[i] = new FroggerRectangle(tx,ty,50,10,3);
            tx = tx + 70;
            if(tx>=500)
            {
                ty = ty + 75;
                tx = 0;
            } 
            if(ty >= 215 && ty <= 230)
            {
                ty = ty + 50;
            }
        }
        R2 = new FroggerRectangle[16];
        tw = 325;
        for(int i=0; i<R2.length; i++)
        {
            R2[i] = new FroggerRectangle(tx,tw,50,10,3);
            tx = tx + 70;
            if(tx>=500)
            {
                tw = tw + 90;
                tx = 0;
            } 
        }
        c1 = new FroggerRectangle[4];
        int t = 0;
        for(int i=0; i<c1.length; i++)
        {
            c1[i] = new FroggerRectangle(t,25,75,30,-1);
            t = t - 175;
        }
        c2 = new FroggerRectangle[5];
        int e = width;
        for(int i=0; i<c2.length; i++)
        {
            c2[i] = new FroggerRectangle(e,90,75,30,-1);
            e = e + 112;
        }
        c3 = new FroggerRectangle[5];
        t = 0;
        for(int i=0; i<c3.length; i++)
        {
            c3[i] = new FroggerRectangle(t,165,75,30,-1);
            t = t - 138;
        }
        c4 = new FroggerRectangle[5];
        e = width;
        for(int i=0; i<c4.length; i++)
        {
            c4[i] = new FroggerRectangle(e,240,75,25,-1);
            e = e + 148;
        }
        c5 = new FroggerRectangle[5];
        t = 0;
        for(int i=0; i<c5.length; i++)
        {
            c5[i] = new FroggerRectangle(t,290,75,25,-1);
            t = t - 152;
        }
        c6 = new FroggerRectangle[5];
        e = width;
        for(int i=0; i<c6.length; i++)
        {
            c6[i] = new FroggerRectangle(e,340,75,20,-1);
            e = e + 129;
        }
        c7 = new FroggerRectangle[5];
        t = 0;
        for(int i=0; i<c7.length; i++)
        {
            c7[i] = new FroggerRectangle(t,390,75,20,-1);
            t = t - 134;
        }
        c8 = new FroggerRectangle[5];
        e = width;
        for(int i=0; i<c8.length; i++)
        {
            c8[i] = new FroggerRectangle(e,430,75,15,-1);
            e = e + 136;
        }
        lifes = 3;
        frog = new FroggerBall(width/2-14,450);
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
            if(upKey){frog.moveUp();}
            if(downKey){frog.moveDown();}
            if(rightKey){frog.moveRight();}
            if(leftKey){frog.moveLeft();}
            repaint();
            try {runner.sleep(25);}
            catch (Exception e) { }
            gBuffer.setColor(Color.black);
            gBuffer.fillRect(0,0,width,height);
            frog.update();
            for(int i=0; i<c1.length; i++)
            {
                c1[i].moveRight();
                if(c1[i].getX() > 600)
                {
                    c1[i].setX(-100);
                }
                if(c1[i].ballCollision(frog))
                {
                    lifes = lifes - 1;
                    frog.respawn(width/2-14, 450);
                }
            }
            for(int i=0; i<c2.length; i++)
            {
                c2[i].moveLeft();
                if(c2[i].getX() < -100)
                {
                    c2[i].setX(700);
                }
                if(c2[i].ballCollision(frog))
                {
                    lifes = lifes - 1;
                    frog.respawn(width/2-14, 450);
                }
            }
            for(int i=0; i<c3.length; i++)
            {
                c3[i].moveRight();
                if(c3[i].getX() > 600)
                {
                    c3[i].setX(-100);
                }
                if(c3[i].ballCollision(frog))
                {
                    lifes = lifes - 1;
                    frog.respawn(width/2-14, 450);
                }
            }
            for(int i=0; i<c4.length; i++)
            {
                c4[i].moveLeft();
                if(c4[i].getX() < -100)
                {
                    c4[i].setX(700);
                }
                if(c4[i].ballCollision(frog))
                {
                    lifes = lifes - 1;
                    frog.respawn(width/2-14, 450);
                }
            }
            for(int i=0; i<c5.length; i++)
            {
                c5[i].moveRight();
                if(c5[i].getX() > 600)
                {
                    c5[i].setX(-100);
                }
                if(c5[i].ballCollision(frog))
                {
                    lifes = lifes - 1;
                    frog.respawn(width/2-14, 450);
                }
            }
            for(int i=0; i<c6.length; i++)
            {
                c6[i] .moveLeft();
                if(c6[i].getX() < -100)
                {
                    c6[i].setX(700);
                }
                if(c6[i].ballCollision(frog))
                {
                    lifes = lifes - 1;
                    frog.respawn(width/2-14, 450);
                }
            }
            for(int i=0; i<c7.length; i++)
            {
                c7[i].moveRight();
                if(c7[i].getX() > 600)
                {
                    c7[i].setX(-100);
                }
                if(c7[i].ballCollision(frog))
                {
                    lifes = lifes - 1;
                    frog.respawn(width/2-14, 450);
                }
            }
            for(int i=0; i<c8.length; i++)
            {
                c8[i].moveLeft();
                if(c8[i].getX() < -100)
                {
                    c8[i].setX(700);
                }
                if(c8[i].ballCollision(frog))
                {
                    lifes = lifes - 1;
                    frog.respawn(width/2-10, 450);
                }
            }
            if(frog.getY() < 0)
            {
                points = points + 80;
                frog.respawn(width/2-10,450);
            }
            String s1 = String.valueOf(lifes);
            String s2 = String.valueOf(points);
            gBuffer.setFont(new Font("Calibri",20,30));
            gBuffer.setColor(Color.blue);
            gBuffer.drawString("Lifes: "+lifes,0,490);
            gBuffer.drawString("Points: "+points,250,490);
            while(lifes <= 0)
            {
                try{
                        checkHS = FroggerHS.checkHS(count, checkHS);
                    }catch(IOException io){}
                if(checkHS)
                {
                    gBuffer.setFont(new Font("Calibri",20,50));
                    gBuffer.drawString("You Win!",150,130);
                    gBuffer.drawString("You got "+points +" points", 50,190);
                    gBuffer.drawString("Space to continue",50,250);
                    repaint();
                }else{
                    gBuffer.setFont(new Font("Calibri",20,50));
                    gBuffer.drawString("You lose!",150,130);
                    gBuffer.drawString("You got "+points +" points", 50,190);
                    gBuffer.drawString("Space to continue",50,250);
                    repaint();
                }
                if(spaceKey){endGame();}
            }
            repaint();
            r1.paint(gBuffer,1);
            r2.paint(gBuffer,1);
            r3.paint(gBuffer,1);
            r4.paint(gBuffer,1);
            for(int i=0; i<R1.length; i++)
            {
                R1[i].paint(gBuffer,1);
            }
            for(int i=0; i<R2.length; i++)
            {
                R2[i].paint(gBuffer,1);
            }
            frog.paint(gBuffer);
            for(int i=0; i<c1.length; i++)
            {
                c1[i].paint(gBuffer,1);
            }
            for(int i=0; i<c2.length; i++)
            {
                c2[i].paint(gBuffer,1);
                c3[i].paint(gBuffer,1);
                c4[i].paint(gBuffer,1);
                c5[i].paint(gBuffer,1);
                c6[i].paint(gBuffer,1);
                c7[i].paint(gBuffer,1);
                c8[i].paint(gBuffer,1);
            }
            repaint();
        }
    }   
    public void endGame()
    {
        while(z==0)
        {
            stop();
            FroggerGUI f = new FroggerGUI();
            JFrame p = f.getFrame();
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
        g.drawImage (Buffer,0,0, this);
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
            case KeyEvent.VK_UP:
            upKey = true;
            break;
            case KeyEvent.VK_DOWN:
            downKey = true;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = true;
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
            case KeyEvent.VK_UP:
            upKey = false;
            break;
            case KeyEvent.VK_DOWN:
            downKey = false;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = false;
            break;
        }
    }  
    public void keyTyped(KeyEvent e) 
    {
        c = e.getKeyChar();
        repaint();
    }
}