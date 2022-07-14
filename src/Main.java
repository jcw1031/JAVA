import java.util.*;
import java.io.*;

public class Main{
    public static ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;
    public static int[] degree;
    public static int[] order;

    public static void bfs(int start) {
        queue.offer(start);
        visited[start] = true;
        degree[start] = 0;
        int count = 1;
        order[start] = count++;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i=0;i<list.get(tmp).size();i++){
                int tmp2 = list.get(tmp).get(i);
                if(!visited[tmp2]){
                    queue.offer(tmp2);
                    visited[tmp2]=true;
                    degree[tmp2] = degree[tmp]+1;
                    order[tmp2] = count++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n+1;i++){
            list.add(new HashMap<>());
        }
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).put(b, c);
            list.get(b).put(a, c);
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());


        }
    }
}