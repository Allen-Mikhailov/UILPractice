public class branch {
    public int points[][];
    public branch rightBranch;
    public branch leftBranch;
    public boolean reproduced = false;

    public static boolean inRange(int size, int x, int y)
    {
        return x > -1 && x < size && y < size;
    }

    public branch(int size, int x, int y, int dir)
    {
        int energy = 3 + (int)(Math.random()*6);
        int dirE = (2 + (int)(Math.random()*4)) * Math.abs(dir);
        points = new int[energy+dirE][2];
        for (int i = 0; i < points.length; i++)
        {
            points[i][0] = -1;
        }

        int i = 0;
        // Dir
        while (dirE > 0)
        {
            int newx = x+dir;
            if (newx < 0 || newx>=size) break;

            x = newx;
            points[i][0] = x;
            points[i][1] = y;

            dirE -= 1;
            i++;
        }

        // Up
        while (energy > 0 && inRange(size, x, y))
        {
            y++;

            if (!inRange(size, x, y)) break;

            points[i][0] = x;
            points[i][1] = y;

            energy--;
            i++;
        }
        
        if (inRange(size, x, y))
        {
            reproduced = true;
            leftBranch = new branch(size, x, y, -1);
            rightBranch = new branch(size, x, y, 1);
        }
    }
}
