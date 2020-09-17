/**
 * Write a description of class HockyRectangle here.
 * 
 * @author Nick Headen
 * @version May 12, 2015
 */
import java.awt.*;
import java.applet.*;
import java.util.*;
public class HockyRectangle
{
    // instance variables - replace the example below with your own
    private int width;
    private int height;
    private int x;
    private int y;
    private int moveX;
    private int moveY;
    private int right;
    private int bottom;
    private int color;
    Graphics g;
    Random gen = new Random();
    
    /**
     * Default Constructor for objects of class Ball
     */
    public HockyRectangle()
    {
        width = 25;
        height = 25;
        x = gen.nextInt(450);
        y = gen.nextInt(450);
        moveX = gen.nextInt(8) + 1;
        moveY = gen.nextInt(8) + 1;
        right = x + width;
        bottom = y + height;
        color = 0;
        }
    //alternate constructor
    public HockyRectangle(int rX,int rY, int w,int h, int mY,int mX, int c)
    {
        width = w;
        height = h;
        x = rX;
        y = rY;
        moveX = mX;
        moveY = mY;
        right = x + width;
        bottom = y + height;
        color = c;
    }
    
    public int getWidth()
    {
       return width;
    }
    
    public int getHeight()
    {
       return height;
    }
    
    public int getX()
    {
       return x;
    }
    
    public int getY()
    {
       return y;
    }
    
    public int getRight()
    {
       return right;
    }
    
    public int getBottom()
    {
       return bottom;
    }
    
    public void setY(int Y)
    {
        y = Y;
    }
    
    public void setX(int X)
    {
        x = X;
    }
    
    public void moveUp()
    {
        y = y - 7;
        update();
    }
    
    public void moveDown()
    {
        y = y + 7;
        update();
    }
    
    public void moveRight()
    {
        x = x + 7;
        update();
    }
    
    public void moveLeft()
    {
        x = x - 7;
        update();
    }
    
    public void update()
    {
        right = x + height;
        bottom = y + height;
    }//end update
    
    public boolean BallCollision(HockyBall B)
    {
        boolean t = false;
        double dis;
        int bRadius = B.getRadius();
        int bCentX = B.getCenterX();
        int bCentY = B.getCenterY();
        
        int xsq,ysq;
        
        //check collision with the left (x, [y to y + height])
        xsq = (bCentX - x)*(bCentX - x);
        for(int i = y-1; i <= y+height+1;i++)
        {
            ysq = (bCentY - i)*(bCentY - i);
            dis = Math.sqrt(xsq + ysq);//distance formula
            if(dis <= bRadius)
            {
                B.changeXDirection();
                t = true;
                break;
            }
        }
        
        //Check Right side for collision (x+width, [y to y + height])
        xsq = (bCentX - (x + width))*(bCentX - (x + width));
        for(int i = y-1; i <= y+height+1;i++)
        {
            ysq = (bCentY - i)*(bCentY - i);
            dis = Math.sqrt(xsq + ysq);//distance formula
            if(dis <= bRadius)
            {
                B.changeXDirection();
                t = true;
                break;
            }
        }
        
        //check the top ([x to x + width], y)
        ysq = (bCentY - y)*(bCentY - y);
        for(int i = x-1; i <= x + width+1;i++)
        {
            xsq = (bCentX - i)*(bCentX - i);
            dis = Math.sqrt(xsq + ysq);//distance formula
            if(dis <= bRadius)
            {
                B.changeYDirection();
                t = true;
                break;
            }
        }
        
        //check bottom
        ysq = (bCentY - (y+height))*(bCentY - (y+height));
        for(int i = x-1; i <= x + width+1;i++)
        {
            xsq = (bCentX - i)*(bCentX - i);
            dis = Math.sqrt(xsq + ysq);//distance formula
            if(dis <= bRadius)
            {
                B.changeYDirection();
                t = true;
                break;
            }
        }
        return t;
    }
    
    public void drawRect()
    {
        if(color == 0)
        {
           g.setColor(Color.green);
        }
        if(color == 1)
        {
            g.setColor(Color.magenta);
        }
        if(color == 2)
        {
            g.setColor(Color.orange);
        }
        if(color == 3)
        {
            g.setColor(Color.black);
        }
        g.fillRect(x,y,width,height);
    }
    
    public void paint(Graphics gr)
    {
      g = gr;
      drawRect();
    }
}