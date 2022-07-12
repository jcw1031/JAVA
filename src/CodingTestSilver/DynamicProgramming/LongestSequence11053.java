package CodingTestSilver.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class LongestSequence11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] count = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        int max;
        boolean flag;
        for(int i=0;i<n-1;i++){
            max = 0;
            flag = false;
            for(int j=0;j<i+1;j++){
                if(a[i+1]>a[j]){
                    if(count[max]<count[j]) max=j;
                    flag = true;
                }
            }
            if(flag==true)
                count[i+1]=count[max]+1;
        }
        Arrays.sort(count);
        System.out.println(count[n-1]+1);
    }
}
