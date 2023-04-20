package IO;

import java.io.*;

public class p4 {
    public static void main(String[] args) throws IOException {
        byte[] bwrite={11, 21, 3, 40, 5};
        OutputStream os = new FileOutputStream("test.txt");
        for ( int i = 0 ; i < bwrite.length ; i++){
            os.write(bwrite[i]);
        }
        os.close();

        InputStream is = new FileInputStream("test.txt");
        int size = is.available();
        for (int i = 0; i < size; i++) {
            char x = (char ) is.read();
            System.out.println(x+" ");
        }
        is.close();
    }
}
