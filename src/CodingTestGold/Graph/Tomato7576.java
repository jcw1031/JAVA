package CodingTestGold.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tomato7576 {
    public static int h, w;
    public static int[][] tomato;
    public static Queue<int[]> queue = new LinkedList<>();
    public static int[][] count;
    public static int[] tt = new int[2];

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            tt[0] = tmp[0];
            tt[1] = tmp[1];
            set(tmp[0], tmp[1] + 1);
            set(tmp[0], tmp[1] - 1);
            set(tmp[0] + 1, tmp[1]);
            set(tmp[0] - 1, tmp[1]);
        }
    }

    public static boolean set(int y, int x) {
        if (x < 0 || x >= w || y < 0 || y >= h) {
            return false;
        }
        if (tomato[y][x] == 0) {
            tomato[y][x] = 1;
            count[y][x] = count[tt[0]][tt[1]] + 1;
            queue.add(new int[]{y, x});
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomato = new int[h][w];
        count = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (tomato[i][j] == 1) queue.add(new int[]{i, j});
            }
        }

        bfs();

        boolean end = true;
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (tomato[i][j] == 0) {
                    end = false;
                }
                if (result < count[i][j]) result = count[i][j];
            }
        }

        if (end) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}