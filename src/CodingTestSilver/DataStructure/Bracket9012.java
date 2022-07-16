package CodingTestSilver.DataStructure;

import java.util.*;
import java.io.*;

public class Bracket9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            boolean flag = true;
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    stack.push(input.charAt(j));
                } else {
                    if (!stack.isEmpty())
                        stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && stack.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}