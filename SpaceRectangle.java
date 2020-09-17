import java.awt.*;
import java.applet.*;
import java.util.*;
public class SpaceRectangle
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
    public SpaceRectangle(int cl)
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
    public SpaceRectangle(int rX,int rY, int w,int h, int mY,int mX)
    {
        width = w;
        height = h;
        x = rX;
        y = rY;
        moveX = mX;
        moveY = 2;
        right = x + width;
        bottom = y + height;
        c = gen.nextInt(25);
    }
    public int getWidth()
    {
       return width;
    }
    public void setX(int X)
    {
        x = X;
    }
    public void setY(int Y)
    {
        y = Y;
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
    public void moveInvader(int mx)
    {
        x = x + mx;   
    }
    public void Attack()
    {
        y = y - moveY;
    }
    public boolean moveDown()
    {
        boolean t = true;
        y = y + moveY;
        return t;
    }
    public void setColor(int cl)
    {
        c = cl;
    }
    public boolean shotCollision(Shot S)
    {
        boolean t = false;
        double dis;
        int sRadius = S.getRadius();
        int sCentX = S.getCenterX();
        int sCentY = S.getCenterY();
        S.update();
        //use distance formula
        int xsq,ysq;
        //check collision with the left (x, [y to y + height])
        xsq = (sCentX - x)*(sCentX - x);
        for(int i = y; i <= y+height;i++)
        {
            ysq = (sCentY - i)*(sCentY - i);
            dis = Math.sqrt(xsq + ysq);//distance formula
            if(dis <= sRadius)
            {
                t = true;
                break;
            }
        }
        //Check Right side for collision (x+width, [y to y + height])
        xsq = (sCentX - (x + width))*(sCentX - (x + width));
        for(int i = y; i <= y+height;i++)
        {
            ysq = (sCentY - i)*(sCentY - i);
            dis = Math.sqrt(xsq + ysq);//distance formula
            if(dis <= sRadius)
            {
                t = true;
                break;
            }
        }
        //check the top ([x to x + width], y)
        ysq = (sCentY - y)*(sCentY - y);
        for(int i = x; i <= x + width;i++)
        {
            xsq = (sCentX - i)*(sCentX - i);
            dis = Math.sqrt(xsq + ysq);//distance formula
            if(dis <= sRadius)
            {
                t = true;
                break;
            }
        }
        //check bottom
        ysq = (sCentY - (y+height))*(sCentY - (y+height));
        for(int i = x; i <= x + width;i++)
        {
            xsq = (sCentX - i)*(sCentX - i);
            dis = Math.sqrt(xsq + ysq);//distance formula
            if(dis <= sRadius)
            {
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
