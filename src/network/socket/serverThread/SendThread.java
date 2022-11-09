package network.socket.serverThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread {
    private Socket socket;

    public SendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
//        super.run();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            String message;

            while (true) {
                message = br.readLine();

                pw.write(message);
                pw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
