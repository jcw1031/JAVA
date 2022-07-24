package CodingTestGold.DataStructure;

import java.io.*;
import java.util.*;

public class DualPriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            //PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
            //PriorityQueue<Integer> minPq = new PriorityQueue<>();
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                switch (op) {
                    case "I": {
                        int x = Integer.parseInt(st.nextToken());
                        //maxPq.add(x);
                        //minPq.add(x);
                        tm.put(x, tm.getOrDefault(x, 0)+1);
                        break;
                    }
                    case "D" : {
                        if(!tm.isEmpty()) {
                            int x = Integer.parseInt(st.nextToken());
                            if (x > 0) {
                                //minPq.remove(maxPq.poll());
                                tm.put(tm.lastKey(), tm.get(tm.lastKey())-1);
                                if(tm.get(tm.lastKey()) == 0)
                                    tm.remove(tm.lastKey());
                            }
                            else {
                                //maxPq.remove(minPq.poll());
                                tm.put(tm.firstKey(), tm.get(tm.firstKey())-1);
                                if(tm.get(tm.firstKey()) == 0)
                                    tm.remove(tm.firstKey());
                            }
                        }
                        break;
                    }
                }
            }
            if(tm.isEmpty()) bw.write("EMPTY\n");
            else{
                //bw.write(maxPq.poll()+" "+minPq.poll()+"\n");
                bw.write(tm.lastKey()+" "+tm.firstKey()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}