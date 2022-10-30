package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        dp[0] = 1;
        if(n >= 1) {
            dp[1] = 1;
        }

        System.out.println(fibonacci(n));

    }

    public static int fibonacci(int n) {
        if (n < 2) {

            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = fibonacci(n-2) + fibonacci(n-1);
            return dp[n];
        }
    }
}
