package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  str;
        System.out.println("begin");
        System.out.println("enter end to end");
        do{
            str=br.readLine();
            System.out.println(str);
        }while(!str.equals("end"));
    }
}
