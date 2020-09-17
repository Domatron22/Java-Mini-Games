import java.awt.*;
import java.applet.*;
import java.util.*;
public class SnakeRectangle
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
    boolean Moveable;
    Graphics g;
    int increase;
    Random gen = new Random();    
    public SnakeRectangle(int cl)
    {
        width = 25;
        height = 25;
        x = gen.nextInt(450);
        y = gen.nextInt(450);
        moveX = 2;
        moveY = 2;
        right = x + width;
        bottom = y + height;
        if(cl == -1)
        {
            c = gen.nextInt(5);
        }else{
            c = cl;
        }
        Moveable = false;
    }
    public SnakeRectangle(int rX,int rY, int w,int h, int mY,int mX)
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
        Moveable = false;
    }
    public void setWidth(int w)
    {
        width = width + w;
    }
    public void setLength(int l)
    {
        height = height + l;
    }
    public void setIncrease(int i)
    {
        increase = i;
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
    public void moveRight()
    {
        x = x + moveX;
    }
    public void moveLeft()
    {
        x = x - moveX;
    }
    public void moveUP()
    {
        y = y - moveY;
    }
    public void moveDown()
    {
        y = y + moveY;
    }
    public void setX(int X)
    {
        x = X;
    }
    public void setY(int Y)
    {
        y = Y;
    }
    public void setMove(boolean t)
    {
        Moveable = t;
    }
    public boolean getMove()
    {
        return Moveable;
    }
    public void moveExtension(int X,int Y)
    {
        moveX = 2;
        moveY = 2;
        x = (x+moveX)-25;
        y = (y+moveY)-25;
    }
    public boolean collision(SnakeRectangle s)
    {
        boolean t = false;
        int sx = s.getX();
        int sy = s.getY();
        //top
        if(sx>=x && sx<=x+25 && sy==y)
        {
            t = true;
        }
        if(sy>=y && sy<=y+25 && sx==x)
        {
            t = true;
        }
        if(sy>=y && sy<=y+25 && sx==x+25)
        {
            t = true;
        }
        if(sx>=x && sx<=x+25 && sy==y+25)
        {
            t = true;
        }
        
        if(sx+25>=x && sx+25<=x+25 && sy+25==y)
        {
            t = true;
        }
        if(sy+25>=y && sy+25<=y+25 && sx+25==x)
        {
            t = true;
        }
        if(sy+25>=y && sy+25<=y+25 && sx+25==x+25)
        {
            t = true;
        }
        if(sx+25>=x && sx+25<=x+25 && sy+25==y+25)
        {
            t = true;
        }
        return t;
    }
    /*public boolean SnakeCollision(BrickBall B)
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
    }*/
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