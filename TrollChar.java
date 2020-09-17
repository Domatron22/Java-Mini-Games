import java.awt.*;
import java.applet.*;
import java.util.*;
public class TrollChar
{
    int LX,LY,LX2,LY2;//LEFT LEG
    int RX,RY,RX2,RY2;//RIGHT LEG
    int lx,ly,lx2,ly2;//left arm
    int rx,ry,rx2,ry2;//right arm
    int BX,BY,BX2,BY2;//body
    int hd,hx,hy;//head
    int moveRl, moveLl, moveRa, moveLa;
    int Rx,Ry,Rw,Rh;
    Graphics g;
    Random D = new Random(); 
    int count;
    int jump;
    public TrollChar()
    {
        //left leg
        LX = 23;
        LY = 480;
        LX2 = 30;
        LY2 = 440;
        //right leg
        RX = 37;
        RY = 480;
        RX2 = 30;
        RY2 = 440;
        //body
        BX = 30;
        BY = 440;
        BX2 = 30;
        BY2 = 410;
        //left arm
        lx = 22;
        ly = 440;
        lx2 = 30;
        ly2 = 418;
        //right arm
        rx = 38;
        ry = 440;
        rx2 = 30;
        ry2 = 418;
        //head;
        hx = 22;
        hy = 400;
        hd = 15;
        //boxed in
        Rx = 22;
        Ry = 400;
        Rw = 16;
        Rh = 80;
        
        moveRl = 5;
        moveLl = 5;
        moveRa = 3;
        moveLa = 3;
        jump = -7;
    }
    public int getRx()
    {
        return Rx;
    }
    public int getRy()
    {
        return Ry;
    }
    public int getBX()
    {
        return BX;
    }
    public void moveChar()
    {
        if(BX<405)
        {
            LX = LX + 2;
            LX2 = LX2 + 2;
            RX = RX + 2;
            RX2 = RX2 + 2;
            BX = BX + 2;
            BX2 = BX2 +2;
            lx = lx + 2;
            lx2 = lx2 + 2;
            rx = rx + 2;
            rx2 = rx2 +2;
            hx = hx + 2;
            
            Rx = Rx + 2;
        }
    }
    public void runEffect()
    {
        RX = RX - moveRl;
        LX = LX + moveLl;
        rx = rx - moveRa;
        lx = lx + moveLa;
        if(LX <= 397-2 || LX >= 413+2)
        {
            moveRl = moveRl*-1;
            moveLl = moveLl*-1;
            moveRa = moveRa*-1;
            moveLa = moveLa*-1;
        }
    }
    public void jumpUP()
    {
        RY = RY + jump;
        RY2 = RY2 + jump;
        LY = LY + jump;
        LY2 = LY2 + jump;
        BY = BY + jump;
        BY2 = BY2 + jump;
        ry = ry + jump;
        ry2 = ry2 + jump;
        ly = ly + jump;
        ly2 = ly2 + jump;
        hy = hy + jump; 
        Ry = Ry + jump;
        if(LY <= 420 || LY >= 480)
        {
            jump = jump*-1;
        }
    }
    public void checkJump()
    {
        if(LY!=480)
        {
            RY = RY + jump;
            RY2 = RY2 + jump;
            LY = LY + jump;
            LY2 = LY2 + jump;
            BY = BY + jump;
            BY2 = BY2 + jump;
            ry = ry + jump;
            ry2 = ry2 + jump;
            ly = ly + jump;
            ly2 = ly2 + jump;
            hy = hy + jump;
            
            Ry = Ry + jump;
            
            count = count + 1;
            if(LY <= 420 || LY >= 480)
            {
                jump = jump*-1;
            }
        }
    }
    public void drawRect()
    {
        g.setColor(Color.white);
        g.drawLine(LX,LY,LX2,LY2);
        g.drawLine(RX,RY,RX2,RY2);
        g.drawLine(BX,BY,BX2,BY2);
        g.drawLine(lx,ly,lx2,ly2);
        g.drawLine(rx,ry,rx2,ry2);
        g.fillOval(hx,hy,hd,hd);
        //g.drawRect(Rx,Ry,Rw,Rh);
    }
    public void paint(Graphics gr)
    {
        g = gr;
        drawRect();
    }
}