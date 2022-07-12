package CodingTestSilver.DynamicProgramming;

import java.io.*;
import java.util.*;

public class MakingOne1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);

        for(int i=2;i<=n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            if(i%2 == 0){
                if(map.containsKey(i/2)){
                    list.add(map.get(i/2));
                }
            }
            if(i%3==0){
                if(map.containsKey(i/3)){
                    list.add(map.get(i/3));
                }
            }
            if(map.containsKey(i-1)){
                list.add(map.get(i-1));
            }
            map.put(i, Collections.min(list)+1);
        }
        System.out.println(map.get(n));
    }
}