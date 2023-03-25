import java.util.*;
import java.io.*;

public class alan
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./alan.dat"));
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int f = in.nextInt();
            System.out.printf(f+" degrees Fahrenheit is equal to %.2f Kelvin\n", ((double) 5/9*(f-32)+273.15));                                                       
        }
    }
}