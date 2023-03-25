import java.util.*;
import java.io.*;

public class dryrun
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./dryrun.dat"));
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            System.out.println("I like "+in.next()+".");
        }
    }
}