import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import javax.swing.*;
public class FroggerHS
{
    public static boolean checkHS(int score,boolean w) throws IOException
    {
        int highScore;
        String sys = System.getProperty("user.home");
        String D = sys +"//Documents//JavaGames//HighScores";
        File inputFile = new File(D+"\\FroggerHS_score.txt");
        Scanner scan = new Scanner(inputFile);
        while(scan.hasNextInt())
        {
            if(scan.next()==null)
            {
                FileWriter fw = new FileWriter(D+"\\FroggerHS_score.txt");
                PrintWriter output = new PrintWriter(fw);
                output.print(score);
                fw.close();
                FileWriter fW = new FileWriter(D+"\\FroggerHS_user.txt");
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
                FileWriter fw = new FileWriter(D+"\\FroggerHS_score.txt");
                PrintWriter output = new PrintWriter(fw);
                output.print(score);
                fw.close();
                FileWriter fW = new FileWriter(D+"\\FroggerHS_user.txt");
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
