package fastcampus.designPattern.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        UseSingletonA useSingletonA = new UseSingletonA();
        UseSingletonB useSingletonB = new UseSingletonB();

        SocketClient aClient = useSingletonA.getSocketClient();
        SocketClient bClient = useSingletonB.getSocketClient();

        System.out.println(aClient.equals(bClient));
    }
}
