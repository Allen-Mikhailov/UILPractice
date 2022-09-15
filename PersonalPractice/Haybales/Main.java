import java.lang.*;

public class Main {

    public static void main(String[] args) {
        int range = 1000;
        int ranges = 100;
        int[] rangeStarts = new int[ranges];
        int[] rangeEnds = new int[ranges];

        for (int i = 0; i < ranges; i++)
        {
            rangeStarts[i] = (int) (Math.random()*range);
            rangeEnds[i] = (int) (Math.random()*rangeStarts[i]-range);
        }
    }

    public static int Solve(int[] rangeStarts, int[] rangeEnds, int range)
    {

        int[] startSums = new int[range];
        int[] endSums = new int[range];

        // for (int i )

        return 0;
    }
}
