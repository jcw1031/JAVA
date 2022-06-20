package CodingTestBronze;
import java.util.*;

public class CmdTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N=s.nextInt();
        String[] cmd = new String[N];
        String out="";

        for(int i=0;i<cmd.length;i++) {
            cmd[i] = s.next();
        }
        char c;
        int j=0;
        for(int i=0;i<cmd[0].length();i++){
            c=cmd[0].charAt(i);
            for(j=1;j<cmd.length;j++){
                if(c==cmd[j].charAt(i)){
                    c=cmd[j].charAt(i);
                }
                else{
                    c='?';
                }
            }
            out+=c;
        }

        System.out.println(out);
    }

}
