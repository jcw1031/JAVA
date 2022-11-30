import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class replacementtest {

    static void LRUcounter(Page[] pf, int[] callList) {
        int abcount = 0;
        for (int i = 0; i < callList.length; i++) {
            Page temppage = new Page(callList[i]);
            int[] temppnum = new int[pf.length];
            int tempindex = -1;
            int tempcounter = -1;
            boolean exist = false;
            for (int j = 0; j < pf.length; j++) //프레임에 페이지가 존재하는지 확인
                temppnum[j] = pf[j].pnum;
            for (int j = 0; j < pf.length; j++) {
                if (temppnum[j] == callList[i]) {
                    exist = true;
                    tempindex = j;
                }
            }
            if (exist) {//프레임에 페이지가 존재하면
                pf[tempindex].counter = -1;
                for (int j = 0; j < pf.length; j++)
                    pf[j].counter++;
            } else {//프레임에 페이지가 존재하지 않으면
                for (int j = 0; j < pf.length; j++) {
                    if (pf[j].counter > tempcounter) {
                        tempindex = j;
                        tempcounter = pf[j].counter;
                    }
                    pf[j].counter++;
                }
                pf[tempindex] = temppage;
                abcount++;
            }
            for (int j = 0; j < pf.length; j++)
                System.out.print(pf[j].pnum + "\t");
            System.out.println();
        }
        System.out.println("총 부재 횟수 : " + abcount);
    }

    static void LRUstack(int framesize, int[] callList) {
        Stack<Page> pstack = new Stack<Page>();
        int abcount = 0;
        for (int i = 0; i < callList.length; i++) {
            Page temppage = new Page(callList[i]);
            int tempindex = -1;
            boolean exist = false;
            for (int j = 0; j < pstack.size(); j++)
                if (pstack.elementAt(j).pnum == callList[i]) {
                    exist = true;
                    tempindex = j;
                }

            if (exist) { //프레임에 페이지가 존재하면
                pstack.remove(tempindex);//기존에 있던 page를 삭제
                pstack.push(temppage);//스택의 맨 위에 다시 page 삽입
            } else {//프레임에 페이지가 존재하지 않으면
                if (pstack.size() < framesize)//스택이 전부 차있지 않으면
                    pstack.push(temppage);
                else {//스택이 꽉 차있으면
                    pstack.remove(0);
                    pstack.push(temppage);
                }
                abcount++;
            }

            for (int j = 0; j < pstack.size(); j++) {
                System.out.print(pstack.elementAt(j).pnum + "\t");
            }
            System.out.println();
        }
        System.out.println("총 부재 횟수 : " + abcount);
    }

    static void secondChance(int framesize, int[] callList) {
        Queue<Page> pqueue = new LinkedList<>();
        int abcount = 0;
        for (int i = 0; i < callList.length; i++) {
            Page temppage1 = new Page(callList[i]);
            boolean exist = false;
            for (int j = 0; j < pqueue.size(); j++) {
                Page temppage2 = pqueue.poll();
                if (temppage2.pnum == callList[i])
                    exist = true;
                pqueue.offer(temppage2);
            }

            if (exist) {//프레임에 페이지가 존재하면
                for (int j = 0; j < pqueue.size(); j++) {
                    Page temppage3 = pqueue.poll();
                    if (temppage3.pnum == callList[i])
                        continue;
                    else
                        pqueue.offer(temppage3);
                }
                temppage1.ref = 1;
                pqueue.offer(temppage1);
            } else {//프레임에 페이지가 존재하지 않으면
                abcount++;
                if (pqueue.size() < framesize)//큐가 전부 차있지 않으면
                    pqueue.offer(temppage1);
                else {//큐가 꽉 차있으면
                    int refcount = 0;
                    for (int j = 0; j < pqueue.size(); j++) {
                        Page temppage3 = pqueue.poll();
                        if (temppage3.ref == 1) {
                            refcount++;
                            temppage3.ref = 0;
                            pqueue.offer(temppage3);
                        } else {
                            pqueue.offer(temppage1);
                            break;
                        }
                    }
                    if (refcount == pqueue.size()) {
                        //큐에 있는 모든 페이지가 참조되었으면
                        pqueue.poll();
                        pqueue.offer(temppage1);
                    }

                }
            }

            for (int j = 0; j < pqueue.size(); j++) {
                Page temppage4 = pqueue.poll();
                System.out.print(temppage4.pnum + "\t");
                pqueue.offer(temppage4);
            }
            System.out.println();
        }
        System.out.println("총 부재 횟수 : " + abcount);
    }

    public static void main(String args[]) {
        Page[] pf = new Page[3];
        for (int i = 0; i < pf.length; i++)
            pf[i] = new Page(0); //Page 초기화
        int[] callList = {8, 1, 2, 3, 1, 4, 1, 5, 3, 4, 1, 4, 3, 2, 3, 1, 2, 8, 1, 2};
        secondChance(3, callList);

    }
}
