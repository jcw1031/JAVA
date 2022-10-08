package fastcampus.designPattern.adapter;

public class Cleaner implements Electronic220v{
    @Override
    public void connect() {
        System.out.println("Cleaner 220v on");
    }
}
