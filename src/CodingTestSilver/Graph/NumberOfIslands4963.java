package CodingTestSilver.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberOfIslands4963 {
    public static int h, w;
    public static int[][] map;

    public static boolean dfs(int y, int x){
        if(x<0 || x>=w || y<0 || y>=h){
            return false;
        }
        if(map[y][x] == 1){
            map[y][x]=0;

            dfs(y-1, x);
            dfs(y+1, x);
            dfs(y, x-1);
            dfs(y, x+1);
            dfs(y-1, x-1);
            dfs(y+1, x-1);
            dfs(y-1, x+1);
            dfs(y+1, x+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            w=Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == h && w ==0) break;
            map = new int[h][w];
            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(map[i][j] == 1){
                        if(dfs(i, j)){
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}