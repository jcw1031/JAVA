package os.deadlock;

import java.util.ArrayList;
import java.util.List;

public class Process {
    private List<Integer> allocation;
    private List<Integer> need;
    private List<Integer> max;
    private int number;

    public Process(List<Integer> allocation, List<Integer> max, int number) {
        this.allocation = allocation;
        this.max = max;
        this.number = number;

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

    public int getNumber() {
        return number;
    }

    public List<Integer> getMax() {
        return max;
    }

    public String toString() {
        return this.allocation + "\t" + this.need + "\t" + this.max;
    }
}