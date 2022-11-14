package network.socket.chating.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManagerThread extends Thread {
    private Socket socket;
    private String id;

    public ClientManagerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input;

            while (true) {
                input = br.readLine();

                if (input == null) {
                    System.out.println(id + " 접속 종료");

                    for (int i = 0; i < Server.outputList.size(); i++) {
                        Server.outputList.get(i).println(id + " 접속 종료");
                        Server.outputList.get(i).flush();
                    }
                    break;
                }

                String[] split = input.split("jcw1031");
                if (split.length == 2 && split[0].equals("ID")) {
                    id = split[1];
                    System.out.println(id + " 접속");

                    for (int i = 0; i < Server.outputList.size(); i++) {
                        Server.outputList.get(i).println(id + " 접속");
                        Server.outputList.get(i).flush();
                    }
                    continue;
                }

                for (int i = 0; i < Server.outputList.size(); i++) {
                    Server.outputList.get(i).println(id + "> " + input);
                    Server.outputList.get(i).flush();
                }
            }

            Server.outputList.remove(new PrintWriter(socket.getOutputStream()));
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
