import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.*;
public class TrollRunGame extends JPanel implements Runnable,KeyListener
{
    Thread runner; 
    private Image Buffer;
    private Graphics gBuffer;
    private char c = 'e';
    int width,height;
    boolean rightKey;
    boolean spaceKey;
    boolean enterKey;
    TrollChar troll;
    TrollRectangle r1;
    TrollBall sun;
    ArrayList cloud;
    TrollBall btemp;
    ArrayList avoid;
    TrollRectangle rtemp,rtemp2;
    int xtemp;
    int start,points,z;
    Random gen = new Random();
    int low,high;
    int lifes;
    boolean checkHS;
    public void init(int W,int H)
    {  
        width=W;
        height=H;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        addKeyListener(this);
        troll = new TrollChar();
        z = 0;
        start = 0;
        sun = new TrollBall(1,700,-30,100);
        r1 = new TrollRectangle(1,0,480,width,40);
        cloud = new ArrayList();
        xtemp = width + 50;
        for(int i=0; i<100; i++)
        {
            btemp = new TrollBall(7,xtemp,gen.nextInt(100-0),100);
            cloud.add(btemp);
            xtemp = xtemp + gen.nextInt(20)+20;
        }
        avoid = new ArrayList();
        xtemp = 500;
        low = 15;
        high = 30;
        for(int i=0; i<50; i++)
        {
            int h = gen.nextInt(high-low)+low;
            rtemp = new TrollRectangle(4,xtemp,480-h,gen.nextInt(high-low)+low,h);
            avoid.add(rtemp);
            xtemp = xtemp + gen.nextInt(230-100)+72;
        }
        lifes = 25;
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
            if(lifes/5>0)
            {
                if(spaceKey){troll.jumpUP();}
                if(rightKey){troll.runEffect();points=points+1;}
                if(spaceKey==false){troll.checkJump();}
                repaint();
                try {runner.sleep(25);}
                catch (Exception e) { } 
                gBuffer.setColor(Color.blue);
                gBuffer.fillRect(0,0,width,height);
                for(int i=0; i<cloud.size(); i++)
                {
                    btemp = (TrollBall)cloud.get(i);
                    btemp.moveLeft();
                    if(btemp.getX() < -100)
                    {
                        btemp.setX(width+100);
                    }
                }
                if(troll.getBX() >= 404)
                {
                    for(int i=0; i<avoid.size(); i++)
                    {
                        rtemp = (TrollRectangle)avoid.get(i);
                        if(rtemp.Collision(troll))
                        {
                            lifes = lifes - 1;
                        }
                        rtemp2 = (TrollRectangle)avoid.get(49);
                        rtemp.moveLeft();
                        if(btemp.getX() < -100)
                        {
                            rtemp.setX(300 + gen.nextInt(20)+20);
                        }
                    }
                }
                troll.moveChar(); 
                gBuffer.setColor(Color.green);
                r1.paint(gBuffer);
                gBuffer.setColor(Color.yellow);
                sun.paint(gBuffer);
                troll.paint(gBuffer);
                for(int i=0; i<avoid.size(); i++)
                {
                    rtemp = (TrollRectangle)avoid.get(i);
                    rtemp.paint(gBuffer);
                }
                for(int i=0; i<cloud.size(); i++)
                {
                    btemp = (TrollBall)cloud.get(i);
                    btemp.paint(gBuffer);
                }
                gBuffer.setColor(Color.blue);
                gBuffer.setFont(new Font("Calibri",20,30));
                gBuffer.drawString("Lifes: "+String.valueOf(lifes/5),0,500);
                gBuffer.drawString("Score: "+String.valueOf(points),350,500);
            }else{
                for(int i=0; i<avoid.size(); i++)
                {
                    rtemp = (TrollRectangle)avoid.get(i);
                    rtemp.still();
                }
                try{
                    checkHS = TrollHS.checkHS(points, checkHS);
                }catch(IOException io){}
                if(checkHS)
                {
                    gBuffer.setColor(Color.black);
                    gBuffer.setFont(new Font("Calibri",20,50));
                    gBuffer.drawString("You Win!",250,130);
                    gBuffer.drawString("You got "+points+" points",200,190);
                    gBuffer.drawString("Space to continue",200,250);
                    repaint();
                }else{
                    gBuffer.setColor(Color.black);
                    gBuffer.setFont(new Font("Calibri",20,50));
                    gBuffer.drawString("You lose!",250,130);
                    gBuffer.drawString("You got "+points+" points",200,190);
                    gBuffer.drawString("Space to continue",200,250);
                    repaint();
                }
                if(spaceKey){endGame();}
            }
            repaint();
        }//while(true)
    }//run    
    public void endGame()
    {
        while(z==0)
        {
            TrollRunGUI r = new TrollRunGUI();
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
            case KeyEvent.VK_RIGHT:
            rightKey = true;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = true;
            break;
            case KeyEvent.VK_ENTER:
            enterKey = true;
            break;
        }
    }
    public void keyReleased(KeyEvent e) 
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT:
            rightKey = false;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = false;
            break;
            case KeyEvent.VK_ENTER:
            enterKey = false;
            break;
        }
    }
    public void keyTyped(KeyEvent e) 
    {
        c = e.getKeyChar();
        repaint();
    }
}