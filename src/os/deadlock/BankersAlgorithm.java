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
            need.add(max.get(i) - allocation.get(i));
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

public class BankersAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.print("프로세스의 개수 : ");
        int n = Integer.parseInt(br.readLine());
        Process[] processes = new Process[n];

        for (int i = 0; i < n; i++) {
            System.out.print("P"+(i+1)+"의 Allocation(띄어쓰기로 자원 종류별로 입력 [예시 -> 1 3 5]) : ");
            st = new StringTokenizer(br.readLine());

            List<Integer> allocation = new ArrayList<>();
            while (st.hasMoreTokens()) {
                allocation.add(Integer.parseInt(st.nextToken()));
            }

            System.out.print("P"+(i+1)+"의 Max : ");
            st = new StringTokenizer(br.readLine());

            List<Integer> max = new ArrayList<>();
            while (st.hasMoreTokens()) {
                max.add(Integer.parseInt(st.nextToken()));
            }

            processes[i] = new Process(allocation, max);
        }


    }
}
