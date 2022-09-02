import java.util.*;
import java.io.*;

public class Emmanuel {
    public static void main(String args[]) throws IOException {
        Scanner f = new Scanner(new File("./emmanuel.dat"));
        int lines = f.nextInt();
        f.nextLine();

        for (int i = 0; i < lines; i++)
        {
            String line = f.nextLine();
            line = line.replace("{", "");
            line = line.replace("}", "");
            line = line.replace(",", " ");

            Scanner nl = new Scanner(line);
            int array[] = new int[100];

            for (int j = 0; j < 100; j++)
                array[j] = 0;

            while (nl.hasNextInt())
            {
                array[nl.nextInt()] += 1;
            }

            int max = array[0];
            int maxI = 0;

            for (int j = 1; j < 100; j++)
            {
                if (array[j] > max)
                {
                    maxI = j;
                    max = array[j];
                }
            }

            System.out.printf("%d appeared %d times(s) \n", maxI, max);
        }
    }
}
