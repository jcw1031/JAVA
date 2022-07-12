package CodingTestSilver.Graph;

import java.io.*;
import java.util.*;

public class DegreesCaculation2644 {
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static HashMap<Integer, Integer> distanceA = new HashMap<>();
    public static HashMap<Integer, Integer> distanceB = new HashMap<>();

    public static int dfs(int a, int b){
        distanceA.put(a, 0);
        int tt = a;
        int tmp = a;
        while(true){
            if(list.get(tmp).isEmpty()) break;
            tmp = list.get(tmp).get(0);
            distanceA.put(tmp, distanceA.get(tt)+1);
            tt = tmp;
        }
        distanceB.put(b, 0);
        tt = b;
        tmp = b;
        while(true){
            if(list.get(tmp).isEmpty()) break;
            tmp = list.get(tmp).get(0);
            distanceB.put(tmp, distanceB.get(tt)+1);
            tt = tmp;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for(int key : distanceA.keySet()){
            if(distanceB.containsKey(key)){
                temp.add(distanceA.get(key)+distanceB.get(key));
            }
        }
        if(temp.isEmpty()) return -1;
        int min = Collections.min(temp);
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int findA = Integer.parseInt(st.nextToken());
        int findB = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(b).add(a);
        }

        int min = dfs(findA, findB);

        if (min == -1) System.out.println(-1);
        else System.out.println(min);
    }
}
