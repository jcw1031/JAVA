package network.socket.serverThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {
    private Socket socket;
    private String name;

    public ReceiveThread(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
//        super.run();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputMessage;

            while (true) {
                inputMessage = br.readLine();
                System.out.println("server - " + inputMessage);

                if (inputMessage == null) {
                    System.out.println("연결이 끊겼습니다.");
                    break;
                } else {
                    System.out.println(name+" : " + inputMessage);
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
