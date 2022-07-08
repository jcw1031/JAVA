package CodingTestGold;
/* DFS, BFS 함수 + 재귀함수를
    이용해서 해보기
                */

import java.io.*;
import java.util.*;

public class Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] to = new int[n][m];
        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                to[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        boolean flag2 = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(to[i][j]==0){
                    if(i>0){
                        switch(to[i-1][j]){
                            case 1 : {
                                flag2=true;
                                break;
                            }
                            case -1 : {

                            }
                        }
                    }
                }
            }
        }








        System.out.println(count);
    }
}