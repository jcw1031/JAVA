package CodingTestGold.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tomato7569 {
    public static int n, m, h;
    public static int[][][] tomato;
    public static Queue<int[]> queue = new LinkedList<>();
    public static int[] tmp = new int[3];

    public static void bfs() {
        while (!queue.isEmpty()) {
            tmp = queue.poll();

            set(tmp[0], tmp[1] + 1, tmp[2]);
            set(tmp[0], tmp[1] - 1, tmp[2]);
            set(tmp[0] + 1, tmp[1], tmp[2]);
            set(tmp[0] - 1, tmp[1], tmp[2]);
            set(tmp[0], tmp[1], tmp[2]+1);
            set(tmp[0], tmp[1], tmp[2]-1);
        }
    }

    public static boolean set(int z, int y, int x) {
        if (x < 0 || x >= m || y < 0 || y >= n || z<0 || z>=h) {
            return false;
        }
        if (tomato[z][y][x] == 0) {
            tomato[z][y][x] = tomato[tmp[0]][tmp[1]][tmp[2]] + 1;
            queue.add(new int[]{z, y, x});
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomato = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 1) queue.add(new int[]{i, j, k});
                }
            }
        }

        bfs();

        boolean end = true;
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 0) {
                        end = false;
                    }
                    if (result < tomato[i][j][k]) result = tomato[i][j][k];
                }
            }
        }

        if (end) {
            System.out.println(result-1);
        } else {
            System.out.println(-1);
        }
    }
}