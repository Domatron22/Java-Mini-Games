import java.awt.*;
import java.applet.*;
import java.util.*;
public class PongRectangle
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
    private int xEdge, yEdge,color,xStep,yStep;
    Graphics g;
    Random gen = new Random();    
    public PongRectangle(int cl,int X, int Y)
    {
        width = 15;
        height = 75;
        x = X;
        y = Y;
        moveX = gen.nextInt(6) + 1;
        moveY = 5;
        right = x + width;
        bottom = y + height;
        if(cl == -1)
        {
            c = gen.nextInt(5);
        }else{
            c = cl;
        }
        xEdge = x + height;
        yEdge = y + width;
        xStep = 5;
        yStep = 5;
    }
    public PongRectangle(int rX,int rY, int w,int h, int mY,int mX)
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
    public void moveRectangle(int H,int W)
    {
        y = y + moveY;
        if(y + height+40 >= H || y+40 <= 0)
        {
            moveY = moveY*-1;
        }
        update();
    }
    public void update()
    {
        bottom = y + height;
        right = x + width;
    }
    public boolean ballCollision(PongBall B)
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