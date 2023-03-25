import java.util.*;
import java.io.*;

public class feng
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./feng.dat"));
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++)
        {
            String input = in.nextLine();
            String []time = input.split(":");
            float hour = Integer.parseInt(time[0]);
            float minute = Integer.parseInt(time[1]);
            float a = 30*hour+(minute/60)*30;
            float b = 6*minute;
            float c = 0;
            float d = 0;
            if(0<=a&&a<=90){
                c = 90-a;
            }else if(90<a&&a<=180){
                c = 270+180-a;
            }else if(180<a&&a<=270){
                c=270-(a-180);
            }else{
                c = 270-(a-180);
            }
            if(0<=b&&b<=90){
                d = 90-b;
            }else if(90<b&&b<=180){
                d = 270+180-b;
            }else if(180<b&&b<=270){
                d=270-(b-180);
            }else{
                d = 270-(b-180);
            }
            System.out.printf("Hour: %.1f Minute: %.1f\n", c, d);
        }
    }
}