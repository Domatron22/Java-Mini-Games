import java.awt.*;
import java.applet.*;
import java.util.*;
public class PinBallRectangle
{
    private int width;
    private int height;
    private int x;
    private int y;
    private int right;
    private int bottom;
    private int c;
    private int left;
    Graphics g;
    Random gen = new Random();    
    public PinBallRectangle(int cl, int X, int Y,int W,int H)
    {
        width = W;
        height = H;
        x = X; 
        y = Y; 
        right = x + width;
        bottom = y + height;
        left = x - width;
        if(cl == -1)
        {
            c = gen.nextInt(4+2);
        }else{
            if(cl == -2)
            {
                c = -2;
            }
        }
    }
    public PinBallRectangle(int w,int h, int rY,int rX, int mY,int mX)
    {
        width = w;
        height = h;
        x = rX;
        y = rY;
        right = x + width;
        bottom = y + height;
        left = x - width;
        c = gen.nextInt(25);
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
    public void setColor(int cl)
    {
        c = cl;
    }
    public boolean ballCollision(PinBallBall B)
    {
        boolean t = false;
        int bRadius = B.getRadius();
        int bCentX = B.getCenterX();
        int bCentY = B.getCenterY();
        int xsq,ysq;
        double dis;
        //check left
        xsq = (bCentX - x)*(bCentX - x);
        for(int i=y; i<=y+height; i++)
        {
            ysq = (bCentY - i)*(bCentY - i);
            dis = Math.sqrt(xsq + ysq);
            if(dis <= bRadius)
            {
                B.changeXDirection();
                update();
                t = true;
                break;
            }
        }
        //check right
        xsq = (bCentX - (x+width))*(bCentX - (x+width));
        for(int i=y; i<=y+height; i++)
        {
            ysq = (bCentY - i)*(bCentY - i);
            dis = Math.sqrt(xsq + ysq);
            if(dis <= bRadius)
            {
                B.changeXDirection();
                update();
                t = true;
                break;
            }
        }
        //check top
        ysq = (bCentY - y)*(bCentY - y);
        for(int i=x; i<=x+width; i++)
        {
            xsq = (bCentX - i)*(bCentX - i);
            dis = Math.sqrt(xsq + ysq);
            if(dis <= bRadius)
            {
                B.changeYDirection();
                update();
                t = true;
                break;
            }
        }
        //check bottem
        ysq = (bCentY - (y+height))*(bCentY - (y+height));
        for(int i=x; i<=x+width; i++)
        {
            xsq = (bCentX - i)*(bCentX - i);
            dis = Math.sqrt(xsq + ysq);
            if(dis <= bRadius)
            {
                B.changeYDirection();
                update();
                t = true;
                break;
            }
        }
        return t;
    }
    public void update()
    {
        bottom = y + height;
        right = x + width;
        left = x - width;
    }
    public int getColor()
    {
        return c;
    }
    public void drawRect()
    {       
       if(c == 5)
       {
           g.setColor(Color.green);
       }else{
           if(c  == 4)
           {
               g.setColor(Color.red);
            }else{
               if(c  == 3)
               {
                   g.setColor(Color.cyan);
                }else{
                    if(c == 2)
                    {
                        g.setColor(Color.white);
                    }else{
                        if(c == -2)
                        {
                            g.setColor(Color.blue);
                        }
                    }
                }
            }
        }
       g.fillRect(x,y,width,height);
    }
    public void paint(Graphics gr)
    {
        g = gr;
        drawRect();
    }    
}