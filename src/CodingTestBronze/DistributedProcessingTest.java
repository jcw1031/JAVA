package CodingTestBronze;
import java.util.*;

public class DistributedProcessingTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T=s.nextInt();
        int[] a = new int[T];
        int[] b = new int[T];
        int[] result = new int[T];
        for(int i=0;i<T;i++){
            a[i]=s.nextInt();
            b[i]=s.nextInt();
            result[i]=1;
        }
        for(int i=0;i<T;i++){
            for(int j=0;j<b[i];j++){
                result[i]=(result[i]*a[i])%10;
            }
        }
        for(int i=0;i<T;i++){
            if(result[i]!=0) System.out.println(result[i]);
            else System.out.println("10");
        }
    }
}
