package CodingTestSilver.Recurrence;

import java.io.*;
import java.util.*;

public class MakingColoredPaper {
    public static int blue = 0;
    public static int white = 0;
    public static int[][] arr;
    public static double tmp = 0.5;
    public static int n;
    public static void makePaper(int startX, int startY, int endX, int endY){

        tmp*=2;

        if((int)tmp == n){
            if(arr[startY][startX] == 0) white++;
            else blue++;
            tmp/=2;
            return;
        }

        if(arr[startY][startX] == 0){
            for(int i=startY;i<=endY;i++){
                for(int j=startX;j<=endX;j++){
                    if(arr[i][j] == 1){
                        makePaper(startX, startY, (startX+endX)/2, (startY+endY)/2);
                        makePaper((startX+endX)/2+1, startY, endX, (startY+endY)/2);
                        makePaper(startX, (startY+endY)/2+1, (startX+endX)/2, endY);
                        makePaper((startX+endX)/2+1, (startY+endY)/2+1, endX, endY);
                        tmp/=2;
                        return;
                    }
                }
            }
            tmp/=2;
            white++;
        }

        else{
            for(int i=startY;i<=endY;i++){
                for(int j=startX;j<=endX;j++){
                    if(arr[i][j] == 0){
                        makePaper(startX, startY, (startX+endX)/2, (startY+endY)/2);
                        makePaper((startX+endX)/2+1, startY, endX, (startY+endY)/2);
                        makePaper(startX, (startY+endY)/2+1, (startX+endX)/2, endY);
                        makePaper((startX+endX)/2+1, (startY+endY)/2+1, endX, endY);
                        tmp/=2;
                        return;
                    }
                }
            }
            tmp/=2;
            blue++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makePaper(0, 0, n-1, n-1);

        System.out.println(white);
        System.out.println(blue);
    }
}