package fastcampus.designPattern.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110v adapterA = new SocketAdapter(cleaner);
        connect(adapterA);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110v adapterB = new SocketAdapter(airConditioner);
        connect(adapterB);
    }

    public static void connect(Electronic110v electronic110v){
        electronic110v.powerOn();
    }
}
