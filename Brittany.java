import java.util.*;
import java.io.*;

public class Brittany
{
    public static void main(String args[]) throws IOException {
        Scanner keyboard = new Scanner(new File("./brittany.dat"));
        double sum = 0;
        int i = 0;

        while (keyboard.hasNextDouble())
        {
            sum += keyboard.nextDouble();
            i += 1;
        }

        System.out.printf("%.2f %.2f", sum, sum/i);
    }
}