package DataStructureIncarnation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Heap{
    public static ArrayList<Integer> heap = new ArrayList<>();

    public static int rootNode(){
        return heap.get(0);
    }

    public static int lastNode(){
        return heap.get(heap.size()-1);
    }
    public static int leftChildIndex(int index){
        return index*2+1;
    }
    public static int rightChildIndex(int index){
        return index*2+2;
    }
    public static int parentIndex(int index){
        return (index-1)/2;
    }

    public static void insert(int value) {
        heap.add(value);
        int insertIndex = heap.size()-1;

        if(heap.size() == 1) return;
        while(heap.get(insertIndex) > heap.get(parentIndex(insertIndex))) {
            int tmpIndex = parentIndex(insertIndex);
            int tmp = heap.remove(tmpIndex);
            heap.add(tmpIndex, value);
            heap.remove(insertIndex);
            heap.add(insertIndex, tmp);
            insertIndex = tmpIndex;
        }
    }

    public static void delete(){
        System.out.println(heap.remove(0));

        if(heap.size() == 0) return;
        heap.add(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int trickleNodeIndex = 0;

        while(hasGreaterChild(trickleNodeIndex)){
            int largerIndex = largerChildIndex(trickleNodeIndex);

            int tmp = heap.remove(largerIndex);
            heap.add(largerIndex, heap.get(trickleNodeIndex));
            heap.remove(trickleNodeIndex);
            heap.add(trickleNodeIndex, tmp);

            trickleNodeIndex = largerIndex;
        }
    }

    public static boolean hasGreaterChild(int index){
        if(leftChildIndex(index) < heap.size() && heap.get(leftChildIndex(index)) > heap.get(index) ||
                rightChildIndex(index) < heap.size() && heap.get(rightChildIndex(index))>heap.get(index)) {
            return true;
        }
        else{
            return false;
        }
    }

    public static int largerChildIndex(int index){
        if(rightChildIndex(index) >= heap.size()) {
            return leftChildIndex(index);
        }
        if(heap.get(leftChildIndex(index)) < heap.get(rightChildIndex(index))){
            return rightChildIndex(index);
        }
        return leftChildIndex(index);
    }
}

public class MaxHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(br.readLine());
            if(input>0){
                Heap.insert(input);
            }
            else{
                if(Heap.heap.isEmpty()){
                    System.out.println(0);
                }
                else{
                    Heap.delete();
                }
            }
        }
    }
}