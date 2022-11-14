package network.socket.chating.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient2 {
    public static String userId;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            System.out.println(socket);

            ReceiveThread receiveThread = new ReceiveThread(socket);
            SendThread sendThread = new SendThread(socket);

            sendThread.start();
            receiveThread.start();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
