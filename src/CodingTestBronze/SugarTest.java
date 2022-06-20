package CodingTestBronze;
import java.util.*;

public class SugarTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int order = s.nextInt();
        int five=0;
        int three=0;

        int tmp=order;
        while(true){
            if(order%5==0) {
                System.out.println(order/5);
                break;
            }
            tmp-=5;
            five++;
            if(tmp%3==0 && (tmp%5)%3==0){
                three=tmp/3;
                System.out.println(five+three);
                break;
            }

            if(tmp<3){
                if(order%3==0) System.out.println(order/3);
                else System.out.println(-1);
                break;
            }
        }

    }
}
