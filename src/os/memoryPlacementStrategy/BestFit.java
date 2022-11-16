package os.memoryPlacementStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Block implements Comparable {
    private int start, end, size;

    public Block(int start, int size) {
        this.start = start;
        this.size = size;

        end = start + size - 1;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public String toString() {
        return "size : "+size;
    }


    @Override
    public int compareTo(Object o) {
        Block block = (Block) o;
        return this.size - block.size;
    }
}

class Process {
    private int start, end, size;
    private boolean allocation;

    public Process(int size) {
        this.size = size;
    }

    public void processAllocate(Block block) {
        this.allocation = true;

        this.start = block.getStart();
        this.end = this.start + this.size - 1;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getSize() {
        return size;
    }

    public boolean isAllocated() {
        return allocation;
    }
}

public class BestFit {
    private static List<Block> emptyList;
    private static Queue<Process> request;

    public static void main(String[] args) {
        initial();

        System.out.println("Process\t\tStart\t\tEnd\t\t\tSize");
        placement();

    }

    public static void initial() {
        emptyList = new ArrayList<>();
        request = new LinkedList<>();

        emptyList.add(new Block(10000, 17000));
        emptyList.add(new Block(30000, 7000));
        emptyList.add(new Block(50000, 15000));
        emptyList.add(new Block(100000, 30000));

        request.add(new Process(12000));
        request.add(new Process(5000));
        request.add(new Process(30000));
    }

    public static void placement() {
        int index = 0;
        while (!request.isEmpty()) {
            Process tmp = request.poll();
            emptyList.sort(Block::compareTo);
            if (!tmp.isAllocated()) {
                for (int i = 0; i < emptyList.size(); i++) {
                    if (emptyList.get(i).getSize() >= tmp.getSize()) {
                        tmp.processAllocate(emptyList.get(i));
                        break;
                    }
                }
            }

            System.out.println(index++ + "\t\t\t" + tmp.getStart() + "\t\t" + tmp.getEnd() + "\t\t" + tmp.getSize());
        }
    }
}
