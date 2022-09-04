import java.lang.Thread;

public class tree
{
    final static int size = 25;
    //  .:-=+*#%@ <-- Simpler representation
    final static String asciiDarkness = " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";

    private static void readOneBranch(int grid[][], branch b)
    {
        for (int i = 0; i < b.points.length; i++)
        {
            if (b.points[i][0] == -1) break;
            grid[b.points[i][0]][b.points[i][1]] = 1;
        }

        if (b.reproduced)
        {
            if (Math.random() > .5)
                readOneBranch(grid, b.rightBranch);
            else
                readOneBranch(grid, b.leftBranch);
        }
    }

    private static int branchCount(branch b)
    {
        if (b.reproduced)
            return 0 + branchCount(b.rightBranch) + branchCount(b.leftBranch);
        return 1;
    }

    private static int bi = 0;

    private static void fillNeg(int matrix[][])
    {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
            {
                matrix[i][j] = -1;
            }
    }

    private static void fillNeg(int matrix[][][])
    {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                for (int k = 0; k < matrix[0][0].length; k++)
                {
                    matrix[i][j][k] = -1;
                }
    }

    private static int[][] copy(int[][] matrix)
    {
        int [][] myInt = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++)
            myInt[i] = matrix[i].clone();
        return myInt;
    }

    private static double[][] copy(double[][] matrix)
    {
        double [][] myInt = new double[matrix.length][];
        for(int i = 0; i < matrix.length; i++)
            myInt[i] = matrix[i].clone();
        return myInt;
    }

    private static void read(branch b, int write[][][], int points[][], int pi)
    {
        int i = 0;
        while (i < b.points.length && b.points[i][0] != -1)
        {
            points[pi+i][0] = b.points[i][0];
            points[pi+i][1] = b.points[i][1];
            i++;
        }

        if (b.reproduced)
        {
            read(b.leftBranch, write, copy(points), i+pi);
            read(b.rightBranch, write, copy(points), i+pi);
        } else {
            for (int j = 0; j < i+pi; j++)
            {
                // System.out.print(j);
                // System.out.println(i+pi);
                write[bi][j][0] = points[j][0];
                write[bi][j][1] = points[j][1];
            }

            for (int j = i+pi; j < size; j++)
            {
                write[bi][j][0] = -1;
            }
            bi++;
        }
    }

    public static void renderGrid(double[][] grid )
    {
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        for (int y = size-1; y > -1; y--)
        {
            String line = "";
            for (int x = 0; x < size; x++)
                line += asciiDarkness.charAt((int)(grid[x][y]*(asciiDarkness.length()-1)));
            System.out.println(line);
        }
    }

    public static boolean inRange(int size, int x, int y)
    {
        return x > -1 && x < size && y > -1 && y < size ;
    }

    public static int[][] _3x3(int x, int y)
    {
        int[][] poss = {
            {x-1, y-1},
            {x-1, y},
            {x-1, y+1},
            {x, y-1},
            {x, y},
            {x, y+1},
            {x+1, y-1},
            {x+1, y},
            {x+1, y+1},
        };
        return poss;
    }

    public static double getGridValue(double[][] grid, int x, int y)
    {
        // if (inRange(size, x, y))
        // {
        //     return grid[x][y];
        // }
        // return 0;
        return inRange(size, x, y) ? grid[x][y] : 0;
    }

    public static void main(String[] args) throws InterruptedException {
        branch trunk = new branch(size, size/2, -1, 0);

        int bc = branchCount(trunk);
        int branches[][][] = new int[bc][size*2][2]; fillNeg(branches);
        int points[][] = new int[size*2][2]; fillNeg(points);
        read(trunk, branches, points, 0);

        int reader = 0;
        double grid[][] = new double[size][size];
        double newGrid [][] = new double[size][size];
        // for (int i = 0; i < branches[i].length; i++)
        // {
        //     if (branches[reader][i][0] != -1)
        //         grid[branches[reader][i][0]][branches[reader][i][1]] = 1;
        // }

        int p = 0;
        while (true)
        {
            if (branches[reader][p][0] != -1)
                grid[branches[reader][p][0]][branches[reader][p][1]] = 1;
            if (branches[reader][p+1][0] != -1)
                grid[branches[reader][p+1][0]][branches[reader][p+1][1]] = 1;

            for (int x = 0; x < size; x++)
            {
                for (int y = 0; y < size; y++)
                {
                    double sum = 0;
                    int[][] positions = _3x3(x, y);
                    for (int i = 0; i < 9; i++)
                    {
                        sum += Math.pow(getGridValue(grid, positions[i][0], positions[i][1]), 1.5);
                    }
                    newGrid[x][y] = grid[x][y] * .85 +  sum/9 * .15;
                }
            }
            renderGrid(newGrid);
            Thread.sleep(10);

            grid = copy(newGrid);

            p = (p+2)%(branches[reader].length-1);
            if (p == 0 || p == 1)
                reader = (int)(Math.random()*bc);
        }
    }
}