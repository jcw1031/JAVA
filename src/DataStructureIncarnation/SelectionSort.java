package DataStructureIncarnation;

public class SelectionSort {
    int[] data = {14, 5, 43, 27, 18, 31, 37, 88, 6, 35};
    final int SIZE = data.length;

    public void sorting(){
        int tmp;
        for(int i=0;i<SIZE-1;i++){
            for(int j=i+1;j<SIZE;j++){
                if(data[i]>data[j]){
                    tmp=data[i];
                    data[i]=data[j];
                    data[j]=tmp;
                }
            }
        }
    }

    public void print(){
        for(int i=0;i<SIZE;i++){
            System.out.print(data[i]+"\t");
        }
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();

        System.out.println(" ------- Before Sorting ... -------");
        ss.print();
        System.out.println();
        ss.sorting();
        System.out.println(" ------- After Sorting ...  -------");
        ss.print();
    }
}
