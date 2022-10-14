import javax.swing.*;
import java.io.*;

class Thread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(getName());
        }
    }
}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run(){
        throwException();
    }

    public void throwException(){
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread3 extends Thread{
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

public class  Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Thread1 thread1 = new Thread1();

        Runnable1 runnable1 = new Runnable1();
        Thread thread2 = new Thread(runnable1);

        thread1.setName("thread1");
        thread2.setName("thread2");

        thread1.start();
        thread2.start();

        Thread2 thread21 = new Thread2();
        thread21.start();

        thread1.join();
        thread2.join();
        thread21.join();

        Thread3 thread3 = new Thread3();
        thread3.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");

        /*for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }*/
    }
}