import java.util.*;
import java.io.*;

public class Semma {
    public static void main(String args[]) throws IOException
    {
        Scanner f = new Scanner(new File("./semma.dat"));
        String names[] = f.nextLine().split(",");
        
        while (names.length > 0)
        {
            String nam[] = new String[names.length];
            int namCount[] = new int[names.length];
            int diff = 0;

            for (int i = 0; i < names.length; i++)
            {
                nam[i] = "";
                namCount[i] = 0;
            }

            for (int i = 0; i < names.length; i++)
            {
                int Found = -1;

                for (int j = 0; j < nam.length; j++)
                {
                    if (nam[j].equals(names[i]))
                    {
                        Found = j;
                        break;
                    }
                }

                if (Found != -1)
                {
                    namCount[Found]++;
                } else {
                    nam[diff] = names[i];
                    namCount[diff]++;
                    diff++;
                }

            }

            String mostName = nam[0];
            int nameCount = namCount[0];
        
            for (int j = 1; j < names.length; j++)
            {
                if (namCount[j] > nameCount)
                {
                    nameCount = namCount[j];
                    mostName = nam[j];
                }
            }

            System.out.println(mostName + " " + nameCount);

            int goTo = names.length;
            String[] newNames = new String[names.length - nameCount];
            int h = 0;
            for (int j = 0; j < goTo; j++)
            {
                if (!names[j].equals(mostName))
                {
                    newNames[h] = names[j];
                    h++;
                }
            }

            names = newNames;
        }
    }
}
