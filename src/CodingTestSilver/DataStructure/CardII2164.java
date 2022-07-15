package CodingTestSilver.DataStructure;

import java.util.*;
import java.io.*;

public class CardII2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.offer(i);
        }
        while(true) {
            if(queue.size()==1) break;
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}