package os.memoryPlacementStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WorstFit {
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
        emptyList.add(new Block(100000, 50000));

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
                for (Block block : emptyList) {
                    if (block.getSize() >= tmp.getSize()) {
                        tmp.processAllocate(block);
                        block.updateBlock(tmp.getSize());
                        break;
                    }
                }
            }

            System.out.println((index++)+1 + "\t\t\t" + tmp.getStart() + "\t\t" + tmp.getEnd() + "\t\t" + tmp.getSize());
        }
    }
}
