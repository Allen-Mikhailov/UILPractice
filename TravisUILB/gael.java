import java.util.*;
import java.io.*;

public class gael
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./gael.dat"));
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            String word = in.next();
            for (int y = 0; y < word.length(); y++)
            {
                for (int x = 0; x < word.length(); x++)
                {
                    String out = " ";
                    if (x == 0)
                        out = "" + word.charAt(y);
                    if (x == word.length()-1)
                        out = "" + word.charAt(word.length()-1-y);
                    if (y == 0)
                        out = "" + word.charAt(x);
                    if (y == word.length()-1)
                        out = "" + word.charAt(word.length()-1-x);
                    System.out.print(out);
                }
                System.out.println();
            }
        }
    }
}