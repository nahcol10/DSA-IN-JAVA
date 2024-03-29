package LinkedList;

public class IntersectionPointOfTwoLL {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class LL{
        Node head;
        Node tail;
        int size;
        void addLast(int val){
            Node new_node = new Node(val);
            if(head == null){
                head = tail = new_node;
            }else{
                tail.next = new_node;
                tail = new_node;
            }
            size++;
        }
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println();
        }
        void intersectionPoint(LL other){
            Node temp1 = this.head;
            Node temp2 = other.head;
            int diff = Math.abs(this.size - other.size);
            if(this.size > other.size){
                for(int i = 0 ; i < diff ; i++){
                    temp1 = temp1.next;
                }
            }
            if(this.size < other.size){
                for(int i = 0 ; i < diff ; i++){
                    temp2 = temp2.next;
                }
            }

            while(temp1.data != temp2.data){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            System.out.println(temp1.data);
        }
    }
    public static void main(String[] args){
        LL l1 = new LL();
        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.addLast(40);
        l1.addLast(50);

        LL l2 = new  LL();
        l2.addLast(15);
        l2.addLast(30);
        l2.addLast(40);
        l2.addLast(60);

        l1.intersectionPoint(l2);
    }
}
