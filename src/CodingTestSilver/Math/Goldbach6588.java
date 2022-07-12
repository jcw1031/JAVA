package CodingTestSilver.Math;
import java.util.Scanner;

public class Goldbach6588 {
    public static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i;
        boolean[] primeNum = new boolean[MAX+1];
        for(i=2;i<MAX/2+1;i++){
            for(int j=i*2;j<MAX+1;j+=i){
                primeNum[j]=true;
            }
        }

        while(true){
            int input = s.nextInt();
            boolean flag = false;
            if(input == 0 ) break;
            for(i=3;i<(input/2);i++){
                if(!primeNum[i]&&!primeNum[(input-i)]){
                    System.out.println(input+" = "+i+" + "+(input-i));
                    flag = true;
                    break;
                }
            }
            if(!flag) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}