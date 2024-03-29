package PriorityQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueueUsingHeap {
    public static class PriorityQueue{
        ArrayList<Integer> al = new ArrayList<>();
        void add(int val){
            al.add(val);
            upheapify(al.size() - 1);
        }

        private void upheapify(int ci) {
            if(ci == 0) return;
            else{
                int pi = (ci - 1)/2;
                if(al.get(pi) > al.get(ci)){
                    swap(pi,ci);
                    upheapify(pi);
                }
            }
        }
        private void swap(int pi , int ci){
            int pith = al.get(pi);
            int cith = al.get(ci);
            al.set(pi,cith);
            al.set(ci,pith);
        }

        void peek(){
            System.out.println(al.get(0));
        }
        void remove(){
            if(al.isEmpty()) System.out.println("Underflow");
            swap(0,al.size() - 1);
            System.out.println(al.remove(al.size() - 1));
            downheapify(0);
        }
        private void downheapify(int pi){
            int mini = pi;
            int li = 2*pi + 1;
            if( li < al.size() && al.get(mini) > al.get(li)){
                mini = li;
            }
            int ri = 2*pi + 2;
            if( ri < al.size() && al.get(mini) > al.get(ri)){
                mini = ri;
            }
            if(mini != pi){
                swap(pi,mini);
                downheapify(mini);
            }
        }
        void size(){
            System.out.println(al.size());
        }
        void display(){
            for(int i = 0 ; i < al.size() ; i++){
                System.out.print(al.get(i)  + " \t ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue pq = new PriorityQueue();
        for(int i = 0 ; i < 10 ; i++){
            pq.add(sc.nextInt());
        }
        pq.display();
        pq.peek();
        pq.remove();
        pq.display();
    }
}
