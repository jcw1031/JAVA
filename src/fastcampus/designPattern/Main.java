package fastcampus.designPattern;

import fastcampus.designPattern.singleton.SocketClient;
import fastcampus.designPattern.singleton.UseSingletonA;
import fastcampus.designPattern.singleton.UseSingletonB;

public class Main{
    public static void main(String[] args) {
        UseSingletonA useSingletonA = new UseSingletonA();
        UseSingletonB useSingletonB = new UseSingletonB();

        SocketClient aClient = useSingletonA.getSocketClient();
        SocketClient bClient = useSingletonB.getSocketClient();

        System.out.println(aClient.equals(bClient));
    }
}
