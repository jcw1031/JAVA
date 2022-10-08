import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sample{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dp = new int[6][6];

        for(int i=1;i<=5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=5;j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1;k<=5;k++){
            for(int i=1;i<=5;i++){
                if(i!=k){
                    for(int j=1;j<=5;j++){
                        if(j!=k && j!=i){
                            dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                        }
                    }
                }
            }
        }

        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
    }
}