import java.awt.*;
import java.applet.*; 
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class SlotGame extends JPanel implements Runnable,KeyListener
{
    Random gen = new Random();
    String temp, temp2, temp3;
    private char c = 'e';
    int x;
    int y;
    int z;
    int moveX;
    int width; 
    int height;
    int count;
    boolean escKey;
    boolean start;
    boolean spaceKey;
    Thread runner;
    Image Buffer;
    int q;
    Graphics gBuffer;
    int points;
    boolean checkHS;
    public void init(int H, int W)
    {
          width=W;//this.getSize().width;  
          height=H;//this.getSize().height;  
          x = 100;
          y = 100;
          z = 100;
          count = 0;
          moveX = 3;
          Buffer=createImage(width,height);
          gBuffer=Buffer.getGraphics();
          addKeyListener(this);
          start = false;
          q=0;
          points = 0;
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
       Thread thisThread = Thread.currentThread();
       while (runner == thisThread) 
       {
           if(spaceKey){start=true;}
           repaint();
           try {
               thisThread.sleep(100);
           } catch (InterruptedException e){}
           gBuffer.setColor(Color.black);
           gBuffer.fillRect(0,0,width,height);
           gBuffer.setColor(Color.white);
           gBuffer.fillRect(75,75,100,100);
           gBuffer.fillRect(200,75,100,100);
           gBuffer.fillRect(325,75,100,100);
           if(start)
           {
               if(count!=20)
               {
                   x = gen.nextInt(3)+1;
                   y = gen.nextInt(3)+1;
                   z = gen.nextInt(3)+1;
                   count++;
               }
               temp = String.valueOf(x);
               temp2 = String.valueOf(y);
               temp3 = String.valueOf(z);
               gBuffer.setFont(new Font("Vladimir script",30,60));
               gBuffer.setColor(Color.blue);
               gBuffer.drawString(temp,105,140);
               gBuffer.setColor(Color.red);
               gBuffer.drawString(temp2,230,140); 
               gBuffer.setColor(Color.green);
               gBuffer.drawString(temp3,355,140);
               if(count==20)
               {
                   start = false;
               }
            }
           if(count==20)
           {
               if((x!=y)||(x!=z))
               {
                   gBuffer.setColor(Color.red);
                   
                   gBuffer.setFont(new Font("Vladimir script",30,60));
                   gBuffer.drawString("You Lose",125,250);
                   temp = String.valueOf(x);
                   temp2 = String.valueOf(y);
                   temp3 = String.valueOf(z);
                   gBuffer.setFont(new Font("Vladimir script",30,60));
                   gBuffer.setColor(Color.blue);
                   gBuffer.drawString(temp,105,140);
                   gBuffer.setColor(Color.red);
                   gBuffer.drawString(temp2,230,140); 
                   gBuffer.setColor(Color.green);
                   gBuffer.drawString(temp3,355,140);
                   gBuffer.drawString("Hit space to play",80,310);
                   gBuffer.drawString("Hit esc to exit",80,370);
                   if(spaceKey){start=true;count=0;points = points - 5;}
                   if(escKey)
                   {
                       try{
                           checkHS = SlotHS.checkHS(points, checkHS);
                        }catch(IOException io){}
                       endGame();
                   }
                   repaint();
               }else{
                   
                   gBuffer.setColor(Color.blue);
                   gBuffer.setFont(new Font("Vladimir script",30,60));
                   gBuffer.drawString("You Win",125,250);
                   temp = String.valueOf(x);
                   temp2 = String.valueOf(y);
                   temp3 = String.valueOf(z);
                   gBuffer.setFont(new Font("Vladimir script",30,60));
                   gBuffer.setColor(Color.blue);
                   gBuffer.drawString(temp,105,140);
                   gBuffer.setColor(Color.red);
                   gBuffer.drawString(temp2,230,140); 
                   gBuffer.setColor(Color.green);
                   gBuffer.drawString(temp3,355,140);
                   gBuffer.drawString("Hit space to play",80,310);
                   gBuffer.drawString("Hit esc to exit",80,370);
                   if(spaceKey){start=true;count=0;points = points + 10;}
                   if(escKey)
                   {
                       try{
                           checkHS = SlotHS.checkHS(points, checkHS);
                        }catch(IOException io){}
                       endGame();
                   }
                   repaint();
               }
           }else{
               gBuffer.setFont(new Font("Vladimir script",30,50));
               gBuffer.drawString("Hit space to play",80,230);
               gBuffer.drawString("Hit esc to exit",80,290);
               if(spaceKey){start=true;}
               if(escKey)
               {
                   try{
                       checkHS = SlotHS.checkHS(points, checkHS);
                    }catch(IOException io){}
                   endGame();
                }
               repaint();
           }
           gBuffer.setFont(new Font("Vladimir script",30,50));
           gBuffer.setColor(Color.white);
           gBuffer.drawString("Score: "+String.valueOf(points),0,440);
           repaint();
       }
    }
    public void endGame()
    {
        while(q==0)
        {
            stop();
            SlotGUI r = new SlotGUI();
            JFrame p = r.getFrame();
            p.setVisible(false);
            p.dispose();
            JavaGames t = new JavaGames();
            t.setVisible(true);
            q++;
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
            case KeyEvent.VK_ESCAPE:
            escKey = true;
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
            case KeyEvent.VK_ESCAPE:
            escKey = false;
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