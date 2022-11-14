package network.socket.chating.client;

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
        super.run();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            String message;

            System.out.println("send server");

            System.out.print("사용할 ID : ");
            ChatClient2.userId = br.readLine();

            pw.println("IDjcw1031"+ ChatClient2.userId);
            pw.flush();


            while (true) {
                message = br.readLine();

                if (message.equals("exit")) {
                    break;
                }

                pw.println(message);
                pw.flush();
            }

            pw.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
