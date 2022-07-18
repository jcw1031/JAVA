import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        long[] p = new long[101];
        p[1] = p[2] = p[3] = 1;
        p[4] = p[5] = 2;
        p[6] = 3;
        p[7] = 4;
        p[8] = 5;
        p[9] = 7;
        p[10] = 9;

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            for(int j=11;j<=n;j++){
                p[j] = p[j-1]+p[j-5];
            }
            System.out.println(p[n]);
        }
    }
}