import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class HockyGame extends JPanel implements Runnable,KeyListener
{    
    Thread runner; 
    private Image Buffer;
    private char c = 'e';
    private Graphics gBuffer;
    int width,height;
    HockyBall B,B1,B2,B3,B4,B5,B6,B7,B8;
    HockyRectangle R1,R2,R3,R4,R5,R6,R7,R8,R9,R10,R11,R12;
    int points1,points2;
    String pts;
    int count;
    boolean leftKey;
    boolean rightKey;
    boolean upKey;
    boolean downKey;
    boolean aKey;
    boolean sKey;
    boolean dKey;
    boolean wKey;
    boolean reset = false;
    boolean spaceKey;
    boolean enterKey;
    Random gen = new Random();
    int start;
    public void init(int w, int h)
    {  
        width=w;//this.getSize().width;
        height=h;//this.getSize().height;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        addKeyListener(this);
        points1 = 0;
        points2 = 0;
        count = 0;
        B = new HockyBall(20,490,340,5,5,0);
        B1 = new HockyBall(40,180,280,0,3,1);
        B2 = new HockyBall(40,380,420,0,3,1);
        B3 = new HockyBall(40,580,280,0,3,1);
        B4 = new HockyBall(40,780,420,0,3,1);
        
        //these are to fix the corner glitches
        B5 = new HockyBall(30,325,25,0,0,2);// top left
        B6 = new HockyBall(30,645,25,0,0,2);// top right
        B7 = new HockyBall(30,325,645,0,0,2);// bottom left
        B8 = new HockyBall(30,645,645,0,0,2);// botom right
        
        //x,y,w,h,mx,my,t
        R1 = new HockyRectangle(450,90,100,10,0,0,1); //upper paddle
        R2 = new HockyRectangle(450,590,100,10,0,0,1); //lower paddle
        
        R3 = new HockyRectangle(0,0,350,50,0,0,0); //top left corner
        R4 = new HockyRectangle(650,0,350,50,0,0,0); //top right corner
        R5 = new HockyRectangle(0,650,350,50,0,0,0); //bottom left corner
        R6 = new HockyRectangle(650,650,350,50,0,0,0); //bottom right corner
        
        R7 = new HockyRectangle(1,0,1,700,0,0,0); //left side barrier
        R8 = new HockyRectangle(999,0,1,700,0,0,0); //right side barrier
        
        R9 = new HockyRectangle(0,350-150,width,10,0,0,3);
        R10 = new HockyRectangle(0,350+20,width,10,0,0,3);
        R11 = new HockyRectangle(0,350-20,width,10,0,0,3);
        R12 = new HockyRectangle(0,350+150,width,10,0,0,3);
        
        start = 0;
        spaceKey = true;
    }
    public void keyPressed(KeyEvent e)
    {
         switch(e.getKeyCode()){
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
          case KeyEvent.VK_A:
          aKey = true;
          break;
          case KeyEvent.VK_S:
          sKey = true;
          break;
          case KeyEvent.VK_D:
          dKey = true;
          break;
          case KeyEvent.VK_W:
          wKey = true;
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
            
            case KeyEvent.VK_A:
            aKey = false;
            break;
            case KeyEvent.VK_S:
            sKey = false;
            break;
            case KeyEvent.VK_D:
            dKey = false;
            break;
            case KeyEvent.VK_W:
            wKey = false;
            break;
              
            case KeyEvent.VK_SPACE:
            spaceKey = false;
            break;
             
            case KeyEvent.VK_ENTER:
            enterKey = false;
            break;
        }
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
            
            if(enterKey){start = start + 1;}
            repaint();
            
            if(start == 0)
            {
                gBuffer.setColor(Color.black);//background
                gBuffer.fillRect(0,0,width,height);
                gBuffer.setColor(Color.blue);
                gBuffer.setFont(new Font("Calibri",40,60));
                gBuffer.drawString("Enter to start",270,320);
                repaint();
            }
            repaint();
            while(start!=0)
            {
                if(upKey)
                {
                    R1.moveUp();
                    if(R1.getX() >= 0 && R1.getX() <= 350 && R1.getY() >= 0 && R1.getY() <= 50)
                    {
                        R1.setY(R1.getY() + 7);
                    }
                    if(R1.getX() >= 650 && R1.getX() <= width && R1.getY() >= 0 && R1.getY() <= 50)
                    {
                        R1.setY(R1.getY() + 7);
                    }
                    if(R1.getY() <= 0)
                    {
                        R1.setY(R1.getY() + 7);
                    }
                }
                if(downKey)
                {
                    R1.moveDown();
                }
                if(rightKey)
                {
                    R1.moveRight();
                    if(R1.getX() >= width + 25)
                    {
                        R1.setX(-25);
                    }
                    if(R1.getX() + 100 >= 650 && R1.getY() >= 0 && R1.getY() <= 50)
                    {
                        R1.setX(R1.getX() - 7);
                    }
                }
                if(leftKey)
                {
                    R1.moveLeft();
                    if(R1.getX() <= 0-25)
                    {
                        R1.setX(width + 25);
                    }
                    if(R1.getX() <= 350 && R1.getY() >= 0 && R1.getY() <= 50)
                    {
                        R1.setX(R1.getX() + 7);
                    }
                }
                repaint();
                if(wKey)
                {
                    R2.moveUp();
                }
                if(sKey)
                {
                    R2.moveDown();
                    if(R2.getX() >= 0 && R2.getX() <= 350 && R2.getY() >= 640 && R2.getY() <= height)
                    {
                        R2.setY(R2.getY() - 7);
                    }
                    if(R2.getX() >= 650 && R2.getX() <= width && R2.getY() >= 640 && R2.getY() <= height)
                    {
                        R2.setY(R2.getY() - 7);
                    }
                    if(R2.getY() + 10 >= height)
                    {
                        R2.setY(R2.getY() - 7);
                    }
                }
                if(dKey)
                {
                    R2.moveRight();
                    if(R2.getX() >= width + 25)
                    {
                        R2.setX(-25);
                    }
                    if(R2.getX() + 100 >= 650 && R2.getY() >= 650 && R2.getY() <= height)
                    {
                        R2.setX(R2.getX() - 7);
                    }
                }
                if(aKey)
                {
                    R2.moveLeft();
                    if(R2.getX() <= - 25)
                    {
                        R2.setX(width + 25);
                    }
                    if(R2.getX() <= 350 && R2.getY() >= 650 && R2.getY() <= height)
                    {
                        R2.setX(R2.getX() + 7);
                    }
                }
                if(spaceKey)
                {
                    B = new HockyBall(20,490,340,10,10,0);
                    reset = false;
                    spaceKey = false;
                }
                repaint();
                
                try 
                { runner.sleep(15); }
                catch (Exception e) { }
                gBuffer.setColor(Color.black);//background
                gBuffer.fillRect(0,0,width,height);
                
                R9.paint(gBuffer);
                R10.paint(gBuffer);
                R11.paint(gBuffer);
                R12.paint(gBuffer);
                
                if(!reset)
                {
                    B.moveHockyBall(width,height);//makes the HockyBall move
                }
                B1.moveHockyBall(width,height);
                B2.moveHockyBall(width,height);
                B3.moveHockyBall(width,height);
                B4.moveHockyBall(width,height);
                
                R1.BallCollision(B);
                R2.BallCollision(B);
                R3.BallCollision(B);
                R4.BallCollision(B);
                R5.BallCollision(B);
                R6.BallCollision(B);
                R7.BallCollision(B);
                R8.BallCollision(B);
                
                B1.HockyBallCollision(B);
                B2.HockyBallCollision(B);
                B3.HockyBallCollision(B);
                B4.HockyBallCollision(B);
                B5.HockyBallCollision(B);
                B6.HockyBallCollision(B);
                B7.HockyBallCollision(B);
                B8.HockyBallCollision(B);
                
                R9.BallCollision(B1);
                R9.BallCollision(B3);
                R10.BallCollision(B1);
                R10.BallCollision(B3);
                R11.BallCollision(B2);
                R11.BallCollision(B4);
                R12.BallCollision(B2);
                R12.BallCollision(B4);
                
                B.paint(gBuffer);
            
                B1.paint(gBuffer);
                B2.paint(gBuffer);
                B3.paint(gBuffer);
                B4.paint(gBuffer);
                B5.paint(gBuffer);
                B6.paint(gBuffer);
                B7.paint(gBuffer);
                B8.paint(gBuffer);
                
                R1.paint(gBuffer);
                R2.paint(gBuffer);
                R3.paint(gBuffer);
                R4.paint(gBuffer);
                R5.paint(gBuffer);
                R6.paint(gBuffer);
                R7.paint(gBuffer);
                R8.paint(gBuffer);
                
                if(B.getY() <= 10)
                {
                    count++;
                    reset = true;
                    B = new HockyBall(20,490,340,10,10,0);
                    points2 = points2 + 1;
                    if(B.getX() == 490 && B.getY() == 340)
                    {
                        //NEVER COULD GET THIS TO WORK
                        String s1 = String.valueOf("Team 2 Scored!");
                        gBuffer.setColor(Color.red);
                        gBuffer.setFont(new Font("Calibri",40,100));
                        gBuffer.drawString(s1,300,300);
                    }
                }
                if(B.getY() == 670) //700 - getDiameter()
                {
                    count++;
                    reset = true;
                    B = new HockyBall(20,490,340,10,10,0);
                    points1 = points1 + 1;
                    if(count <= 300)
                    {
                        //NEVER COULD GET THIS TO WORK
                        String s1 = String.valueOf("Team 1 Scored!");
                        gBuffer.setColor(Color.red);
                        gBuffer.setFont(new Font("Calibri",40,100));
                        gBuffer.drawString(s1,300,300);
                    }
                }
                
                String s1 = String.valueOf("Team 1: " + points1);
                gBuffer.setColor(Color.red);
                gBuffer.setFont(new Font("Calibri",20,50));
                gBuffer.drawString(s1, 10, 40);
            
                String s2 = String.valueOf("Team 2: " + points2);
                gBuffer.setColor(Color.red);
                gBuffer.setFont(new Font("Calibri",20,50));
                gBuffer.drawString(s2, 10, 690);
                repaint();
            }
            repaint();
        }//while(true)
    }//run
    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
    public void keyTyped(KeyEvent e) 
    {
        c = e.getKeyChar();
        repaint();
    }
    public void update(Graphics g)
    {  
        paint(g);
    }
    
    public void paint(Graphics g)
    {
        g.drawImage (Buffer,0,0, this);
    }
}