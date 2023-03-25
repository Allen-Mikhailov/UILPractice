import java.util.*;
import java.io.*;

public class cho
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./cho.dat"));
        int n = in.nextInt();
        in.nextLine();
        String alphaMap = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < n; i++)
        {
            int [] alpha = new int [52];
            String input = in.nextLine();
            for(int x=0; x<input.length(); x++){
                if(alphaMap.indexOf(input.charAt(x))!=-1){
                    alpha[alphaMap.indexOf(input.charAt(x))]++;
                }
            }
            int best = -1;
            int index = 0;
            for(int x=0; x<52; x++){
                if(alpha[x]>best){
                    best = alpha[x];
                    index = x;
                }
            }
            System.out.println(alphaMap.charAt(index)+"");
        }
    }
}