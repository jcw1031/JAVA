package CodingTestSilver.Graph;

import java.io.*;
import java.util.*;

public class HideAndSeek1697 {
    public static int n, k;
    public static int[] count = new int[100001];
    public static boolean[] visited = new boolean[100001];
    public static Queue<Integer> queue = new LinkedList<>();

    public static int bfs() {
        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            if (tmp == k) return count[k];

            int[] a = new int[3];
            a[0] = tmp - 1;
            a[1] = tmp + 1;
            a[2] = tmp * 2;

            for (int i = 0; i < 3; i++) {
                if (a[i]>=0 && a[i]<=100000 && !visited[a[i]] ) {
                    count[a[i]] = count[tmp] + 1;
                    queue.add(a[i]);
                    visited[a[i]] = true;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        queue.add(n);
        visited[n] = true;
        int result = bfs();

        System.out.println(result);
    }
}