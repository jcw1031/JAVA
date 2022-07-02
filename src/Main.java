import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int total = 0;
        int max = 0;
        int tmp;
        for (int i = 0; i < 10; i++) {
            tmp = s.nextInt();
            total -= tmp;
            tmp = s.nextInt();
            total += tmp;
            if (max < total) max = total;
        }
        System.out.println(max);
    } 
}