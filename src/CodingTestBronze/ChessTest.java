package CodingTestBronze;

import java.util.*;

public class ChessTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int column = s.nextInt();

        String[] color = new String[row];

        for (int i = 0; i < color.length; i++) {
            color[i] = s.next();
        }

        for(int i=0;i<color.length;i++){
            color[i]=color[i].substring(0, 8);
        }
    }
}