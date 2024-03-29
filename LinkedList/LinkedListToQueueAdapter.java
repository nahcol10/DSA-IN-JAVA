package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListToQueueAdapter {
    public static class QueueAdapter{
        LinkedList1.LL ll = new LinkedList1.LL();

        void push(int val){
            ll.addLast(val);
        }
        void pop(int val){
            if(ll.size == 0){
                System.out.println("Queue underflow");
            }else{
                ll.removeFirst();
            }
        }
        void peek(){
            System.out.println(ll.top());
        }
        void display(){
            ll.display();
        }
    }
    public static void main(String[] args){
        QueueAdapter qa = new QueueAdapter();
        qa.push(10);
        qa.push(11);
        qa.push(12);
        qa.push(13);
        qa.push(14);
        qa.display();
    }
}
