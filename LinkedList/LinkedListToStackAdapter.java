package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListToStackAdapter {
    public static class StackAdapter{
        List<Integer> ll = new LinkedList<>();
        void push(int val){
            ll.add(val);
        }
        void pop(){
            if(ll.isEmpty()){
                System.out.println("empty linked list");
            }else{
                System.out.printf(String.valueOf(ll.get(ll.size() - 1)));
                ll.remove(ll.get(ll.size() - 1));
            }
            System.out.println();
        }
        void top(){
            if(ll.isEmpty()) {
                System.out.println("empty");
            }else{
                System.out.println(ll.get(ll.size() - 1));
            }
            System.out.println();
        }
        int[] display(){
            int[] arr = new int[ll.size()];
            for(int i = 0 ; i < ll.size() ; i++){
                arr[i] = ll.get(i);
            }
            return arr;
        }
        void size(){
            System.out.println(ll.size());
        }
    }
    public static void main(String[] args){
        StackAdapter sa = new StackAdapter();
        sa.push(10);
        sa.push(11);
        sa.push(12);
        sa.push(13);
        sa.push(14);
        sa.display();
        sa.pop();
        sa.display();


    }
}
