package network.socket.chating.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static ArrayList<PrintWriter> outputList;

    public static void main(String[] args) {
        outputList = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            while (true) {
                Socket socket = serverSocket.accept();
                ClientManagerThread thread = new ClientManagerThread(socket);

                outputList.add(new PrintWriter(socket.getOutputStream()));
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}






