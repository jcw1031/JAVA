package CodingTestSilver.DynamicProgramming;

import java.io.*;
import java.util.*;

public class ClimbingStairs2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            score[i]=Integer.parseInt(br.readLine());
        }
        map.put(1, score[0]);
        if(n>1)
            map.put(2, score[0]+score[1]);
        if(n>2)
            map.put(3, ((score[0]<score[1])?score[1]:score[0])+score[2]);

        for(int i=4;i<=n;i++){
            int tmp1 = map.get(i-3)+score[i-1-1]+score[i-1];
            int tmp2 = map.get(i-2)+score[i-1];
            if((tmp1) < (tmp2)){
                map.put(i, tmp2);
            }
            else{
                map.put(i, tmp1);
            }
        }
        System.out.println(map.get(n));
    }
}