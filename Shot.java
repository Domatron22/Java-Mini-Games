import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import java.util.*;
public class Shot
{
    private int x_pos;
    private int y_pos;
    private int diameter;
    private int centerX;
    private int centerY;
    private int c;
    private final int radius;
    Random gen = new Random();
    public Shot(int x, int y)
    {
        x_pos = x;
        y_pos = y;
        diameter = 6;
        radius = 3;
        centerX = x_pos + radius;
        centerY = y_pos + radius;
    }
    public int getYPos()
    {
        return y_pos;
    }
    public void moveShot(int speed)
    {
        y_pos += speed;
    }
    public void moveEShot(int speed)
    {
        y_pos += speed;
    }
    public void update()
    {
        centerX = x_pos + radius;
        centerY = y_pos + radius;
    }
    public void drawShot(Graphics g)
    {
       c = 5;
       if(c == 5)
       {
           
           Random gen = new Random();
           int n = gen.nextInt(9);
           if(n == 0)
           {
               g.setColor(Color.green);
           }
           if(n == 1)
           {
               g.setColor(Color.blue);
           }
           if(n == 2)
           {
               g.setColor(Color.red);
           }
           if(n == 3)
           {
               g.setColor(Color.magenta);
           }
           if(n == 4)
           {
               g.setColor(Color.yellow);
           }
           if(n == 5)
           {
               g.setColor(Color.white);
           }
           if(n == 6)
           {
               g.setColor(Color.darkGray);
           }    
           if(n == 7)
           {
               g.setColor(Color.cyan);
           }
           if(n == 8)
           {
               g.setColor(Color.orange);
           }
           if(n == 9)
           {
               g.setColor(Color.gray);
           }
           g.fillOval(x_pos, y_pos,diameter,diameter);
        }
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
       return x_pos;
    }
    public int getY()
    {
       return y_pos;
    }
    public int getCenterX()
    {
       return centerX;
    }
    public int getCenterY()
    {
       return centerY;
    }
}