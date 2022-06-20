package DataStructureIncarnation;

public class QuickSort {
    int tmp;
    int pivot;
    int[] data = {14, 5, 43, 27, 18, 31, 37, 88, 6, 35};
    final int SIZE = data.length;
    int[] flag = new int[SIZE];
    int L, R;

    public boolean isAllDecision() {
        boolean d = true;

        for (int i = 0; i < SIZE; i++) {
            if (flag[i] == 0) {
                d = false;
                break;
            }
        }

        return d;
    }

    public void sort(){
        for(int i=0;i<SIZE;i++){
            flag[i]=0;
        }

        pivot = SIZE/2;
        while(!isAllDecision()){
            L=0;
            R=SIZE-1;
            for(int i=0;i<SIZE;i++){
                if(data[L]<=data[pivot] && L<=SIZE+1){
                    L++;
                }
                if(data[R]>data[pivot] && R>=0){
                    R--;
                }
            }
            if(L<R){
                tmp=data[L];
                data[L]=data[R];
                data[R]=tmp;
            }
            else{
                tmp=data[pivot];
                data[pivot]=data[R];
                data[R]=tmp;
                flag[R]=1;
            }
            System.out.println(flag[0]+" "+flag[4]);
        }
    }

    public void print(){
        for(int i=0;i<SIZE;i++){
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

        qs.print();
        System.out.println();
        qs.sort();
        qs.print();
    }
}
