package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElementInArray {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Integer[] arr = {2 , 10 , 5 ,1 ,7 ,18 , 6 ,4};
        for(int i = 0 ; i < 3 ; i++){
            pq.add(arr[i]);
        }
        for(int i = 3 ; i < arr.length ; i++ ){
            if(arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while(pq.size() > 0){
            System.out.print(pq.remove() + "\t");
        }
    }
}
