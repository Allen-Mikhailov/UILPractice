import java.util.*;
import java.io.*;
// import java.l.Pow;

public class justin
{
    public static void formatThing(double value)
    {
        String valStr = "" + ((int) value);
        String addedStr = "";
        for (int i = 0; i < 9-valStr.length()-3; i++)
            addedStr += " ";
        System.out.printf("$"+addedStr+"%.2f", value);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./justin.dat"));
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++)
        {
            double P = in.nextDouble();
            double d = in.nextDouble();
            double r = in.nextDouble()/1200.;
            double N = in.nextDouble();
            double ans1 = ((P-d)*r)/(1-Math.pow((1+r),-N));
            double ans5 = Math.round(ans1*100)/100.0;
            double ans2 = (double)((ans5*N)+d);
            double ans3 = ans2-P;
            
            
            formatThing(ans1);
            System.out.print(" ");
            formatThing(ans2);
            System.out.print(" ");
            formatThing(ans3);
            System.out.println();
        }
    }
}