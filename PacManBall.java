import java.awt.*;
import java.applet.*;
import java.util.*;
public class PacManBall
{
    private int diameter;
    private int radius;
    private int x;
    private int y;
    private int centerX;
    private int centerY;
    private int c;
    Graphics g;
    Random gen = new Random();  
    public PacManBall(int cl,int X,int Y)
    {
        diameter = 14;
        radius = diameter / 2;
        x = X;
        y = Y;
        centerX = x + radius;
        centerY = y + radius;
        if(cl == -1)
        {
            c = gen.nextInt(5);
        }else{
            c = cl;
        }
    }
    public PacManBall(int di,int Cx, int Cy,int mX, int mY)
    {
        diameter = di;
        radius = diameter / 2;
        x = Cx;
        y = Cy;
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
    public void update()
    {
        centerX = x + radius;
        centerY = y + radius;
    }
    public void setColor(int cl)
    {
        c = cl;
    }
    public void drawPacManBall()
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
        drawPacManBall();
    }    
}