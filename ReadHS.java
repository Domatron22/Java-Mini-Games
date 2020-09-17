import java.io.*;
public class ReadHS
{
    static File newfile;
    public ReadHS()
    {
        String sys = System.getProperty("user.home");
        String fileurl = sys +"\\Documents\\JavaGames\\HighScores";
        newfile = new File(fileurl);
        newfile.mkdir();
    }
    public static String getTrappedS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\TrappedHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getSpaceU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\SpaceHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getSpaceS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\SpaceHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getTrappedU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\TrappedHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getSnakeS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\SnakeHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getSnakeU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\SnakeHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getBSS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\BSHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getBSU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\BSHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getSlotS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\SlotHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getSlotU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\SlotHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getTrollS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\TrollHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getTrollU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\TrollHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getFroggerS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\FroggerHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getFroggerU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\FroggerHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }public static String getBrickS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\BrickHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getBrickU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\BrickHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getPinBallS() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\PinBallHS_score.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
    public static String getPinBallU() throws IOException
    {
        BufferedReader t = new BufferedReader(new FileReader(newfile +"\\PinBallHS_user.txt"));
        String temp = t.readLine();
        t.close();
        return temp;
    }
}