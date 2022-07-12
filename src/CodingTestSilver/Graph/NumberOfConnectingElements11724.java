package CodingTestSilver.Graph;

import java.util.*;
import java.io.*;

public class NumberOfConnectingElements11724 {
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;

    public static void bfs(){
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            for(int i=0;i<list.get(tmp).size();i++){
                int tmp2 = list.get(tmp).get(i);
                if(!visited[tmp2] && !queue.contains(tmp2) ){
                    queue.offer(tmp2);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        int count = 0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                queue.offer(i);
                bfs();
                count++;
            }
        }
        System.out.println(count);
    }
}