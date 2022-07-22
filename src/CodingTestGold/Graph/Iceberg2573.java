package CodingTestGold.Graph;

import java.io.*;
import java.util.*;

public class Iceberg2573 {
    public static int[][] iceberg;
    public static int[][] tmp;
    public static boolean[][] visited;
    public static int icebergCount = 0;
    public static int count = 0;
    public static int n, m;

    public static boolean dfs(int y, int x){
        if(x<0 || x>=m || y<0 || y>=n){
            return false;
        }
        if(iceberg[y][x] !=0 && !visited[y][x]){
            visited[y][x] = true;

            if(dfs(y, x-1)) tmp[y][x]--;
            if(dfs(y-1, x)) tmp[y][x]--;
            if(dfs(y+1, x)) tmp[y][x]--;
            if(dfs(y, x+1)) tmp[y][x]--;
            return false;
        }
        if(iceberg[y][x] == 0)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        iceberg = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            icebergCount = 0;
            visited = new boolean[n][m];
            tmp = new int[n][m];

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(iceberg[i][j] !=0 && !visited[i][j]){
                        icebergCount++;
                        dfs(i, j);
                    }
                }
            }
            if(icebergCount == 0) {
                System.out.println(0);
                System.exit(0);
            }
            if(icebergCount >= 2) break;

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    iceberg[i][j] += tmp[i][j];
                    if(iceberg[i][j]<0) iceberg[i][j] = 0;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}