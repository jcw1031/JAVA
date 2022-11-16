package os.memoryPlacementStrategy;

class Block1 implements Comparable{
    int start, end, size;
    public Block1(int s, int e, int si) {
        start = s;
        end = e;
        size = si;
    }

    public Integer getSizeInteger() {
        return size;
    }

    @Override
    public int compareTo(Object o) {
        Block1 block = (Block1) o;
        return this.size - block.size;
    }
}
class Process1 {
    int start,end,size;
    boolean occupied;
    public Process1(int s, int e, int si) {
        start = s;
        end = e;
        size = si;
        occupied = false;
    }
}

public class Fit {

    static void bestFit(Block1[] b, Process1[] p) {
        for (int i=0; i<p.length; i++) {
            int best = -1;
            for (int j=0; j<b.length; j++) {
                if (b[j].size >= p[i].size) {
                    if (best == -1)
                        best = j;
                    else if (b[best].size > b[j].size)
                        best = j;
                    p[i].occupied = true;
                }
            }
            if (p[i].occupied == true) {
                p[i].start = b[best].start;
                p[i].end = p[i].start+p[i].size-1;
                b[best].start = p[i].end+1;
                b[best].size -= p[i].size;
            }
        }
    }

    public static void main(String args[]) {
        Block1[] b = new Block1[5];
        b[0] = new Block1(0,499,500);
        b[1] = new Block1(500,599,100);
        b[2] = new Block1(600,899,300);
        b[3] = new Block1(900,1299,400);
        b[4] = new Block1(1300,1499,200);
        Process1[] p = new Process1[5]; // 프로세스가 할당되기 전일 때 시작과 끝 주소는 -1로 설정
        p[0] = new Process1(-1,-1,200);
        p[1] = new Process1(-1,-1,300);
        p[2] = new Process1(-1,-1,500);
        p[3] = new Process1(-1,-1,400);
        p[4] = new Process1(-1,-1,100);

//         firstFit(b,p);
//         nextFit(b,p);
         bestFit(b,p);
//         worstFit(b,p);

        System.out.println("P No.\tP Size\tP St\tP End");
        for (int i=0; i<p.length; i++) {
            if (p[i].occupied == true)
                System.out.println(i+"\t\t"+p[i].size+"\t\t"+p[i].start+"\t\t"+p[i].end);
            else
                System.out.println(i+"\t\t"+p[i].size+"\t\t\t\tnot occupied!");
        }
    }
}