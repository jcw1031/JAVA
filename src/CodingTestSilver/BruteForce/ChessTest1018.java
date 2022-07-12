package CodingTestSilver.BruteForce;

import java.io.*;
import java.util.*;

public class ChessTest1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] countB = new int[n - 8 + 1][m - 8 + 1];
        int[][] countW = new int[n - 8 + 1][m - 8 + 1];

        char[][] board = new char[n][m];
        String[] tmp = new String[n];

        for (int i = 0; i < n; i++) {
            tmp[i] = br.readLine();
        }
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[i].charAt(j);
            }
        }

        boolean flag = true; //true일 때 Black  B로 시작
        HashMap<Boolean, Character> map = new HashMap<>();
        map.put(true, 'B');
        map.put(false, 'W');
        int minRowB=0;
        int minColumnB=0;
        int minRowW=0;
        int minColumnW=0;
        int min =100000;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (!map.get(flag).equals(board[k][l])) {
                            countB[i][j]++;
                        }
                        if (l != j + 8 - 1)
                            flag = !flag;
                    }
                }
                if(min>countB[i][j]){
                    min=countB[i][j];
                    minRowB=i;
                    minColumnB=j;
                }
            }
        }

        min = 100000;

        flag = false; //W로 시작
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (!map.get(flag).equals(board[k][l])) {
                            countW[i][j]++;
                        }
                        if (l != j + 8 - 1)
                            flag = !flag;
                    }
                }
                if(min>countW[i][j]){
                    min=countW[i][j];
                    minRowW=i;
                    minColumnW=j;
                }
            }
        }
        System.out.println(countB[minRowB][minColumnB]>countW[minRowW][minColumnW]?countW[minRowW][minColumnW]:countB[minRowB][minColumnB]);
    }
}