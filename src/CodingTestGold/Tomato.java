package CodingTestGold;

import java.io.*;
import java.util.*;

public class Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] to = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                to[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        boolean end = false;

        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int flag = 0;
                    if(i>0&&to[i][j]==0&&to[i-1][j]==-1) flag++;
                    if(i<n-1&&to[i][j]==0&&to[i+1][j]==-1) flag++;
                    if(j>0&&to[i][j]==0&&to[i][j-1]==-1) flag++;
                    if(j<m-1&&to[i][j]==0&&to[i][j+1]==-1) flag++;
                    if ((i != 0 && i != n - 1 && j != 0 && j != m - 1) && flag == 4) {
                        System.out.println(-1);
                        System.exit(0);
                    } else if ((i == 0 || i == n - 1) && (j == 0 || j == m - 1) && flag == 2) {
                        System.out.println(-1);
                        System.exit(0);
                    } else if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && flag == 3) {
                        System.out.println(-1);
                        System.exit(0);
                    }

                    if(to[i][j]==1){
                        if(i>0&&to[i-1][j] == 0) to[i-1][j]=1;
                    }

                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (to[i][j] == 0) end = false;
                }
            }
        } while (end);
        System.out.println(count);
    }
}