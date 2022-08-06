package CodingTestGold.Graph;

import java.io.*;
import java.util.*;

public class DSLR9019 {
    public static Queue<String> queue;
    public static boolean[] visited;
    public static int b;
    public static String[] result;

    public static void bfs() {
        while(!queue.isEmpty()) {
            String tmp = queue.poll();

            if(tmp.length()<4){
                int ttt = tmp.length();
                for(int i=0;i<4-ttt;i++){
                    tmp="0"+tmp;
                }
            }

            String[] temp = new String[4];

            temp[0] = Integer.toString(Integer.parseInt(tmp) * 2);
            if (Integer.parseInt(temp[0]) > 9999) {
                temp[0] = Integer.toString(Integer.parseInt(temp[0]) % 10000);
            }
            //if(Integer.parseInt(temp[0]) == 0) temp[0] = "9999";

            temp[1] = Integer.toString(Integer.parseInt(tmp) - 1);
            if (Integer.parseInt(temp[1]) < 0) {
                temp[1] = "9999";
            }

            char sub = tmp.charAt(0);
            temp[2] = tmp.substring(1) + sub;

            sub = tmp.charAt(3);
            temp[3] = sub + tmp.substring(0, 3);

            if(!visited[Integer.parseInt(temp[0])]){
                result[Integer.parseInt(temp[0])] = result[Integer.parseInt(tmp)]+ "D";
                if(Integer.parseInt(temp[0]) == b) return;
                queue.add(temp[0]);
                visited[Integer.parseInt(temp[0])] = true;
            }
            if(!visited[Integer.parseInt(temp[1])]){
                result[Integer.parseInt(temp[1])] = result[Integer.parseInt(tmp)]+"S";
                if(Integer.parseInt(temp[1]) == b) return;
                queue.add(temp[1]);
                visited[Integer.parseInt(temp[1])] = true;
            }
            if(!visited[Integer.parseInt(temp[2])]){
                result[Integer.parseInt(temp[2])] = result[Integer.parseInt(tmp)]+"L";
                if(Integer.parseInt(temp[2]) == b) return;
                queue.add(temp[2]);
                visited[Integer.parseInt(temp[2])] = true;
            }
            if(!visited[Integer.parseInt(temp[3])]){
                result[Integer.parseInt(temp[3])] = result[Integer.parseInt(tmp)]+"R";
                if(Integer.parseInt(temp[3]) == b) return;
                queue.add(temp[3]);
                visited[Integer.parseInt(temp[3])] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            result = new String[10000];
            visited = new boolean[10000];
            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            b = Integer.parseInt(st.nextToken());

            queue.add(a);
            visited[Integer.parseInt(a)] = true;
            result[Integer.parseInt(a)] = "";
            bfs();

            bw.write(result[b]+"\n");
        }
        bw.flush();
        bw.close();
    }
}