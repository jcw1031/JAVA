import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {

    static ArrayList<Integer> queue =
            new ArrayList<Integer>(Arrays.asList(105,180,40,120,10,125,65,70)) ; //큐에 있는 요청 실린더
    static int disksize = 200; //디스크 크기
    static int head = 50; //처음 주어진 헤드 위치
    static int distance = 0; //총 이동 거리
    static int nowhead = head; //현재 헤드 위치
    static int temp = 0;
    static int tempindex = 0;
    static boolean direction = false; //진행 방향. true면 →, false면 ←

    //scan 알고리즘은 나중에 도착한 요청들도 진행 방향에 있다면 처리함

    //scan 알고리즘 진행 스레드
    static class scanAlgorithm extends Thread {
        public void run() {
            while(queue.size() != 0) {

                if (direction == true) { //진행 방향이 →
                    Collections.sort(queue);

                    for (int i=0; i<queue.size(); i++) {
                        if(queue.get(i) - nowhead > 0) { //진행 방향에 요청이 있다면
                            temp = queue.get(i);
                            tempindex = i;
                            break;
                        }
                        if(i == queue.size() - 1) { //진행 방향에 더이상 요청이 없다면
                            temp = disksize - 1;
                            direction = false;
                        }
                    }

                    distance += temp - nowhead;
                    nowhead = temp;
                    System.out.println(nowhead);

                    if(queue.contains(temp))
                        queue.remove(tempindex);

                }
                else if (direction == false) { //진행 방향이 ←
                    Collections.sort(queue, Collections.reverseOrder());

                    for(int i=0; i<queue.size(); i++) {
                        if (nowhead - queue.get(i) > 0) { //진행 방향에 요청이 있다면
                            temp = queue.get(i);
                            tempindex = i;
                            break;
                        }
                        if (i == queue.size() - 1) { //진행 방향에 더이상 요청이 없다면
                            temp = 0;
                            direction = true;
                        }
                    }

                    distance += nowhead - temp;
                    nowhead = temp;
                    System.out.println(nowhead);

                    if(queue.contains(temp))
                        queue.remove(tempindex);

                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 0 ~ 9 사이의 임의의 수를 뽑아 수가 2 이하이면 queue에 새로운 요청을 추가하는 스레드
    static class newArrivals extends Thread {
        public void run() {
            while (queue.size() != 0) {
                int i = (int) (Math.random() * 10);
                if(i <= 2) {
                    int j = (int) (Math.random() * disksize);
                    queue.add(j);
                    System.out.println("진행 도중 요청 들어옴 : " + j);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        queue = new ArrayList<Integer>(Arrays.asList(105,180,40,120,10,125,65,70));
        disksize = 200;
        head = 50;
        distance = 0;
        nowhead = head;
        temp = 0;
        tempindex = 0;
        direction = false;

        scanAlgorithm s = new scanAlgorithm();
        newArrivals na = new newArrivals();

        s.start();
        na.start();

        try {
            s.join();
            na.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("총 이동 거리 : " + distance);
    }
}