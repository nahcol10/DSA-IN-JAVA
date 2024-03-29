package PriorityQueue;

import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public static  void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Integer[] arr = {2 , 3 , 1 , 4, 6, 7 ,5 ,8 , 9};
        int k = 2;
        for(int i = 0 ; i <= k ; i++){
            pq.add(arr[i]);
        }
        for(int i = k + 1 ; i < arr.length ; i++){
            System.out.print(pq.remove() + "\t");
            pq.add(arr[i]);
        }
        while(pq.size() > 0){
            System.out.print(pq.remove() + "\t");
        }

    }
}
