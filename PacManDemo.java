import javax.swing.*;
import java.applet.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.event.*;
import java.applet.Applet;
public class PacManDemo extends JPanel implements Runnable,KeyListener
{    
    Thread runner; 
    private char c = 'e';
    private Image Buffer;
    private Graphics gBuffer;
    int width,height;
    /*PacManBall B1;
    PacManRectangle J1,J2,J3,A1,A2,A3,A4,V1,V2,V3,A_1,A_2,A_3,A_4,O1,O2,O3,O4,O5,O6,O7,O8;
    ArrayList aList;
    PacManBall temp;*/
    boolean leftKey;
    boolean rightKey;
    boolean downKey;
    boolean spaceKey;
    //int points;
    //int lifes;
    int tempX,tempY;
    Random gen = new Random();
    int z;
    Image pacMan,ghost1,ghost2,ghost3;
    public void init(int W,int H)
    {  
       /* width=W;
        height=H;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        J1 = new PacManRectangle(1,200,50,50,350);
        J2 = new PacManRectangle(1,50,350,200,50);
        J3 = new PacManRectangle(1,50,300,50,100);
        A1 = new PacManRectangle(1,275,50,50,350);
        A2 = new PacManRectangle(1,275,50,100,50);
        A3 = new PacManRectangle(1,275,175,100,50);
        A4 = new PacManRectangle(1,375,50,50,350);
        V1 = new PacManRectangle(1,475,50,50,350);
        V2 = new PacManRectangle(1,475,350,100,50);
        V3 = new PacManRectangle(1,550,50,50,350);
        A_1 = new PacManRectangle(1,625,50,50,350);
        A_2 = new PacManRectangle(1,625,50,100,50);
        A_3 = new PacManRectangle(1,625,175,100,50);
        A_4 = new PacManRectangle(1,725,50,50,350);
        O1 = new PacManRectangle(1,0,0,width,15);
        O2 = new PacManRectangle(1,0,height-15,width,15);
        O3 = new PacManRectangle(1,0,0,15,75);
        O4 = new PacManRectangle(1,0,100,15,275);
        O5 = new PacManRectangle(1,0,400,15,height);
        O6 = new PacManRectangle(1,width-15,0,15,75);
        O7 = new PacManRectangle(1,width-15,100,15,275);
        O8 = new PacManRectangle(1,width-15,400,15,height);
        aList = new ArrayList();*/
        tempX = 17;
        tempY = 400;
        for(int i=0; i<40; i++)
        {
            //temp = new PacManBall(1,tempX,tempY);
            //aList.add(temp);
            tempX = tempX + 17;
            if(tempX>=width-15)
            {
                tempX = 17;
                tempY = tempY + 21;
            }
        }
        addKeyListener(this);
       //points = 0;
       //lifes = 3;
        
       //pacMan = getImage(getCodeBase(),"pacpix/PacMan1.gif");
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
            /*if(leftKey){P1.moveLeftPaddle();}
            if(rightKey){P2.moveRightPaddle();}
            if(downKey){B1.launchPacManBall(width,height);}
            repaint();
            try {runner.sleep(25);}
            catch (Exception e) { }   
            gBuffer.setColor(Color.black);
            gBuffer.fillRect(0,0,width,height);
            gBuffer.setColor(Color.blue);
            J1.paint(gBuffer);
            J2.paint(gBuffer);
            J3.paint(gBuffer);
            A1.paint(gBuffer);
            A2.paint(gBuffer);
            A3.paint(gBuffer);
            A4.paint(gBuffer);
            V1.paint(gBuffer);
            V2.paint(gBuffer);
            V3.paint(gBuffer);
            A_1.paint(gBuffer);
            A_2.paint(gBuffer);
            A_3.paint(gBuffer);
            A_4.paint(gBuffer);
            O1.paint(gBuffer);
            O2.paint(gBuffer);
            O3.paint(gBuffer);
            O4.paint(gBuffer);
            O5.paint(gBuffer);
            O6.paint(gBuffer);
            O7.paint(gBuffer);
            O8.paint(gBuffer);
            for(int i=0; i<aList.size(); i++)
            {
                temp = (PacManBall)aList.get(i);
                temp.paint(gBuffer);
            }
            repaint();
            String pointValue = String.valueOf(points);
            String Lifes = String.valueOf(lifes);
            gBuffer.setFont(new Font("Calibri",20,50));
            gBuffer.drawString(pointValue,20,40);
            gBuffer.drawString(Lifes,20,100);
            repaint();
            if(killed)
            {
                lifes = lifes - 1;
                B1.respawn(width);
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
                //make highscore statements
                PinPacManBallHS temp = new PinPacManBallHS();
                try{
                    boolean t = temp.checkHS(points);
                    if(t)
                    {
                        gBuffer.drawString(s3,50,220);
                    }
                }catch( IOException io ) {}
                if(spaceKey){System.exit(1);}
                repaint();
            }*/
            gBuffer.setFont(new Font("Calibri",20,50));
            gBuffer.setColor(Color.blue);
            gBuffer.drawString("Coming Soon!",225,100);
            gBuffer.drawString("Hit space to go back to the menu",50,160);
            if(spaceKey){endGame();}
            //gBuffer.drawImage(pacMan,100,400);
            //repaint();
        }//while(true)
    } //run    
    public void endGame()
    {
        while(z==0)
        {
            stop();
            PacManGUI r = new PacManGUI();
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
            case KeyEvent.VK_SPACE:
            spaceKey = true;
            break;
        }
    }
    public void keyReleased(KeyEvent e) 
    {
        switch(e.getKeyCode())
        {
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