import java.util.*;

public class names {
    public static boolean comp(String s1, String s2)
    {
        return s1.compareTo(s2) > 0;
    }

    public static boolean isSorted(String[] arr)
    {
        for (int i = 0; i < arr.length-1; i++)
        {
            if (comp(arr[0], arr[i+1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String[] firstNames = {"Bob", "Tod", "ZuckYou"};
        String[] lastNames = {"Mikhailov", "Shroff", "Gorbachov"};

        while (!isSorted(lastNames))
        {
            System.out.println(Arrays.toString(lastNames));
            for (int i = 0; i < lastNames.length-1; i++)
            {
                if (!comp(lastNames[i], lastNames[i+1]))
                {
                    String temp = lastNames[i];
                    lastNames[i] = lastNames[i+1];
                    lastNames[i+1] = temp;
                }
            }

        }

        System.out.println(Arrays.toString(lastNames));
    }
}
