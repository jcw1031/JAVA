package CodingTestGold.Graph;

import java.util.*;
import java.io.*;

public class DistanceBetweenNodes1240 {
    public static ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
    public static int[] parent;
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;

    public static void bfs(int start) {
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int key : list.get(tmp).keySet()){
                if(!visited[key]) {
                    queue.offer(key);
                    visited[key] = true;
                    parent[key] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        visited = new boolean[n+1];
        for(int i=0;i<n+1;i++){
            list.add(new HashMap<>());
        }
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).put(b, c);
            list.get(b).put(a, c);
        }

        bfs(1);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int findA = Integer.parseInt(st.nextToken());
            int findB = Integer.parseInt(st.nextToken());

            HashMap<Integer,Integer> parentListA = new HashMap<>();
            HashMap<Integer,Integer> parentListB = new HashMap<>();

            int tmp = findA;
            int input = 0;
            parentListA.put(findA, input);
            while(parent[tmp]!=0){
                input += list.get(tmp).get(parent[tmp]);
                parentListA.put(parent[tmp], input);
                tmp = parent[tmp];
                if(parent[tmp] == 0 ) break;
            }

            tmp = findB;
            input = 0;
            parentListB.put(findB, input);
            while(parent[tmp]!=0){
                input += list.get(tmp).get(parent[tmp]);
                parentListB.put(parent[tmp], input);
                tmp = parent[tmp];
                if(parent[tmp] == 0 ) break;
            }


            ArrayList<Integer> temp = new ArrayList<>();
            for(int key : parentListA.keySet()){
                if(parentListB.containsKey(key)){
                    temp.add(parentListA.get(key)+parentListB.get(key));
                }
            }
            bw.write(Collections.min(temp)+"\n");
        }
        bw.flush();
        bw.close();
    }
}