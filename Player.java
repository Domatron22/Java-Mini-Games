import java.awt.Graphics;
import java.awt.Color;
public class Player
{
	private int x_pos;
	private int y_pos;
	private int x;
    private int y;
    private int moveX;
    private int moveY;
    private int right;
    private int bottom;
    private int width;
    private int height;
	public Player(int x1, int y1)
	{
		x_pos = x1;
		y_pos = y1;
		moveX = 4;
		moveY = 4;
		width=20;
		height = 20;
	}
	public int getX()
	{
	    return x_pos;
	}
	public int getY()
	{
	    return y_pos;
	}
	public void moveX(int speed)
	{
		x_pos += speed;
	}
	public Shot generateShot()
	{
		Shot shot = new Shot(x_pos, y_pos);
		return shot;
	}
    public void moveUp()
    {
        y = y - moveY;
        update();
    }
    public void moveDown()
    {
        y = y + moveY;
        update();
    }
    public void moveRight()
    {
        x_pos = x_pos + moveX;
        //update();
    }
    public void moveLeft()
    {
        x_pos = x_pos - moveX;
        //update();      
    }
    public void update()
    {
        right = x + width;
        bottom = y + height;
    }
    public boolean collision(Shot s)
    {
        boolean t = false;
        int sx = s.getX();
        int sy = s.getY();
        x = x_pos;
        y = y_pos;
        if(sx>=x-10 && sx+6<=x+10 && sy+6>=y && sy+6<=y+10)
        {
            t = true;
        }
        return t;
    }
    public boolean invaderCollision(SpaceRectangle r)
    {
        boolean t = false;
        int rx = r.getX();
        int ry = r.getY();
        x = x_pos;
        y = y_pos;
        if(rx>=x-10 && rx+20<=x+10 && ry+10>=y && ry+10<=y+10)
        {
            t = true;
        }
        return t;
    }
	public void drawPlayer(Graphics g)
	{
		g.setColor(Color.red);
		int [] x_poly = {x_pos, x_pos - 10, x_pos, x_pos + 10};
		int [] y_poly = {y_pos, y_pos + 15, y_pos + 10, y_pos + 15};
		g.fillPolygon(x_poly, y_poly, 4);
		//g.drawRect(x_pos-10,y_pos,20,20);
	}
}