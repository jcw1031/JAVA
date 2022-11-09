package network.socket.serverThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            Socket socket = serverSocket.accept();

            ReceiveThread receiveThread = new ReceiveThread(socket, "user1");
            SendThread sendThread = new SendThread(socket);

            receiveThread.start();
            sendThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}