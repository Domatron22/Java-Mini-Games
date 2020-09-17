import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;
public class FroggerRectangle implements EventListener 
{
    private int width;
    private int height;
    private int x;
    private int y;
    private int moveX;
    private int moveY;
    private int right;
    private int bottom;
    private int c;
    Graphics g;
    private int xEdge, yEdge,color,xStep,yStep;
    Random gen = new Random();
    public FroggerRectangle(int X, int Y,int W,int H, int cl)
    {
        width = W;
        height = H;
        x = X;
        y = Y;
        moveX = gen.nextInt(6) + 1;
        moveY = gen.nextInt(6) + 1;
        right = x + width;
        bottom = y + height;
        //c = cl;
        xEdge = x + height;
        yEdge = y + width;
        xStep = 3;
        yStep = 3;
        if(cl == -1)
        {
            c = gen.nextInt(3)+5;
        }else{
            c = cl;
        }
    }
    public FroggerRectangle(int w,int h, int rY,int rX, int mY,int mX)
    {
        width = w;
        height = h;
        x = rX;
        y = rY;
        moveX = mX;
        moveY = mY;
        right = x + width;
        bottom = y + height;
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
    public void setX(int X)
    {
        x = X;
    }
    public void setColor(int cl)
    {
        c = cl;
    }
    public void wall()
    {
        if(x<=0)
        {
            x = 0;
        }
        if(x+width>=500)
        {
            x = 500 - width;
        }
        if(y<=0)
        {
            y = 0;
        }
        if(y+height>=500)
        {
            y = 500 - height;
        }
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
    public void moveUp()
    {
        y = y - yStep;
        xEdge = y + width;
    }
    public void moveDown()
    {
        y = y + yStep;
        yEdge = y + width;
    }
    public boolean ballCollision(FroggerBall B)
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
        for(int i = x; i <= x+width;i++)
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
        ysq = (bCentY - (y + height))*(bCentY - (y + height));
        for(int i = x; i <= x+width;i++)
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
    public int getColor()
    {
        return c;
    }
    public void drawRect(int E)
    {
        if(c==1)
        {
            g.setColor(Color.green);
        }else{
            if(c==2)
            {
                g.setColor(Color.green);
            }else{
                if(c==3)
                {
                    g.setColor(Color.yellow);
                }else{
                    if(c == 6)
                    {
                        g.setColor(Color.red);
                    }else{
                        if(c==7)
                        {
                            g.setColor(Color.blue);
                        }else{
                            if(c==8)
                            {
                                g.setColor(Color.white);
                            }
                        }
                    }
                }
            }
        }
        if(E == -1)
        {
            g.drawRect(x,y,width,height);
        }else{
            g.fillRect(x,y,width,height);
        }
    }
    public void paint(Graphics gr,int E)
    {
        g = gr;
        drawRect(E);
    }    
}