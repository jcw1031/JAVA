package os.page;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Page {
    private int num;
    private int referenceBit;


    public Page(int num) {
        this.num = num;
        referenceBit = 0;
    }

    public void referenced() {
        referenceBit = 1;
    }

    public boolean checkVictim() {
        System.out.println("check");
        if (referenceBit == 1) {
            System.out.println("참조비트 바껴라..");
            referenceBit = 0;
            return false;
        }
        return true;
    }

    public int getReferenceBit() {
        return referenceBit;
    }

    @Override
    public String toString() {
        return "Page "+num + "["+referenceBit+"]";
    }
}

public class SecondChance {

    private static final int SIZE = 3;
    private static final int[] CALL = {8, 1, 2, 3, 1, 4, 1, 5, 3, 4, 1, 4, 3, 2, 3, 1, 2, 8, 1, 2};
    private static Queue<Page> queue = new LinkedList<>();
    private static List<Page> pageTable = new ArrayList<>();
    private static int victim; //희생자 포인터
//    private int pointer; //page queue 선택용 포인터

    public static void main(String[] args) {

        init();

        System.out.println("< Page Table >\n[ 1 ]\t\t[ 2 ]\t\t[ 3 ]\t\t");
        while (!queue.isEmpty()) {
            print();
            Page page = queue.poll();
            if (!isLoaded(page)) {
                loadPage(page);
            } else {
                page.referenced();
            }
        }
    }

    static void init() {
        victim = 0;

        for (int i = 0; i < SIZE; i++) {
            pageTable.add(null);
        }

        Page[] pages = new Page[9];
        for (int i = 1; i < 9 ; i++) {
            pages[i] = new Page(i);
        }

        for (int i : CALL) {
            queue.add(pages[i]);
        }
    }

    public static boolean pageTableHasEmpty() {
        for (Page page : pageTable) {
            if (page == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLoaded(Page page) {
        for (Page loadedPage : pageTable) {
            if (loadedPage == page) {
                return true;
            }
        }
        return false;
    }

    public static void loadPage(Page page) {
        if (pageTableHasEmpty()) {
            pageTable.add(victim, page);
            increaseVictim();
            page.referenced();
        } else {
            pageReplace(page);
        }
    }

    public static void pageReplace(Page page) {
        while (true) {
            Page tmp = pageTable.get(victim);
            if (tmp.checkVictim()) {
                pageTable.set(victim, page);
                increaseVictim();
                page.referenced();
                break;
            }
            increaseVictim();
        }
    }

    public static void increaseVictim() {
        victim++;
        victim = victim % SIZE;
    }

    public static void print() {
        for (int i = 0; i < SIZE; i++) {
            if (pageTable.get(i) != null) {
                System.out.print(pageTable.get(i) + "\t");
            } else {
                System.out.print("\t\t\t");
            }
        }
        System.out.println();
    }
}
