package fastcampus.designPattern.adapter;

public class HairDryer implements Electronic110v{
    @Override
    public void powerOn() {
        System.out.println("Hair Dryer 110v on");
    }
}
