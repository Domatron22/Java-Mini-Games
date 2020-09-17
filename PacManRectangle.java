import java.awt.*;
import java.applet.*;
import java.util.*;
public class PacManRectangle
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
    public PacManRectangle(int cl, int X, int Y,int W,int H)
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
            c = gen.nextInt(5);
        }else{
            c = cl;
        }
    }
    public PacManRectangle(int w,int h, int rY,int rX, int mY,int mX)
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
    public void update()
    {
        bottom = y + height;
        right = x + width;
        left = x - width;
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
                    if(c == 1)
                    {
                        g.setColor(Color.blue);
                    }
                }
            }
        }
        g.fillRect(x,y,width,height);
    }
    public int getColor()
    {
        return c;
    }
    public void paint(Graphics gr)
    {
      g = gr;
      drawRect();
    }    
}