package fastcampus.designPattern.adapter;

public class AirConditioner implements Electronic220v{
    @Override
    public void connect() {
        System.out.println("AirConditioner 220v on");
    }
}
