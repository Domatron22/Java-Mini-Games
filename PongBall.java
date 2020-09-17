import java.awt.*;
import java.applet.*;
import java.util.*;
public class PongBall
{
    private int diameter;
    private int radius;
    private int x;
    private int y;
    private int moveX;
    private int moveY;
    private int centerX;
    private int centerY;
    private int c;
    Graphics g;
    Random gen = new Random();
    public PongBall(int cl)
    {
        diameter = 14;
        radius = diameter / 2;
        x = gen.nextInt(450);
        y = gen.nextInt(450)+100;
        moveX = gen.nextInt(100) + 1;
        moveY = gen.nextInt(100) + 1;
        centerX = x + radius;
        centerY = y + radius;
        if(cl == -1)
        {
            c = gen.nextInt(5);
        }else{
            c = cl;
        }
        }
    public PongBall(int di,int Cx, int Cy,int mX, int mY)
    {
        diameter = di;
        radius = diameter / 2;
        x = Cx;
        y = Cy;
        moveX = mX;
        moveY = mY;
        centerX = x + radius;
        centerY = y + radius;
         c = gen.nextInt(25);
    }
    public int getDiameter()
    {
       return diameter;
    }
    public int getRadius()
    {
       return radius;
    }
    public int getX()
    {
       return x;
    }
    public int getY()
    {
       return y;
    }
    public int getCenterX()
    {
       return centerX;
    }
    public int getCenterY()
    {
       return centerY;
    }
    public void movePongBall(int w, int h)
    {
        x = x + moveX;
        y = y + moveY;
        if(x+diameter >= w-15 || x+35 <= 0+25)
        {
            moveX = moveX*-1;
        }
        if(y+ diameter >= h-35 || y+35 <= 0+35)
        {
            moveY = moveY*-1;
        }
        update();
    }
    public void update()
    {
        centerX = x + radius;
        centerY = y + radius;
    }
    public void setColor(int cl)
    {
        c = cl;
    }
    public boolean PongBallCollision(PongBall B)
    {
        boolean t = false;
        int bRadius = B.getRadius();
        int bCentX = B.getCenterX();
        int bCentY = B.getCenterY();
        int xsq,ysq;
        double dis = Math.sqrt((bCentX-centerX)*(bCentX-centerX)+(bCentY-centerY)*(bCentY-centerY));
        if(dis <= radius + bRadius)
        {
            changeDirection();
            B.changeDirection();  
            t = true;
        }
        return t;
    }
    public void changeDirection()
    {
        moveX = moveX*-1;
        moveY = moveY*-1;
    }
    public void changeXDirection()
    {
        moveX = moveX*-1;
    }
    public void changeYDirection()
    {
       moveY = moveY*-1;
    }
     public void drawPongBall()
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
        g.fillOval(x,y,diameter,diameter);
    }
    public void paint(Graphics gr)
    {
        g = gr;
        drawPongBall();
    }    
}