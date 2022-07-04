package CodingTestBronze;
import java.util.*;

public class WordStudy {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] count = new int['Z'-'A'+1];
        String input = s.next();
        String convert = input.toUpperCase();

        for(int i=0;i<count.length;i++){
            count[i]=0;
        }

        for(int i=0;i<convert.length();i++){
            if(convert.charAt(i) < 'A') System.exit(0);
            int index = convert.charAt(i)-'A';
            count[index]++;
        }
        int[] tmp = new int[count.length];
        for(int i=0;i<count.length;i++){
            tmp[i]=count[i];
        }

        for(int i=0;i<tmp.length-1;i++){
            for(int j=i+1;j<tmp.length;j++){
                if(tmp[i]<tmp[j]){
                    int tt = tmp[j];
                    tmp[j]=tmp[i];
                    tmp[i]=tt;
                }
            }
        }

        if(tmp[0]==tmp[1]) System.out.print("?");
        else{
            int max =0;
            char out = 'A';
            for(int i=0;i<26;i++){
                if(max<count[i]){
                    max=count[i];
                    out = (char)(i+'A');
                }
            }
            System.out.print(out);
        }
    }
}