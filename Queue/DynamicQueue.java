package Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DynamicQueue {
    public static class DQueue{
        ArrayList<Integer> al = new ArrayList<>();
        int size = 0;
        int front = 0;
        void add(int val){
            al.add(val);
            size++;
        }
        void remove(){
            if(al.size() == 0){
                System.out.println("Queue underflow");
            }else{
                System.out.println(al.get(front));
                size--;
                front++;
            }
        }
        void top(){
            System.out.println(al.get(front));
        }
        void display(){
            for(int i = 0 ; i < size ; i++){
                System.out.print(al.get(i + front) + " \t ");
            }
            System.out.println();
        }
        void  size(){
            System.out.println(size);
        }

    }
    public static void main(String[] args){
        DQueue mq = new DQueue();
        mq.add(10);
        mq.add(11);
        mq.add(12);
        mq.add(13);
        mq.add(14);
        mq.add(15);
        mq.display();
        mq.top();
        mq.remove();
        mq.top();
        mq.display();
        mq.size();


    }
}
