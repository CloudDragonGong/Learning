package GUI;
import javax.swing.*;
public class p1 {
    public static void createAndShowGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloWorldSwing");
        //设置关闭窗口是的操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示文本
        JLabel label = new JLabel("hello 刘亦谨");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
