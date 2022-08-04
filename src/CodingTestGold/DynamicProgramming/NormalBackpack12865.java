package CodingTestGold.DynamicProgramming;

import java.io.*;
import java.util.*;

public class NormalBackpack12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        int[] w = new int[n+1];
        int[] v = new int[n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<=k;i++){ //무게
            for(int j=1;j<=n;j++){ //물건 index
                if(w[j] <= i){
                    if(dp[j-1][i] < v[j]+dp[j-1][i-w[j]]){
                        dp[j][i] = v[j]+dp[j-1][i-w[j]];
                    }
                    else{
                        dp[j][i] = dp[j-1][i];
                    }
                }
                else{
                    dp[j][i] = dp[j-1][i];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}