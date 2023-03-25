import java.util.*;

public class Main {

    public static int[] mod(int[] array) {
        int most = array[0];
        int mostC = 0;
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            int c = 0;
            for (int j = 0; j < array.length; j++)
                if (val == array[j])
                    c++;

            if (mostC < c) {
                mostC = c;
                most = val;
            }
        }

        return new int[] {most, mostC};
    }

    public static void main(String[] args) {
        int[] array = {5, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 1, 0};

        int[] mostArr = new int[5];
        for (int i = 0; i < 5; i++)
        {
            int[] out = mod(array);;
            mostArr[i] = out[0];

            int x = 0;
            int[] newArray = new int[array.length-out[1]];
            for (int j = 0; j < array.length; j++)
                if (array[j] != out[0])
                {
                    newArray[x] = array[j];
                    x++;
                }
            array = newArray;
        }

        System.out.println(Arrays.toString(mostArr));
    }
}
