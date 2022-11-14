package network.socket.chating.gui;

import javax.swing.*;
import java.awt.*;

public class ChatGui extends JFrame {
    public ChatGui() throws HeadlessException {
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 5, 5));

        JPanel chat1Panel = new JPanel();
        JPanel chat2Panel = new JPanel();

        setContentPane(mainPanel);

        mainPanel.add(chat1Panel);
        mainPanel.add(chat2Panel);


    }
}
