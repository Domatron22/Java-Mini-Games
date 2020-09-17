import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.Graphics.*;
import java.io.*;
public class SpaceGame extends JPanel implements Runnable,KeyListener
{
    private Thread th;
    private char c = 'e';
    private Player player;
    private Shot [] shots;
    private SpaceRectangle [] r;
    private final int shotSpeed = -10;
    private Image dbImage;
    private Graphics dbg;
    private Image Buffer;
    private Graphics gBuffer;
    Shot temp,temp2;
    ArrayList bricks;
    SpaceRectangle rTemp;
    String liv,pts;
    int width,height;
    int lives,points,bx,by,bw,bh,z,k,moveX,attack,attack2,attack3,moveA,moveB,moveC;
    SpaceRectangle atemp,atemp2,atemp3;
    boolean rightKey;
    boolean leftKey;
    boolean enterKey;
    boolean spaceKey;
    boolean checkHS;
    Image pic1,pic2,pic3,pic4,pic5,pic6,pic7;
    Random gen = new Random();
    SpaceRectangle er1,er2,er3,er4;
    Shot eshot1,eshot2,eshot3,eshot4;
    public void init(int H,int W)
    {
        /*pic1 = getImage(getCodeBase(), "giphy.gif");
        pic2 = getImage(getCodeBase(), "Nyan.gif");
        pic3 = getImage(getCodeBase(), "large.gif");
        pic4 = getImage(getCodeBase(), "carpet.gif");
        pic5 = getImage(getCodeBase(), "cat1.gif");
        pic6 = getImage(getCodeBase(), "cat2.gif");
        pic7 = getImage(getCodeBase(), "cat3.gif");*/
        width=W;
        height=H;
        Buffer=createImage(width,height);
        gBuffer=Buffer.getGraphics();
        player = new Player(350, 625);
        shots = new Shot[5];
        bricks = new ArrayList();
        points = 0;
        lives = 5;
        bx = z;
        by = k;
        bw = 20;
        bh = 10;
        int count = 0;
        for(int i = 0; i < 25; i++)
        {
            z = gen.nextInt(300) + 50;
            k = gen.nextInt(100) + 12;
            rTemp = new SpaceRectangle(bx,by,bw,bh,3,3);
            bx = bx + z;
            count ++;
            if(count == 5)
            {
                by = by + 15;
                bx = z;
                count = 0;
            }
            bricks.add(rTemp);
        }
        for(int i=0; i<shots.length; i++)
        {
            shots[i] = null;
        }
        addKeyListener(this);
        moveX = 2;
        attack = gen.nextInt(bricks.size());
        attack2 = gen.nextInt(bricks.size());
        attack3 = gen.nextInt(bricks.size());
        moveA =gen.nextInt(5)+2;
        moveB = gen.nextInt(5)+2;
        moveC = gen.nextInt(5)+2;
        eshot1=null;
        eshot2=null;
        eshot3=null;
        eshot4=null;
    }
    public boolean mouseDown(Event evt, int x, int y)
    {
        return true;
    }
    public void keyTyped(KeyEvent e)
    {
        c = e.getKeyChar();
        repaint();
    }
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
            leftKey = true;
            break;
            case KeyEvent.VK_RIGHT:
            rightKey = true;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = true;
            break;
            case KeyEvent.VK_ENTER:
            enterKey = true;
            break;
        }
    }
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
            leftKey = false;
            break;
            case KeyEvent.VK_RIGHT:
            rightKey = false;
            break;
            case KeyEvent.VK_SPACE:
            spaceKey = false;
            break;
            case KeyEvent.VK_ENTER:
            enterKey = false;
            break;
        }
    }  
    public void start ()
    {
        th = new Thread(this);
        th.start ();
    }
    public void stop()
    {
        th.stop();
    }
    public void destroy()
    {
        th.stop();
    }
    public void run()
    {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while (true)
        { 
            paint(gBuffer);
            if(rightKey){player.moveRight();}
            if(leftKey){player.moveLeft();}  
            if(spaceKey)
            {
                for(int i=0; i<shots.length; i++)
                {
                    if(shots[i] == null)
                    {
                        shots[i] = new Shot(player.getX(),player.getY());
                        spaceKey = false;
                        break;
                    }
                }
            }
            repaint();
            if(lives > 0)
            {      
                for(int i=0; i<shots.length; i++)
                {  
                    if(shots[i] != null)
                    {
                        shots[i].moveShot(shotSpeed);
                        for(int j=0; j<bricks.size(); j++)
                        {
                            rTemp = (SpaceRectangle)bricks.get(j);
                            if(rTemp.shotCollision(shots[i]))
                            {
                                bricks.remove(rTemp);
                                points++;
                                shots[i] = null;
                                break;
                            }
                            if(shots[i].getYPos() < 0)
                            {
                                shots[i] = null;
                                break;
                            }
                        }
                    }
                }
                repaint();
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException ex){}
                gBuffer.setColor(Color.black);
                gBuffer.fillRect(0,0,width,height); 
                
                if(eshot1==null)
                {
                    er1 = (SpaceRectangle)bricks.get(gen.nextInt(bricks.size()));
                    eshot1 = new Shot(er1.getX()+7,er1.getY()+7);
                }
                eshot1.moveEShot(gen.nextInt(6)+2);
                if(eshot1.getY()>=height)
                {
                    eshot1 = null;
                }
                if(eshot1!=null)
                {     
                    if(player.collision(eshot1))
                    {
                        lives = lives - 1;
                        eshot1 = null;
                    }
                }
                if(eshot2==null)
                {
                    er2 = (SpaceRectangle)bricks.get(gen.nextInt(bricks.size()));
                    eshot2 = new Shot(er2.getX()+7,er2.getY()+7);
                }
                eshot2.moveEShot(gen.nextInt(6)+2);
                if(eshot2.getY()>=height)
                {
                    eshot2 = null;
                }
                if(eshot2!=null)
                { 
                    if(player.collision(eshot2))
                    {
                        lives = lives - 1;
                        eshot2 = null;
                    }
                }
                if(eshot3==null)
                {
                    er3 = (SpaceRectangle)bricks.get(gen.nextInt(bricks.size()));
                    eshot3 = new Shot(er1.getX()+7,er1.getY()+7);
                }
                eshot3.moveEShot(gen.nextInt(6)+2);
                if(eshot3.getY()>=height)
                {
                    eshot3 = null;
                }
                if(eshot3!=null)
                {     
                    if(player.collision(eshot3))
                    {
                        lives = lives - 1;
                        eshot3 = null;
                    }
                }
                if(eshot4==null)
                {
                    er4 = (SpaceRectangle)bricks.get(gen.nextInt(bricks.size()));
                    eshot4 = new Shot(er1.getX()+7,er1.getY()+7);
                }
                eshot4.moveEShot(gen.nextInt(6)+2);
                if(eshot4.getY()>=height)
                {
                    eshot4 = null;
                }
                if(eshot4!=null)
                {     
                    if(player.collision(eshot4))
                    {
                        lives = lives - 1;
                        eshot4 = null;
                    }
                }
                if(atemp==null)
                {
                    attack = gen.nextInt(bricks.size());
                    atemp = (SpaceRectangle)bricks.get(attack);
                }
                boolean c = atemp.moveDown();
                if(c)
                {
                    atemp.moveInvader(moveA);
                    if(atemp.getX()+20>=width || atemp.getX()<=0)
                    {
                        moveA = moveA*-1;
                    }
                    if(atemp.getY()>=height)
                    {
                        atemp.setX(gen.nextInt(300)+50);
                        atemp.setY(gen.nextInt(100)+12);
                    }
                    if(player.invaderCollision(atemp))
                    {
                        atemp = null;
                        lives = lives - 1;
                    }
                }
            
                if(atemp2==null)
                {
                    attack2 = gen.nextInt(bricks.size());
                    atemp2 = (SpaceRectangle)bricks.get(attack2);
                }
                boolean d = atemp2.moveDown();
                if(d)
                {
                    atemp2.moveInvader(moveB);
                    if(atemp2.getX()+20>=width || atemp2.getX()<=0)
                    {
                        moveB = moveB*-1;
                    }
                    if(atemp2.getY()>=height)
                    {
                        atemp2.setX(gen.nextInt(300)+50);
                        atemp2.setY(gen.nextInt(100)+12);
                    }
                    if(player.invaderCollision(atemp2))
                    {
                        atemp2 = null;
                        lives = lives - 1;
                    }
                }
            
                if(atemp3==null)
                {
                    attack3 = gen.nextInt(bricks.size());
                    atemp3 = (SpaceRectangle)bricks.get(attack3);
                }
                boolean f = atemp3.moveDown();
                if(f)
                {
                    atemp3.moveInvader(moveC);
                    if(atemp3.getX()+20>=width || atemp3.getX()<=0)
                    {
                        moveC = moveC*-1;
                    }
                    if(atemp3.getY()>=height)
                    {
                        atemp3.setX(gen.nextInt(300)+50);
                        atemp3.setY(gen.nextInt(100)+12);
                    }
                    if(player.invaderCollision(atemp3))
                    {
                        atemp3=null;
                        lives = lives - 1;
                    }
                }
            
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                for(int i=0; i<shots.length; i++)
                {
                    if(shots[i] != null)
                    {
                        shots[i].drawShot(gBuffer);
                    }
                }
                if(eshot1!=null)
                {
                    eshot1.drawShot(gBuffer);
                }
                if(eshot2!=null)
                {
                    eshot2.drawShot(gBuffer);
                }
                if(eshot3!=null)
                {
                    eshot3.drawShot(gBuffer);
                }
                if(eshot4!=null)
                {
                    eshot4.drawShot(gBuffer);
                }
                for(int i = 0; i < bricks.size(); i++)
                {
                    rTemp = (SpaceRectangle)bricks.get(i);
                    rTemp.moveInvader(moveX);
                    if(rTemp.getX()<=0 || rTemp.getX()+20>=1200)
                    {
                        moveX = moveX*-1;
                    }
                    rTemp.paint(gBuffer);
                }
                if(bricks.size() == 0)
                {
                    gBuffer.setColor(Color.green);
                    gBuffer.setFont(new Font("Times New Roman", 30, 80));
                    gBuffer.drawString("YOU",350,200);
                    gBuffer.drawString("WIN!",350,250);
                    gBuffer.drawString("Enter to Continue",350,340);
                    try{
                        checkHS = SpaceHS.checkHS(points, checkHS);
                    }catch(IOException io){}
                    if(enterKey){endGame();break;}
                }
            }else{
                gBuffer.setColor(Color.green);
                gBuffer.setFont(new Font("Times New Roman", 30, 80));
                gBuffer.drawString("GAME",350,200);
                gBuffer.drawString("OVER!",350,250);
                gBuffer.drawString("Enter to Continue",350,340);
                try{
                    checkHS = SpaceHS.checkHS(points, checkHS);
                }catch(IOException io){}
                if(enterKey){endGame();break;}
            }
            gBuffer.setFont(new Font("Calibri", 20, 20));
            liv = String.valueOf(lives);
            gBuffer.drawString("LIVES:" ,5,570);
            gBuffer.drawString(liv ,5,585);
            pts = String.valueOf(points);
            gBuffer.setColor(Color.cyan);
            gBuffer.drawString("POINTS:" ,1100,570);
            gBuffer.drawString(pts ,1100,585);
            player.drawPlayer(gBuffer);
            repaint();
        }
    }
    public void endGame()
    {
        while(z==0)
        {
            SpaceGUI r = new SpaceGUI();
            JFrame p = r.getFrame();
            p.setVisible(false);
            p.dispose();
            JavaGames t = new JavaGames();
            t.setVisible(true);
            z++;
        }
    }
    public void update (Graphics g)
    {
        if (dbImage == null)
        {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics ();
        }
        dbg.setColor(getBackground ());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
        dbg.setColor(getForeground());
        paint(dbg);
        g.drawImage (dbImage, 0, 0, this);
    }
    public void paint (Graphics g)
    {
        g.drawImage(Buffer,0,0,this);
    }
    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
}