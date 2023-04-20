package IO;
import java.io.*;
import java.sql.SQLOutput;

public class p5 {
    public static void main(String[] args) throws IOException {
        File f = new File("test.txt");
        FileOutputStream fop = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fop,"UTF-8");
        writer.append("我是谁");
        writer.append("你是谁啊");
        writer.close();
        fop.close();
        FileInputStream fip = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fip,"UTF-8");
        StringBuffer bf = new StringBuffer();
        while(reader.ready()){
            bf.append((char) reader.read());
        }
        System.out.println(bf.toString());
    }
}
