package CodingTestSilver.Greedy;

import java.util.*;
import java.io.*;

public class MeetingRoomAssignment1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        int count = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0]-o2[0];
            else{
                return o1[1]-o2[1];
            }
        });
        int end = time[0][1];
        for(int i=1;i<n;i++){
            if(time[i][0]>=end) {
                end = time[i][1];
                count++;
            }
        }
        System.out.println(count+1);
    }
}
