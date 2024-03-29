package Queue;

public class NormalQueue {
    public static class Queue{
        int[] data;
        int front = 0;
        int size = 0;
        Queue(int capacity){
            this.data = new int[capacity];
        }
        void add(int val){
            if(front == data.length){
                System.out.println("Queue Overflow");
            }else{
                size = (size + front)% data.length;
                data[size] = val;
                size++;
            }
        }
        void remove(){
            if(size == 0){
                System.out.println("Queue underflow");
            }else{
                int val = data[front];
                front++;
                size--;
                System.out.println(val);
            }
        }
        void top(){
            if(front == 0){
                System.out.println("Queue underflow");
            }else{
                System.out.println(data[front]);
            }
        }
        void size(){
            System.out.println(size);
        }
        void display(){
            for(int i = 0 ; i < size ; i++){
                int rear = (i +front) % data.length;
                System.out.print(data[rear] + "\t");
            }
        }
        
    }
    public static void main(String[] args){
        Queue mq = new Queue(5);
        mq.add(10);
        mq.add(11);
        mq.add(12);
        mq.add(13);
        mq.add(14);
        mq.remove();
        mq.remove();
        mq.size();
        mq.display();

    }
}
