package network.socket;

import javax.swing.*;
import java.awt.*;

public class ChatGui extends JFrame {
    public ChatGui() {
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(1, 2, 10, 10));

        setContentPane(main);

        JPanel user1Panel = new JPanel();
        JPanel user2Panel = new JPanel();

        main.add(user1Panel);
        main.add(user2Panel);



        setVisible(true);
        setTitle("CacaoTalk");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new ChatGui();
    }
}
