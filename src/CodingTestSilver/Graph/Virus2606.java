package CodingTestSilver.Graph;

import java.util.*;
import java.io.*;

public class Virus2606{
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;

    public static void bfs(){
        int tmp = 0;
        if(!queue.isEmpty())
            tmp = queue.poll();
        else return;

        if(visited[tmp]){
            bfs();
            return;
        }
        visited[tmp] = true;

        for(int i=0;i<list.get(tmp).size();i++){
            queue.add(list.get(tmp).get(i));
        }
        if(!queue.isEmpty()){
            bfs();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //number of node
        int m = Integer.parseInt(br.readLine()); //number of link
        visited = new boolean[n+1];

        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        queue.add(1);
        bfs();

        int count = 0;
        for(int i=0;i<n+1;i++){
            if(visited[i]) count++;
        }
        System.out.println(count-1);
    }
}