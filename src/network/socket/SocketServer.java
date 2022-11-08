package network.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        BufferedReader br;
        PrintWriter pw;

        Socket socket = null;
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println("해당 포트가 이미 사용 중입니다.");
        }

        try{
            socket = serverSocket.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

            String inputMessage;
            inputMessage = br.readLine();

            System.out.println("Client : " + inputMessage);

            pw.write(inputMessage);
            pw.flush();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
