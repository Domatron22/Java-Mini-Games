
import java.awt.*;
import java.applet.*;
import java.util.*;
public class BSPaddle
{
    int x,y,x2,y2,length,width,xEdge,yEdge,xStep;
    Graphics g;
    Random D = new Random(); 
    public BSPaddle()
    {
        x = 240;
        y = 425;  
        x2 = 240;
        y2 = 550; 
        length = 50;
        width = 100;
        xEdge = x + width;
        yEdge = y + length;
        xStep = 5;
    }
    public BSPaddle(int X, int Y, int X2, int Y2, int l, int w )
    {
        x = X;
        y = Y;   
        x2 = X2;
        y2 = Y2; 
        length = l; 
        width = w; 
        xEdge = x + width;
        yEdge = y + length; 
        xStep = 5;  
    }
    public int getX()
    {
        return x;
    } 
    public int getY()
    {
        return y;
    }
    public int getX2()
    {
        return x2;
    }    
    public int getY2()
    {
        return y2;
    }
    public int getLength()
    {
        return length;
    }
    public int getWidth()
    {   
        return width;
    }
    public int getXEdge()
    {
        return xEdge;
    }
    public int getYEdge()
    {
        return yEdge;
    }
    public void setX(int location)
    {
        x = location;
        xEdge = x + width;
    }
    public void moveUp()
    {
        y = y - xStep;
        yEdge = y + length;
    }
    public void moveDown()
    {
        y = y + xStep;
        yEdge = y + length;
    }
    public void moveRight()
    {
        if(x < 290)
        x = x + xStep;
        xEdge = x + width;
        //CIRCLE FORMULA
        y = -1*(int)Math.sqrt(1250 - (x-250)*(x-250))+490;
    }
    public void moveLeft()
    {
        if(x> 210)
        x = x - xStep;
        xEdge = x + width;
        //CIRCLE FORMULA
        y = -1*(int) Math.sqrt(1250 - (x-250)*(x-250))+490;
    }
    public boolean collision(BSBall A)
    {
        boolean hit = false;

        int bx = A.getX();
        int by = A.getY();
        int diameter = A.getDiameter();
        int radius = diameter / 2;
        int centerX = A.getCenterX();
        int centerY = A.getCenterY();
    
        int xsq = (centerX - xEdge)*(centerX - xEdge);
        int ysq = 0;
        double distance = 0;
    
        for(int i = y; i <= yEdge; i++)
        {
            ysq = (centerY - i)*(centerY-i);
            distance = Math.sqrt(xsq+ysq);
            if(radius >= distance)
            {
                //A.changeXDir();
                hit = true;
                break;
            }
        }
    
        xsq = (centerX - x)*(centerX - x);
        for(int i = y; i <= yEdge; i++)
        {
            ysq = (centerY - i)*(centerY-i);
            distance = Math.sqrt(xsq+ysq);
            if(radius >= distance)
            {
                //A.changeXDir();
                hit = true;
                break;
            }
        }
    
        ysq = (centerY - y)*(centerY - y);
        for(int i = x; i <= xEdge; i++)
        {
            xsq = (centerX - i)*(centerX-i);
            distance = Math.sqrt(xsq+ysq);
            if(radius >= distance)
            {
                //A.changeYDir();
                hit = true;
                break;
            }
        }
    
        ysq = (centerY - yEdge)*(centerY - yEdge);
        for(int i = x; i <= xEdge; i++)
        {
            xsq = (centerX - i)*(centerX-i);
            distance = Math.sqrt(xsq+ysq);
            if(radius >= distance)
            {
                //A.changeYDir();
                hit = true;
                break;
            }
        }
        return hit;
    }
    public void moveRect()
    {
        x = x + xStep;
        xEdge = x + width;
        if((xEdge >= 800)|| (x <= 0))
        xStep = xStep *-1;
    }
    public void drawRect()
    {
    
        g.setColor(Color.magenta);
        g.drawLine(x,y,x2,y2);
    }
    public void paint(Graphics gr)
    {
        g = gr;
        drawRect();
    }
}