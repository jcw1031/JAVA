package CodingTestBronze;
import java.util.*;

public class PlusCycle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int input = s.nextInt();
        int first = input;
        int tmp;
        int count=0;

        do{
            tmp=0;
            tmp+=input/10;
            tmp+=input%10;
            tmp=(input%10)*10 + tmp%10;
            input=tmp;
            count++;
        }while(first!=input);
        System.out.println(count);
    }
}
