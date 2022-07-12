package CodingTestSilver.Graph;

import java.util.*;
import java.io.*;

public class FindParentOfTree11725 {
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    //public static HashMap<Integer, Integer> parent = new HashMap<>();
    public static boolean[] visited;
    public static int[] parent;

    public static void bfs(){
        queue.offer(1);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            for(int i=0;i<list.get(tmp).size();i++){
                int tmp2 = list.get(tmp).get(i);
                if(!visited[tmp2] && !queue.contains(tmp2) ){
                    //parent.put(tmp2, tmp);
                    parent[tmp2] = tmp;
                    queue.offer(tmp2);
                }
            }
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        for(int i=0;i<list.get(start).size();i++){
            int tmp = list.get(start).get(i);
            if(!visited[tmp]){
                parent[tmp] = start;
                dfs(tmp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        visited = new boolean[n+1];
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        //bfs();
        dfs(1);

        for(int i=2;i<=n;i++){
            //System.out.println(parent.get(i));
            bw.write(parent[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}