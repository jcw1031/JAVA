package CodingTestSilver.DataStructure;

import java.io.*;
import java.util.*;

public class StackSequence1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;
        int tmp = 1;

        while(true){
            if(a[i]>=tmp){
                for(;tmp<=a[i];tmp++){
                    stack.push(tmp);
                    sb.append('+').append('\n');
                }
            }
            else if(stack.peek()!=a[i]){
                System.out.println("NO");
                System.exit(0);
            }
            i++;
            stack.pop();
            sb.append('-').append('\n');
            if(i==n) break;
        }
        System.out.println(sb.toString());
    }
}
