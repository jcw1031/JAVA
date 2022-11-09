package network.socket.clientThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread {
    private Socket socket;
    private boolean flag = true;

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

            while (flag) {
                message = br.readLine();

                System.out.println("여긴 아닐듯");
                pw.write(message);
                System.out.println("아마 여기");
                pw.flush();
            }
            pw.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void endClient() {
        this.flag = false;
    }
}
