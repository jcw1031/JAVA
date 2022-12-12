package os.memoryPlacementStrategy;

public class Block implements Comparable{
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

    public void updateBlock(int processSize) {
        this.size -= processSize;
        this.start += processSize;
    }


    @Override
    public int compareTo(Object o) {
        Block block = (Block) o;
        return this.size - block.size;
    }

    /**
     * WorstFit
     */
    /*@Override
    public int compareTo(Object o) {
        Block block = (Block) o;
        return block.size - this.size;
    }*/

    /**
     * FirstFit은 Comparable 사용 안 함
     */
}
