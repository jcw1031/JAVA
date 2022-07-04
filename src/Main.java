import java.awt.desktop.AboutHandler;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Long, Long> map = new HashMap<>();

        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        System.out.println(array(n, p, q));
    }

    public static int array(long n, long p, long q){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(n<1){
            return 1;
        }
        else{
            return array(n/p, p, q)+array(n/q, p, q);
        }
    }
}