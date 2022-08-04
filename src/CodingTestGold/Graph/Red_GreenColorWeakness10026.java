package CodingTestGold.Graph;

import java.io.*;
import java.util.*;

public class Red_GreenColorWeakness10026 {
    public static int n;
    public static char[][] arr;
    public static boolean[][] visited;
    public static boolean[][] nVisited;
    public static int count = 0, nCount = 0;

    public static boolean dfs(int y, int x, char c){
        if(x<0 || x>=n || y<0 || y>=n){
            return false;
        }
        if(c == 'B'){
            if(arr[y][x] == c && !visited[y][x]){
                visited[y][x] = true;
                dfs(y, x+1, c);
                dfs(y, x-1, c);
                dfs(y+1, x, c);
                dfs(y-1, x, c);
                return true;
            }
        }
        else if(c == 'R' || c == 'G'){
            if((arr[y][x] == 'R' || arr[y][x] == 'G') && !visited[y][x]){
                visited[y][x] = true;
                dfs(y, x+1, c);
                dfs(y, x-1, c);
                dfs(y+1, x, c);
                dfs(y-1, x, c);
                return true;
            }
        }
        return false;
    }

    public static boolean nomalDfs(int y, int x, char c) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        if (arr[y][x] == c && !nVisited[y][x]) {
            nVisited[y][x] = true;
            nomalDfs(y, x + 1, c);
            nomalDfs(y, x - 1, c);
            nomalDfs(y + 1, x, c);
            nomalDfs(y - 1, x, c);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        nVisited = new boolean[n][n];

        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = tmp.charAt(j);
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i, j, arr[i][j]);
                    count++;
                }
                if(!nVisited[i][j]){
                    nomalDfs(i, j, arr[i][j]);
                    nCount++;
                }
            }
        }
        System.out.println(nCount+" "+count);
    }
}