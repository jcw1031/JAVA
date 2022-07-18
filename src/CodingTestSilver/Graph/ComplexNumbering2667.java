package CodingTestSilver.Graph;

import java.util.*;
import java.io.*;

public class ComplexNumbering2667 {
    public static Queue<int[]> queue = new LinkedList<>();
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int n;
    public static int[][] map;
    public static int[] tmp = new int[2];
    public static int i = 0;

    public static void bfs(int x, int y){
        queue.add(new int[] {x, y});
        list.add(0);
        while(!queue.isEmpty()){
            tmp = queue.poll();
            map[tmp[1]][tmp[0]] =0;
            int temp = list.remove(i);
            list.add(temp+1);
            set(tmp[0]+1, tmp[1]);
            set(tmp[0]-1, tmp[1]);
            set(tmp[0], tmp[1]+1);
            set(tmp[0], tmp[1]-1);
        }
        i++;
    }

    public static void set(int x, int y){
        if(x<0 || x>=n || y<0 || y>=n){
            return;
        }
        if(map[y][x]==1){
            queue.add(new int[] {x, y});
            map[y][x] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 1){
                    bfs(j, i);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
