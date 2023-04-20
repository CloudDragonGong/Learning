package GUI;

import com.sun.deploy.ui.AboutDialog;

import javax.swing.*;

public class p2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("login example");
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placePanel(panel);
        frame.setVisible(true);
    }

    public static void placePanel(JPanel panel){
        panel.setLayout(null);
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordText  = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        JButton button = new JButton("login");
        button.setBounds(100,100,80,25);
        panel.add(button);
    }
}
