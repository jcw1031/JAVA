package CodingTestSilver.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistanceOfRGB1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] value = new int[n][3];
        ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new HashMap<>());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                list.get(i).put(j, Integer.parseInt(st.nextToken()));
            }
        }

        value[0][0] = list.get(0).get(0);
        value[0][1] = list.get(0).get(1);
        value[0][2] = list.get(0).get(2);

        int first;
        int second;
        int third;
        int min = value[0][0];
        for(int i=1;i<3;i++){
            //if(min)
        }
        for(int i=1;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){

            }
        }
    }
}