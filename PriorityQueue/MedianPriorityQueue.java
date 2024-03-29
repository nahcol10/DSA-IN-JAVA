package PriorityQueue;

//import java.util.Collections;
//import java.util.PriorityQueue;
//
//public class MedianPriorityQueue {
//    public static class MedianPriorityQueues{
//        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> right = new PriorityQueue<>();
//        void add(int val){
//            if(right.size() > 0 && right.peek() < val){
//                right.add(val);
//            }else{
//                left.add(val);
//            }
//            if(right.size() - left.size() == 2){
//                left.add(right.remove());
//            } else if(left.size() - right.size() == 2){
//                right.add(left.remove());
//            }
//        }
//        void median(){
//            if(left.isEmpty()) {
//                System.out.println("Queue underflow");
//            } else if(left.size() >= right.size()){
//                System.out.println(left.peek());
//            }else{
//                System.out.println(right.peek());
//            }
//        }
//        void remove(){
//            if(left.isEmpty()) {
//                System.out.println("Queue underflow");
//            } else if(left.size() >= right.size()){
//                System.out.println(left.remove());
//            }else{
//                System.out.println(right.remove());
//            }
//        }
//        void size(){
//            System.out.println(left.size() + right.size());
//        }
//    }
//    public static void main(String[] args){
//        MedianPriorityQueues pq = new MedianPriorityQueues();
//        pq.add(10);
//        pq.add(40);
//        pq.add(20);
//        pq.add(30);
//        pq.add(50);
//        pq.add(70);
//        pq.add(60);
//        pq.median();
//        pq.remove();
//        pq.remove();
//    }
//}

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {
    public static class MedianPriority{
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        void add(int val){
            if(!right.isEmpty() && val > right.peek()){
                right.add(val);
            }else{
                left.add(val);
            }
            if(right.size() - left.size() == 2){
                left.add(right.remove());
            }
            if(left.size() - right.size() == 2){
                right.add(left.remove());
            }
        }
        void peek(){
            if(left.isEmpty()){
                System.out.println("Queue underflow");
            }else if(left.size() < right.size()){
                System.out.println(right.peek());
            }else{
                System.out.println(left.peek());
            }
        }
        void remove(){
            if(left.isEmpty()){
                System.out.println("Queue underflow");
            }else if(right.size() > left.size()){
                System.out.println(right.remove());
            }else{
                System.out.println(left.remove());
            }
        }
    }
    public static void main(String[] args){
        MedianPriority pq = new MedianPriority();
        Integer[] arr = { 10 , 20 , 30 , 40 , 50 ,60 ,70 ,80 , 90};
        for(int i = 0; i < arr.length ; i++){
            pq.add(arr[i]);
        }
        pq.peek();
        pq.remove();
        pq.remove();
        pq.remove();
    }
}
