package CodingTestSilver.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSAndBFS1260 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static String dfsResult = "";
    public static String bfsResult = "";
    
    public static void dfs(int x){
        visited[x]=true;
        dfsResult += x+" ";
        for(int i=0;i<graph.get(x).size();i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                dfs(y);
            }
        }
    }

    public static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()){
            int y = queue.poll();
            bfsResult+=y+" ";
            for(int i=0;i<graph.get(y).size();i++){
                int z = graph.get(y).get(i);
                if(!visited[z]){
                    queue.add(z);
                    visited[z] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);

        }
        for(int i=0;i<graph.size();i++){
            Collections.sort(graph.get(i));
        }
        visited = new boolean[n+1];
        dfs(v);
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }
}