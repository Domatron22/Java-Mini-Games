import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;
public class FroggerBall 
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
    static int count;
    private int xEdge, yEdge,color,xStep,yStep;
    public FroggerBall(int X, int Y)
    {
        diameter = 10;
        radius = diameter / 2;
        x = X;
        y = Y;
        moveX = gen.nextInt(6) + 1;
        moveY = gen.nextInt(6) + 1;
        centerX = x + radius;
        centerY = y + radius;
        count = 0;
    }
    public FroggerBall(int di,int Cx, int Cy,int mX, int mY)
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
    public void moveFroggerBall(int w, int h)
    {
        x = x + moveX;
        y = y + moveY;
        if(x+diameter >= w || x <= 0)
        {
            moveX = moveX*-1;
        }
        if((y + diameter) >= 465 || y <= 0)
        {
            moveY = moveY*-1;
        }
        update();
    }
    public void pause()
    {
        x = x-moveX;
        y = y-moveY;
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
    public void moveUp()
    {
        y = y - 5;
    }
    public void moveDown()
    {
        y = y + 5;
    }
    public void moveLeft()
    {
        x = x - 5;
    }
    public void moveRight()
    {
        x = x + 5;
    }
    public boolean FroggerBallCollision(FroggerBall B)
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
    public boolean checkTrap(FroggerBall b)
    {
        boolean t = false;
        if(b.getX() > 210 && b.getX() < 265 && b.getY() > 200 && b.getY() < 255)
        {
            t = true;
        }else{
            t = false;
        }
        return t;
    }
    public void changeDirection()
    {
        moveX = moveX*-1;
        moveY = moveY*-1;
    }
    public void respawn(int X, int Y)
    {
        x = X;
        y = Y;
    }
    public void changeXDirection()
    {
        moveX = moveX*-1;
    }
    public void changeYDirection()
    {
        moveY = moveY*-1;
    }
     public void drawFroggerBall()
    {
        g.setColor(Color.white);
        g.fillOval(x,y,diameter,diameter);
    }
    public void paint(Graphics gr)
    {
        g = gr;
        drawFroggerBall();
    }    
}