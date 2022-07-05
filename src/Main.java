import java.io.*;
import java.util.*;

class Value{
    String key;
    int value1, value2;

    public Value(String key, int value1, int value2){
        this.key=key;
        this.value1 = value1;
        this.value2 = value2;
    }
}

public class Main{
    static HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map.put(0, 0);
        map.put(1, 0);
        int t = Integer.parseInt(br.readLine());
        int in;
        for(int i=0;i<t;i++){
            in=Integer.parseInt(br.readLine());
            fibonacci(in);
        }
    }
}