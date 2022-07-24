import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();

        while(n-->0){
            String name = br.readLine();
            map.put(name, 0);
        }

        ArrayList<String> list = new ArrayList<>();
        while(m-->0){
            String name = br.readLine();
            if(map.containsKey(name)){
                list.add(name);
            }
            //map.put(name, map.getOrDefault(name, -1)+1);

            /*if(list.contains(name)){
                count++;
                bw.write(name+"\n");
            }*/
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            bw.write(list.get(i)+"\n");
        }
        bw.flush();
        bw.close();
    }
}