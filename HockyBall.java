
/**
 * Write a description of class HockyBall here.
 * 
 * @author NIck Headen
 * @version May 12, 2015
 */
import java.awt.*;
import java.applet.*;
import java.util.*;
public class HockyBall
{
    // instance variables - replace the example below with your own
    private int diameter;
    private int radius;
    private int x;
    private int y;
    private int moveX;
    private int moveY;
    private int centerX;
    private int centerY;
    private int color;
    int q;
    int s;
    Graphics g;
    Random gen = new Random();
    
    
    public HockyBall()
    {
        diameter = 20;
        radius = diameter / 2;
        x = 340;
        y = 490;
        moveX =  3;
        moveY =  3;
        centerX = x + radius;
        centerY = y + radius;
        color = 0;
    }
    
    public HockyBall(int di,int Cx,int Cy,int mX,int mY,int c)
    {
        diameter = di;
        radius = diameter / 2;
        x = Cx;
        y = Cy;
        
        q = gen.nextInt(2);
        if(q == 0)
        {
            moveX = mX * -1;
        }
        if(q == 1)
        {
            moveX = mX;
        }
        
        s = gen.nextInt(2);
        if(s == 0)
        {
            moveY = mY * -1;
        }
        if(s == 1)
        {
            moveY = mY;
        }
        
        centerX = x + radius;
        centerY = y + radius;
        color = c;
    }
    
    public int getDiameter()
    {
        return diameter;
    }
    public int getRadius()
    {
        return radius;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getCenterX()
    {
        return centerX;
    }
    public int getCenterY()
    {
        return centerY;
    }
    
    public boolean moveHockyBall(int w, int h)
    {
        boolean t = false;
        x = x + moveX;
        y = y + moveY;
        if(x+diameter >= w || x <= 0)
        {
            moveX = moveX*-1;
        }
        if(y <= 0)//bounce off top
        {
            moveY = moveY*-1;
        }
        if(y + diameter >= h)//go through the bottom
        {
            t = true;
        }
        update();
        return t;
    }
    
    public void update()
    {
        centerX = x + radius;
        centerY = y + radius;
    }
    
    public boolean HockyBallCollision(HockyBall B)
    {
        boolean t = false;
        int bRadius = B.getRadius();
        int bCentX = B.getCenterX();
        int bCentY = B.getCenterY();
        
        //use distance formula
        int xsq,ysq;
        double dis = Math.sqrt((bCentX-centerX)*(bCentX-centerX)+(bCentY-centerY)*(bCentY-centerY));
        if(dis <= radius + bRadius)
        {
            //changeDirection();
            B.changeDirection();  
            t = true;
        }
        return t;
    }
    
    public void changeDirection()
    {
        Random gen = new Random();
        moveX = moveX * -1;
        moveY = moveY * -1;
    }
    
    public void changeXDirection()
    {
        moveX = moveX*-1;
    }
    
    public void changeYDirection()
    {
       moveY = moveY*-1;
    }
    
     public void drawHockyBall()//Use g as the graphics g.*******
    {
        Random gen = new Random();
       
        int x2 = gen.nextInt(256);
        int y2 = gen.nextInt(256);
        int z2 = gen.nextInt(256);
        
        Color rainbow = new Color(x2,y2,z2);
        
        if(color == 0)
        {
            g.setColor(rainbow);
        }
        if(color == 1)
        {
            g.setColor(Color.orange);
        }
        if(color == 2)
        {
            g.setColor(Color.green);
        }
        g.fillOval(x,y,diameter,diameter);
    }
    
    public void paint(Graphics gr)
    {
        g = gr;
        drawHockyBall();
    }
}