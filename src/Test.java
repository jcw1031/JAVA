import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int menu = (int) (Math.random() * 2);

        if (menu == 0) {
            System.out.println("먹어!!!");
        } else {
            System.out.println("먹지마!");
        }
    }
}