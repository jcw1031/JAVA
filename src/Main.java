import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

       st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       int[][] arr = new int[n][n];

       for(int i=0;i<n;i++){
           int tmp = 0;
           st = new StringTokenizer(br.readLine());
           for(int j=0;j<n;j++){
               tmp+=Integer.parseInt(st.nextToken());
               arr[i][j] = tmp;
           }
       }

       while(m-->0){
           st = new StringTokenizer(br.readLine());
           int x1 = Integer.parseInt(st.nextToken());
           int y1 = Integer.parseInt(st.nextToken());
           int x2 = Integer.parseInt(st.nextToken());
           int y2 = Integer.parseInt(st.nextToken());

           int sum = 0;

           for(int i=x1-1;i<=x2-1;i++){
               if(y1==1){
                   sum+=arr[i][y2-1];
               }
               else{
                   sum+=(arr[i][y2-1] - arr[i][y1-2]);
               }
           }

           bw.write(sum+"\n");
       }
       bw.flush();
       bw.close();
    }
}