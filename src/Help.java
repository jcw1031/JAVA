import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class binary{
    String bnum1, bnum2; //bnum1=길이가 더 김
    ArrayList<String> plusnum=new ArrayList<String>();
    int bnum1LastIndex,bnum2LastIndex, flag=0;

    public binary(String bnum1, String bnum2) {
        if(bnum1.length()>=bnum2.length()) {
            this.bnum1=bnum1;
            bnum1LastIndex=bnum1.length()-1;
            this.bnum2=bnum2;
            bnum2LastIndex=bnum2.length()-1;

        }
        else {
            this.bnum1=bnum2;
            bnum1LastIndex=bnum1.length()-1;
            this.bnum2=bnum1;
            bnum2LastIndex=bnum2.length()-1;
        }
        binaryplus();

    }
    public void binaryplus() {
        for(int i=0;i<=bnum2LastIndex;i++) { //bnum2의 길이만큼, 끝에서부터
            if(bnum1.charAt(bnum1LastIndex-i)=='1'&&bnum2.charAt(bnum2LastIndex-i)=='1') {// 1과 1일 경우
                if(flag==1) { //이 전에도 올림수 있을 때
                    plusnum.add(0,"1");
                    flag=1;
                }
                else{ //이 전에 올림수 없을 때
                    plusnum.add(0,"0");
                    flag=1;
                }
            }
            else if ((bnum1.charAt(bnum1LastIndex-i)=='1'&&bnum2.charAt(bnum2LastIndex-i)=='0')||
                    (bnum1.charAt(bnum1LastIndex-i)=='0'&&bnum2.charAt(bnum2LastIndex-i)=='1')){ //0과 1일경우
                if(flag==1) { //올림수 있을 때
                    plusnum.add(0,"0");
                    flag=1;
                }
                else {
                    plusnum.add(0,"1");
                    flag=0;
                }

            }
            else { //0과 0인경우
                if(flag==1) {
                    plusnum.add(0,"1");
                    flag=0;
                }
                else {
                    plusnum.add(0,"0");
                    flag=0;
                }
            }
        }
        if(bnum1LastIndex!=bnum2LastIndex) {
            for(int i=1;i<=bnum1LastIndex-bnum2LastIndex;i++){//길이 작은 수 끝나고 난 후
                char ange=bnum1.charAt(bnum1LastIndex-bnum2LastIndex-i);
                if(ange=='0') {
                    if(flag==1) {
                        plusnum.add(0,"1");
                        flag=0;
                    }
                    else {
                        plusnum.add(0,"0");
                        flag=0;
                    }
                }
                else { //1일때
                    if(flag==1) {
                        plusnum.add(0,"0");
                        flag=1;
                    }
                    else {
                        plusnum.add(0,"1");
                        flag=0;
                    }
                }
            }
        }
        if(flag==1) {
            plusnum.add(0,"1");
        }
    }
    public void GoAnswerGo(){
        for( String i:plusnum) {
            System.out.print(i);
        }
    }
}
public class Help {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String bnum1=sc.next();
        String bnum2=sc.next();

        binary plus=new binary(bnum1,bnum2);
        plus.GoAnswerGo();
    }
}