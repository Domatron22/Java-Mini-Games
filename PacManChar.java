//object class for pac man character 
//allow to move left right up down
//stop at walls
//import pictures
import java.awt.*;
import java.applet.*;
import java.util.*;
public class PacManChar
{
    int px =0;
    int py = 0;
    int count = 0;
    boolean col = false;
    Graphics g;
    
    public PacMan()
    {
        
    }
    public int getPx()
    {
        return px;
    }
    public int getPy()
    {
        return py;
    }
    public int Count()
    {
        return count;
    }
    public boolean Collision()
    {
        return col;
    }
}