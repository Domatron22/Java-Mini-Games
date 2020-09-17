import java.awt.*;
import java.applet.*;
import java.util.*;
public class PinBallBall
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
    public PinBallBall(int cl,int X, int Y,int d)
    {
        diameter = d;
        radius = diameter / 2;
        x = X;
        y = Y;
        moveX = 10;
        moveY = 10;
        centerX = x + radius;
        centerY = y + radius;
        if(cl == -1)
        {
            c = gen.nextInt(5);
        }else{
            c = cl;
        }
    }
    public PinBallBall(int di,int Cx, int Cy,int mX, int mY)
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
    public void respawn(int W)
    {
        x = W-57;
        y = 645;
    }
    public void launchBall(int w, int h)
    {
        while(y>=30)
        {
            y = y - 1;
        }
    }
    public void movePinBallBall(int w, int h)
    {
        x = x + moveX;
        y = y + moveY;
        if(x+diameter >= w || x <= 0)
        {
            moveX = moveX*-1;
        }
        if( y <= 0)
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
    public boolean BallCollision(PinBallBall B)
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
    public int getColor()
    {
        return c;
    }
    public void changeDirection()
    {
        moveX = moveX*-1;
        moveY = moveY*-1;
    }
    public void changeXDirection()
    {
        moveX = moveX * -1;
    }
    public void changeYDirection()
    {
        moveY = moveY * -1;
    }
    public void drawPinBallBall()
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
                        g.setColor(Color.blue);
                    }else{
                        if(c == 6)
                        {
                            g.setColor(Color.blue);
                        }else{
                            g.setColor(Color.gray);
                        }
                    }
                }
            }
       }
       g.fillOval(x,y,diameter,diameter);
    }
    public void paint(Graphics gr)
    {
        g = gr;
        drawPinBallBall();
    }    
}