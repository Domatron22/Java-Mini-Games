import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import javax.swing.*;
public class BrickHS
{
    public static boolean checkHS(int score,boolean w) throws IOException
    {
        int highScore;
        String sys = System.getProperty("user.home");
        String D = sys +"//Documents//JavaGames//HighScores";
        File inputFile = new File(D+"\\BrickHS_score.txt");
        Scanner scan = new Scanner(inputFile);
        while(scan.hasNextInt())
        {
            highScore = scan.nextInt();
            if(scan.next().isEmpty())
            {
                FileWriter fw = new FileWriter(D+"\\BrickHS_score.txt");
                PrintWriter output = new PrintWriter(fw);
                output.print(score);
                fw.close();
                FileWriter fW = new FileWriter(D+"\\BrickHS_user.txt");
                PrintWriter outPut = new PrintWriter(fW);
                String user = HighScores.getUser();
                outPut.print(user); 
                fW.close();
                w = true;
                break;
            }
            while(score > highScore)
            {
                FileWriter fw = new FileWriter(D+"\\BrickHS_score.txt");
                PrintWriter output = new PrintWriter(fw);
                output.print(score);
                fw.close();
                FileWriter fW = new FileWriter(D+"\\BrickHS_user.txt");
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
