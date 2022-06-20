package DataStructureIncarnation;

public class ShellSort {
    int tmp;
    int[] data = {14, 5, 43, 27, 18, 31, 37, 88, 6, 35};
    final int SIZE = data.length;
    int[] h = new int[SIZE/2];
    int count = 0;

    public void setH() {
        int tmpH = SIZE;
        while (tmpH != 1) {
            if (tmpH > 2) {
                tmpH = tmpH / 2 + 1;
                h[count]=tmpH;
                count++;
            } else {
                tmpH = tmpH / 2;
                h[count]=tmpH;
                count++;
            }
        }
    }

    public void sort(){
        setH();
        System.out.print("Initial : \t");
        print();
        for(int i=0;i<count;i++){
            System.out.print("h = "+h[i]+"\t\t");
            for(int j=0;(j+h[i])<SIZE;j++){
                if(data[j]>data[j+h[i]]){
                    tmp=data[j];
                    data[j]=data[j+h[i]];
                    data[j+h[i]]=tmp;
                }
            }
            print();
        }
    }

    public void print(){
        for(int i=0;i<SIZE;i++){
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();

        System.out.println(" -------    Sorting ...    -------");
        shellSort.sort();
        System.out.println(" ------- After Sorting ...  -------");
        shellSort.print();
    }
}
