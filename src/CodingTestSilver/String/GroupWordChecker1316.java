package CodingTestSilver.String;
import java.util.Scanner;

public class GroupWordChecker1316 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int count = 0;
        String original;

        for(int i=0;i<N;i++){
            original = s.next();
            for(int j=0;j<26;j++){
                int k;
                int firstIndex = original.indexOf(j+'a');
                int lastIndex = original.lastIndexOf(j+'a');
                if(firstIndex != lastIndex){
                    String sub = original.substring(firstIndex, lastIndex+1);
                    for(k = 0;k<26;k++) {
                        if (k != j && sub.indexOf(k+'a')!=-1) {
                            count++;
                            break;
                        }
                    }
                    if(k < 26) break;
                }
            }
        }
        System.out.println(N-count);
    }
}