import java.awt.*;
import java.applet.*;
import java.util.*;
public class TrollRectangle
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
    public TrollRectangle(int cl,int X, int Y,int W, int H)
    {
        width = W;
        height = H;
        x = X;
        y = Y;
        moveX = 4;
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
    public TrollRectangle(int rX,int rY, int w,int h, int mY,int mX)
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
    public void moveLeft()
    {
        x = x - moveX;
    }
    public void setColor(int cl)
    {
        c = cl;
    }
    public void setX(int X)
    {
        x = X;
    }
    public void update()
    {
        bottom = y + height;
        right = x + width;
    }
    public void still()
    {
        moveX = 0;
    }
    public boolean Collision(TrollChar t)
    {
        boolean f = false;
        if(((t.getRx()+16 >= x)||(t.getRx() >= x)) && (t.getRy()+80 <= 480) && ((t.getRx()+16 <= x+width)||(t.getRx() <= x+width)) && (t.getRy()+80 >= 480-height))
        {
            f = true;
        }
        return f;
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