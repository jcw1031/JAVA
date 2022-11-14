package network.socket.chating.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {
    private Socket socket;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputMessage;
            String[] split;

            System.out.println("receive thread");

            while (true) {
                inputMessage = br.readLine();

                split = inputMessage.split(">");
                if (split.length >= 2 && split[0].equals(ChatClient2.userId)) {
                    continue;
                }
                System.out.println(inputMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
