package CodingTestGold.DynamicProgramming;

import java.io.*;
import java.util.*;

public class InfinitySequence1351 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long n;
    static long p;
    static long q;

    static HashMap<Long, Long> map = new HashMap<>();
    public static long pq(long i) throws IOException {
        if(map.containsKey(i)) return map.get(i);
        map.put(i, pq(i/p)+pq(i/q));
        return map.get(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        map.put((long)0, (long)1);
        System.out.println(pq(n));



        //System.out.println(array(n, p, q));
    }

    /*public static int array(long n, long p, long q){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(n<1){
            return 1;
        }
        else{
            return array(n/p, p, q)+array(n/q, p, q);
        }
        }
     */
}

