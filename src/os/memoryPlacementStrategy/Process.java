package os.memoryPlacementStrategy;

public class Process {
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
