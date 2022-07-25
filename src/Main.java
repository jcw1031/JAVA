import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
            map.put(list.get(i), 0);
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        for(int key : map.keySet()){
            tmp.add(key);
        }
        Collections.sort(tmp);

        for(int i=0;i<tmp.size();i++){
            map.put(tmp.get(i), i);
        }

        for(int i=0;i<list.size();i++){
            bw.write(map.get(list.get(i))+" ");
        }
        bw.flush();
        bw.close();
    }
}