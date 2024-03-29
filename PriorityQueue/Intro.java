package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Intro {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Integer[] arr = { 1,9, 8 ,4, 5, 7 ,2, 3};
        for(Integer key : arr){
            pq.add(key);
        }
        while(pq.size() > 0){
            System.out.print(pq.peek() + "\t");
            pq.remove();
        }
    }
}
