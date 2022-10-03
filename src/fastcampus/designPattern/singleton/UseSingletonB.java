package fastcampus.designPattern.singleton;

public class UseSingletonB {
    private SocketClient socketClient;

    public UseSingletonB(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
