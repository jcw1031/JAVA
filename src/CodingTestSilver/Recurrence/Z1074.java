package CodingTestSilver.Recurrence;

import java.io.*;
import java.util.*;

public class Z1074 {
    public static int n, r, c;
    public static int count = 0;

    public static void z(int sY, int sX, int eY, int eX){
        if(sY!=eY && sX!=eX) {
            if (sY <= r && sX <= c && (sY + eY) / 2 >= r && (sX + eX) / 2 >= c) {
                z(sY, sX, (sY + eY) / 2, (sX + eX) / 2);
            } else if (sY <= r && (sX + eX) / 2 + 1 <= c && (sY + eY) / 2 >= r && eX >= c) {
                count += Math.pow(((eY - sY) / 2 + 1), 2) * 1;
                z(sY, (sX+eX)/2+1, (sY+eY)/2, eX);
            } else if ((sY + eY) / 2 + 1 <= r && sX <= c && eY >= r && (sX + eX) / 2 >= c) {
                count += Math.pow(((eY - sY) / 2 + 1), 2) * 2;
                z((sY+eY)/2+1, sX, eY, (sX+eX)/2);
            } else if ((sY + eY) / 2 + 1 <= r && (sX + eX) / 2 + 1 <= c && eY >= r && eX >= c) {
                count += Math.pow(((eY - sY) / 2 + 1), 2) * 3;
                z((sY+eY)/2+1, (sX+eX)/2+1, eY, eX);
            }
        }
        else{
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        z(0, 0, n-1, n-1);

        System.out.println(count);
    }
}