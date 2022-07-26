import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> name = new HashMap<>();
        HashMap<Integer, String> num = new HashMap<>();

        for(int i=1;i<=n;i++){
            String tmp = br.readLine();
            name.put(tmp, i);
            num.put(i, tmp);
        }

        while(m-->0){
            String search = br.readLine();
            if(Character.isDigit(search.charAt(0))){
                bw.write(num.get(Integer.parseInt(search))+"\n");
            }
            else{
                bw.write(name.get(search)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}