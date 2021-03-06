import java.awt.*;
import java.applet.*;
import java.util.*;
public class BSBall
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
    public BSBall(int X,int Y,int cl)
    {
        diameter = 14;
        radius = diameter / 2;
        x = X;//250-diameter;
        y = Y;//250-diameter;
        moveX = gen.nextInt(6) + 4;
        moveY = gen.nextInt(6) + 4;
        centerX = x + radius;
        centerY = y + radius;
        if(cl == -1)
        {
            c = gen.nextInt(5);
        }else{
            c = cl;
        }
        }
    public BSBall(int di,int Cx, int Cy,int mX, int mY)
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
    public void moveBSBall(int w, int h)
    {
        x = x + moveX;
        y = y + moveY;
        if(x+diameter >= w || x <= 0)
        {
            moveX = moveX*-1;
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
    public void respawn(BSPaddle shooter)
    {
        x = shooter.getX()-5;
        y = shooter.getY2()-5;
    }
    public void shoot(int z,int w, int x2, int y2,BSPaddle shooter)
    {
        int slopeY = (y2-w);
        int slopeX = (x2-z)*-1;
        moveY = slopeY;
        moveX = slopeX;
        x = x + moveX;
        y = y - moveY;
        update();
        //moveBall(500,500,shooter);
    }
    public boolean BSBallCollision(BSBall B)
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
     public void drawBSBall()
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
                        if(c == 69)
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
        drawBSBall();
    }    
}