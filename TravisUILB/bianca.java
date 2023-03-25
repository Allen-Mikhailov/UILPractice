import java.util.*;
import java.io.*;

public class bianca
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./bianca.dat"));
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int val1 = in.nextInt();
            int val2 = in.nextInt();
            System.out.printf("%.2f\n", Math.sqrt(val2*val2 + val1*val1));
        }
    }
}