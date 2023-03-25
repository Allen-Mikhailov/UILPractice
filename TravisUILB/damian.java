import java.util.*;
import java.io.*;

public class damian
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./damian.dat"));
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int val = in.nextInt();
            for (int j = 1; j <= val; j++)
            {
                if (val%j == 0)
                {
                    String numStr = ""+j;

                    boolean isTrue = true;
                    for (int k = 1; k < numStr.length(); k++)
                    {
                        if (numStr.charAt(k-1) >= numStr.charAt(k))
                        {
                            isTrue = false;
                            break;
                        }
                    }

                    if (isTrue)
                        System.out.print(numStr + " ");
                }
            }
            System.out.println();
        }
    }
}