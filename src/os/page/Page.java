package os.page;

public class Page {
    private int num;
    private int timeField;

    public Page(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public int getTimeField() {
        return timeField;
    }

    public Page referenced(int count) {
        timeField = count;
        return this;
    }

    @Override
    public String toString() {
        return "Page " + num + "[" + timeField + "]";
    }
}