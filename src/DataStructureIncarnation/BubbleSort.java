package DataStructureIncarnation;

public class BubbleSort {
    int[] data={31, 6, 10, 37, 15};
    final int SIZE = data.length;

    public void sorting(){
        int tmp;
        for(int i=SIZE-1;i>0;i--){
            for(int j=1;j<=i;j++){
                if(data[j-1]>data[j]){
                    tmp=data[j];
                    data[j]=data[j-1];
                    data[j-1]=tmp;
                }
            }
        }
    }

    public void print(){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();

        System.out.println(" ------- Before Sorting ... -------");
        bs.print();
        System.out.println();
        bs.sorting();
        System.out.println(" ------- After Sorting ...  -------");
        bs.print();
    }
}
