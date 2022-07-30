package CodingTestSilver.DynamicProgramming;

import java.io.*;
import java.util.*;

public class DistanceOfRGB1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];
        int[][] result = new int[n][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        result[0][0] = rgb[0][0];
        result[0][1] = rgb[0][1];
        result[0][2] = rgb[0][2];

        for(int i=1;i<n;i++){
            result[i][0] = (result[i-1][1]>result[i-1][2]?result[i-1][2]:result[i-1][1])+rgb[i][0];
            result[i][1] = (result[i-1][0]>result[i-1][2]?result[i-1][2]:result[i-1][0])+rgb[i][1];
            result[i][2] = (result[i-1][0]>result[i-1][1]?result[i-1][1]:result[i-1][0])+rgb[i][2];
        }

        int min = result[n-1][0];
        for(int i=1;i<3;i++){
            if(min>result[n-1][i]) min = result[n-1][i];
        }
        System.out.println(min);
    }
}