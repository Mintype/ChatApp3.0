import javax.swing.*;
import java.awt.*;

public class GraphicalInterface {

    JFrame frame;
    JLabel label;
    JTextField console;

    GraphicalInterface() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,500);
        frame.setResizable(false);
        frame.setLayout(null);

        label = new JLabel("ChatApp3.0-Server");
        label.setBounds(0, 0, 750, 35);
        label.setFont(new Font("Serif", Font.PLAIN, 35));

        console = new JTextField();
        console.setBounds(10, 45, 550,380);
        console.setFont(new Font("Verdana",Font.BOLD,15));
        console.setHorizontalAlignment(JTextField.LEFT);

        frame.add(label);
        frame.add(console);

        frame.setVisible(true);
    }
}
