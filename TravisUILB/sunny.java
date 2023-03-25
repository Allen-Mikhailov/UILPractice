import java.util.*;
import java.io.*;
import java.util.HashMap;

public class sunny
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("./sunny.dat"));
        HashMap <String, String> list = new HashMap<>();
        while(in.hasNextLine()){
            String input = in.nextLine();
            String [] course = input.split(" ");
            list.put(course[0], course[1]);
        }
        for (String thing : list){
            
        }
    }
}