package network.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) {
        BufferedReader br1;
        BufferedReader br2;
        PrintWriter pw;

        Socket socket = null;
        InetAddress ia = null;

        try {
            ia = InetAddress.getLocalHost();
            socket = new Socket(InetAddress.getLocalHost(), 9999);

            br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

            System.out.println(socket.toString());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.print("서버로 전송할 메시지 : ");
            String message;
            message = br1.readLine();
            System.out.println(message);
            pw.println(message);
            pw.flush();

            String inputMessage;
            inputMessage = br2.readLine();
            System.out.print("서버로부터 되돌아온 메시지 : " + inputMessage);
            socket.close();

        } catch (IOException e) {
            System.out.println("hello");
            throw new RuntimeException(e);
        }
    }
}
