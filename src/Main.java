import java.util.*;
import java.io.*;

public class Main{
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;
    public static int[] degree;
    public static int[] order;

    public static void bfs(int start) throws IOException {
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
        visited = new boolean[n + 1];
        degree = new int[n + 1];
        order = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
            degree[i] = -1;
        }
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        bfs(start);

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (long)order[i] * (long)degree[i];
        }
        System.out.println(sum);
    }
}