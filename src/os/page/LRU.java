package os.page;

import java.util.List;

class Page1 {
    private final int counter;

    public Page1(int time){
        counter = time;
    }

    public int getCounter() {
        return counter;
    }
}

class Memory {
    private final List<Page> pages;

    Memory(List<Page> pages) {
        this.pages = pages;
    }
}

public class LRU {

}
