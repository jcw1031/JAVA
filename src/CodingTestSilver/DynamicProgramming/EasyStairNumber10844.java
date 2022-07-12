package CodingTestSilver.DynamicProgramming;

import java.io.*;
import java.util.*;

public class EasyStairNumber10844 {
    final static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, (long)0);
        for(int i=1;i<10;i++){
            map.put(i, (long)1);
        }

        for(int i=0;i<n-1;i++){
            long[] a = new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for(int j=0;j<map.size();j++){
                if(j+1<10){
                    a[j]+=map.get(j+1)%MOD;
                }
                if(j-1>=0){
                    a[j]+=map.get(j-1)%MOD;
                }
            }
            for(int j=0;j<10;j++){
                map.put(j, a[j]);
            }
        }
        long sum=0;
        for(int key : map.keySet()){
            sum+=map.get(key);
        }
        System.out.println(sum%MOD);
    }
}