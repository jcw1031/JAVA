package CodingTestSilver.Graph;

import java.io.*;
import java.util.*;

public class OrganicCabbage1012{
    public static int n, m;
    public static int[][] field;
    public static boolean[][] visited;

    public static void dfs(int x, int y){
        if(x<0 || x>=m || y<0 || y>=n || field[y][x]!=1 || visited[y][x])
            return;

        visited[y][x] = true;

        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y+1);
        dfs(x, y-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            field = new int[n][m];
            visited = new boolean[n][m];

            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            int count = 0;
            for(int j=0;j<n;j++){
                for(int l=0;l<m;l++){
                    if(field[j][l] == 1 && !visited[j][l]){
                        dfs(l, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}