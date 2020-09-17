import java.io.*;
import java.util.*;
public class SnakeHS
{
    public static boolean checkHS(int score,boolean w) throws IOException
    {
        int highScore;
        String sys = System.getProperty("user.home");
        String D = sys +"//Documents//JavGames//HighScores";
        File inputFile = new File(D+"//SnakeHS_score.txt");
        Scanner scan = new Scanner(inputFile);
        while(scan.hasNextInt())
        {
            if(scan.next()==null)
            {
                FileWriter fw = new FileWriter(D+"//SnakeHS_score.txt");
                PrintWriter output = new PrintWriter(fw);
                output.print(score);
                fw.close();
                FileWriter fW = new FileWriter(D+"SnakeHS_user.txt");
                PrintWriter outPut = new PrintWriter(fW);
                String user = HighScores.getUser();
                outPut.print(user); 
                fW.close();
                w = true;
                break;
            }
            highScore = scan.nextInt();
            while(score > highScore)
            {
                FileWriter fw = new FileWriter(D+"//SnakeHS_score.txt");
                PrintWriter output = new PrintWriter(fw);
                output.print(score);
                fw.close();
                FileWriter fW = new FileWriter(D+"SnakeHS_user.txt");
                PrintWriter outPut = new PrintWriter(fW);
                String user = HighScores.getUser();
                outPut.print(user); 
                fW.close();
                w = true;
                break;
            }
            while(score < highScore)
            {
                w = false;
                break;
            }
        }
        scan.close();       
        return w;
    }
}