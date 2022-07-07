import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double d = Double.parseDouble(st.nextToken());
        double hr = Double.parseDouble(st.nextToken());
        double wr = Double.parseDouble(st.nextToken());

        double dr = Math.sqrt(Math.pow(hr, 2)+Math.pow(wr, 2));

        double h = d*hr/dr;
        double w = d*wr/dr;
        System.out.println((int)h + " "+(int)w);
    }
}