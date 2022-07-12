package CodingTestSilver.DynamicProgramming;

import java.io.*;
import java.util.*;

public class FibonacciFunction1003 {
    static HashMap<Integer, Integer> mapZero = new LinkedHashMap<>();
    static HashMap<Integer, Integer> mapOne = new LinkedHashMap<>();
    static StringTokenizer st;
    static int countZero;
    static int countOne;

    public static int fibonacciZero(int n){
        if(mapZero.containsKey(n)) return mapZero.get(n);
        mapZero.put(n, fibonacciZero(n-1)+fibonacciZero(n-2));
        return mapZero.get(n);
    }

    public static int fibonacciOne(int n){
        if(mapOne.containsKey(n)) return mapOne.get(n);
        mapOne.put(n, fibonacciOne(n-1)+fibonacciOne(n-2));
        return mapOne.get(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int in;
        mapZero.put(0, 1);
        mapZero.put(1, 0);
        mapOne.put(0, 0);
        mapOne.put(1, 1);

        for(int i=0;i<t;i++){
            countZero = 0;
            countOne = 0;
            in=Integer.parseInt(br.readLine());
            System.out.println(fibonacciZero(in)+" "+fibonacciOne(in));
        }
    }
}