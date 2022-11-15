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
    private List<Integer> available;

    public Process(List<Integer> allocation, List<Integer> max) {
        this.allocation = allocation;
        this.max = max;

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

    public List<Integer> getAvailable() {
        return available;
    }

    public void setAvailable(List<Integer> available) {
        this.available = available;
    }
}

//--------------------------------------------------------------------------

public class BankersAlgorithm {

    private static Process[] processes;
    private static List<Integer> work;
    private static boolean[] finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.print("프로세스의 개수 : ");
        int n = Integer.parseInt(br.readLine());

        initial(n);

        System.out.print("프로세스 번호와 Available [예시 -> 1 2 3 1] : ");
        st = new StringTokenizer(br.readLine());
        int index = Integer.parseInt(st.nextToken());
        List<Integer> available = new ArrayList<>();

        while (st.hasMoreTokens()) {
            available.add(Integer.parseInt(st.nextToken()));
        }

        processes[index + 1].setAvailable(available);


    }

    public static void initial(int n) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        processes = new Process[n];
        finish = new boolean[n];

        for (int i = 0; i < n; i++) {
            System.out.print("P"+(i+1)+"의 Allocation(띄어쓰기로 자원 종류 구분 [예시 -> 1 3 5]) : ");
            st = new StringTokenizer(br.readLine());

            List<Integer> allocation = new ArrayList<>();
            while (st.hasMoreTokens()) {
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
    }

    public static void setAvailable() {
    }
}
