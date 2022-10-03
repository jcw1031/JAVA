package fastcampus.designPattern.singleton;

public class UseSingletonA {
    private SocketClient socketClient;

    public UseSingletonA(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
