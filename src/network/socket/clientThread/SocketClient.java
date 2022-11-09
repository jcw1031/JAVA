package network.socket.clientThread;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

            System.out.println(socket);

            ReceiveThread receiveThread = new ReceiveThread(socket, "user2");
            SendThread sendThread = new SendThread(socket);

            receiveThread.start();
            sendThread.start();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}