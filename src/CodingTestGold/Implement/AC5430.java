package CodingTestGold.Implement;

import java.util.*;
import java.io.*;

public class AC5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (; t > 0; t--) {
            boolean flag = true;
            String op = br.readLine();
            int size = Integer.parseInt(br.readLine());
            //String sequence = br.readLine();
            st = new StringTokenizer(br.readLine(), "[],");

            //sequence = sequence.substring(1, sequence.length() - 1);
            //String[] arr = sequence.split(",");

            ArrayList<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            try {
                int pointer = 0;
                for (int i = 0; i < op.length(); i++) {
                    if (!flag) break;
                    switch (op.charAt(i)) {
                        case 'R': {
                            if (pointer == 0) {
                                pointer = list.size() - 1;
                            } else {
                                pointer = 0;
                            }
                            break;
                        }
                        case 'D': {
                            if(list.size()==0) throw new Exception();
                            list.remove(pointer);
                            if (pointer != 0) {
                                pointer--;
                            }
                            break;
                        }
                    }
                }
                if (pointer != 0) {
                    Collections.reverse(list);
                }
                bw.write("[");
                for(int i=0;i<list.size()-1;i++){
                    bw.write(list.get(i)+",");
                }
                if(list.size()!=0) bw.write(""+list.get(list.size()-1));
                bw.write("]\n");
                bw.flush();
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}