import java.awt.*;
import java.applet.*;
import java.util.*;
public class Paddle
{
    private int width;
    private int height;
    private int x;
    private int y;
    private int moveX;
    private int right;
    private int bottom;
    private int xEdge, yEdge,color,xStep,yStep;
    Graphics g;
    public Paddle()
    {
        width = 75;
        height = 15;
        x = 375;
        y = 545;
        moveX = 1;
        right = x + width;
        bottom = y + height;
        xEdge = x + height;
        yEdge = y + width;
        xStep = 5;
        yStep = 5;
    }
    public Paddle(int rX,int rY, int w,int h, int mY,int mX)
    {
        width = w;
        height = h;
        x = rX;
        y = rY;
        moveX = mX;
        right = x + width;
        bottom = y + height;
    }
    public void moveLeft()
    {
        x = x - xStep;
        xEdge = x + height;
    }
    public void moveRight()
    {
        x = x + xStep;
        xEdge = x + height;
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
    public void movePaddle(int w)
    {
        x = x + moveX;
        if(x+width >= w || x <= 0)
        {
            moveX = moveX*-1;
        }
        update();
    }
    public void update()
    {
        right = x + width;
        bottom = y + height;
    }
    public boolean ballCollision(BrickBall B)
    {
        boolean t = false;
        double dis;
        int bRadius = B.getRadius();
        int bCentX = B.getCenterX();
        int bCentY = B.getCenterY();
        int xsq,ysq;
        //check left
        xsq = (bCentX - x)*(bCentX - x);
        for(int i = y; i <= y+height;i++)
        {
            ysq = (bCentY - i)*(bCentY - i);
            dis = Math.sqrt(xsq + ysq);
            if(dis <= bRadius)
            {
                B.changeXDirection();
                t = true;
                break;
            }
        }
        //check right
        xsq = (bCentX - (x + width))*(bCentX - (x + width));
        for(int i = y; i <= y+height;i++)
        {
            ysq = (bCentY - i)*(bCentY - i);
            dis = Math.sqrt(xsq + ysq);
            if(dis <= bRadius)
            {
                B.changeXDirection();
                t = true;
                break;
            }
        }
        //check top
        ysq = (bCentY - y)*(bCentY - y);
        for(int i = x; i <= x + width;i++)
        {
            xsq = (bCentX - i)*(bCentX - i);
            dis = Math.sqrt(xsq + ysq);
            if(dis <= bRadius)
            {
                B.changeYDirection();
                t = true;
                break;
            }
        }
        //check bottom
        ysq = (bCentY - (y+height))*(bCentY - (y+height));
        for(int i = x; i <= x + width;i++)
        {
            xsq = (bCentX - i)*(bCentX - i);
            dis = Math.sqrt(xsq + ysq);
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
        g.setColor(Color.red);
        g.fillRect(x,y,width,height);
    }
    public void paint(Graphics gr)
    {
        g = gr;
        drawRect();
    }    
}//end class 