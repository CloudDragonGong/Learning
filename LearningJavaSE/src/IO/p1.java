package IO;

import java.io.*;

public class p1 {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入q就是结束");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}



