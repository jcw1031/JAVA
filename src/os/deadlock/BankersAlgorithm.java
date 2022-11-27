package os.deadlock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Process {
    private List<Integer> allocation;
    private List<Integer> need;
    private List<Integer> max;

    public Process(List<Integer> allocation, List<Integer> max) {
        this.allocation = allocation;
        this.max = max;
        this.need = new ArrayList<>();

        for (int i = 0; i < allocation.size(); i++) {
            this.need.add(max.get(i) - allocation.get(i));
        }
    }

    public List<Integer> getAllocation() {
        return allocation;
    }

    public List<Integer> getNeed() {
        return need;
    }

    public List<Integer> getMax() {
        return max;
    }

    public String toString() {
        return this.allocation + "\t" + this.need + "\t" + this.max;
    }
}

// -----------------------------------------------------------------------------------------------

public class BankersAlgorithm {

    private static Process[] processes;
    private static List<Integer> work;
    private static boolean[] finish;
    private static List<Integer> available;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.print("프로세스의 개수 : ");
        n = Integer.parseInt(br.readLine());

        System.out.print("자원 종류 수 : ");
        m = Integer.parseInt(br.readLine());

        initial(n, m);

        System.out.println("\tAllocation\tNeed\t\tMax");
        for (int i = 0; i < processes.length; i++) {
            System.out.println("P" + (i + 1) + "\t" + processes[i].toString());
        }
        System.out.println("Available : " + available + "\n\n");

        bankers();
    }

    /** -----------------------------------------------------------------------------------------------
     * 초기화
     */
    public static void initial(int n, int m) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        processes = new Process[n];
        finish = new boolean[n];
        available = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("P"+(i+1)+"의 Allocation(띄어쓰기로 자원 종류 구분 [예시 -> 1 3 5]) : ");
            st = new StringTokenizer(br.readLine());

            List<Integer> allocation = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                allocation.add(Integer.parseInt(st.nextToken()));
            }


            System.out.print("P"+(i+1)+"의 Max(띄어쓰기로 자원 종류 구분) : ");
            st = new StringTokenizer(br.readLine());

            List<Integer> max = new ArrayList<>();
            while (st.hasMoreTokens()) {
                max.add(Integer.parseInt(st.nextToken()));
            }

            processes[i] = new Process(allocation, max);
        }

        System.out.print("Available [예시 -> 2 3 1] : ");
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            available.add(Integer.parseInt(st.nextToken()));
        }

        setWork(available);
    }

    /** -----------------------------------------------------------------------------------------------
     * work 설정 (초기에는 Available로, 이후에는 Allocation을 더한 값으로)
     */
    public static void setWork(List<Integer> input) {
        if (work == null) {
            work = new ArrayList<>();
            work.addAll(input);
        } else {
            for (int i = 0; i < input.size(); i++) {
                work.set(i, work.get(i) + input.get(i));
            }
        }
        System.out.println("work : " + work);
    }

    /** -----------------------------------------------------------------------------------------------
     * Banker's Algorithm
     */
    public static void bankers() {
        boolean flag;
        while (!isAllFinished()) {
            for (int i = 0; i < n; i++) {
                if (!finish[i]) {
                    flag = compare(processes[i].getNeed(), work);
                    if (flag) {
                        finish[i] = true;
                        System.out.print("P"+(i+1)+" 완료\t");
                        setWork(processes[i].getAllocation());
                    }
                }
            }
        }
    }

    /** -----------------------------------------------------------------------------------------------
     * 모든 프로세스가 완료되었는지 체크
     */
    public static boolean isAllFinished() {
        for (boolean b : finish) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    /** -----------------------------------------------------------------------------------------------
     * 프로세스의 요구량과 사용 가능한 자원의 비교
     */
    public static boolean compare(List<Integer> need, List<Integer> work) {
        for (int i = 0; i < m; i++) {
            if (need.get(i) > work.get(i)) {
                return false;
            }
        }
        return true;
    }
}
