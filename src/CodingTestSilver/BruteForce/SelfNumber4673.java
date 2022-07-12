package CodingTestSilver.BruteForce;

public class SelfNumber4673 {
    public static void main(String[] args) {
        boolean[] selfNum = new boolean[10000];
        int result, tmp;
        for(int i=1;i<10000;i++){
            result=i;
            tmp=i;
            while(true){
                result+=tmp%10;
                tmp/=10;
                if(tmp==0) break;
            }
            if(result<10000) selfNum[result]=true;
        }
        for(int i=1;i<10000;i++){
            if(!selfNum[i] == true){
                System.out.println(i);
            }
        }
    }
}
