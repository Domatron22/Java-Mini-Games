import java.awt.*;
import java.applet.*;
import java.util.*;
public class BrickRectangle
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
    Random gen = new Random();    
    public BrickRectangle(int cl)
    {
        width = 25;
        height = 25;
        x = gen.nextInt(450);
        y = gen.nextInt(450);
        moveX = gen.nextInt(6) + 1;
        moveY = gen.nextInt(6) + 1;
        right = x + width;
        bottom = y + height;
        if(cl == -1)
        {
            c = gen.nextInt(5);
        }else{
            c = cl;
        }
    }
    public BrickRectangle(int rX,int rY, int w,int h, int mY,int mX)
    {
        width = w;
        height = h;
        x = rX;
        y = rY;
        moveX = mX;
        moveY = mY;
        right = x + width;
        bottom = y + height;
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
    public boolean BrickBallCollision(BrickBall B)
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
        if(c == 4 )
        {
            g.setColor(Color.green);
        }else{
            if(c  == 3)
            {
                g.setColor(Color.red);
            }else{
                if(c  == 2)
                {
                    g.setColor(Color.cyan);
                }else{
                    if(c  == 1)
                    {
                        g.setColor(Color.yellow);
                    }else{
                        g.setColor(Color.gray);
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