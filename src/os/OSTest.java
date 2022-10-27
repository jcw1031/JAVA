package os;

public class OSTest {
    public static void main(String[] args) throws InterruptedException {
        BankAccount b = new BankAccount();
        Parent p = new Parent(b);
        Child c = new Child(b);
        p.start();
        c.start();
        p.join();
        c.join();
        System.out.println("\nbalance = " + b.getBalance());
    }
}

class BankAccount {
    int balance;

    synchronized void deposit(int amt) {
        int temp = balance + amt;
        System.out.print("+");
        balance = temp;
//        notify();
    }

    synchronized void withdraw(int amt) {
        /*if (balance == 0) {
            System.out.println("잔액 없음");
            wait();
        }*/
        int temp = balance - amt;
        System.out.print("-");
        balance = temp;
    }

    int getBalance(){
        return balance;
    }
}

class Parent extends Thread {
    BankAccount b;

    Parent(BankAccount b) {
        this.b = b;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            b.deposit(1000);
        }
    }
}

class Child extends Thread {
    BankAccount b;

    Child(BankAccount b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            b.withdraw(1000);
            /*try {
                b.withdraw(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
    }
}