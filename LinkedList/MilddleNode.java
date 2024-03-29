package LinkedList;

public class MilddleNode {
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
        int middleNode(){
            Node fast = head;
            Node slow = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            System.out.println(slow.data);
            return slow.data;
        }
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        LL ll = new LL();
        ll.addLast(10);
        ll.addLast(11);
        ll.addLast(12);
        ll.addLast(13);
        ll.addLast(14);
        ll.addLast(15);
//        ll.addLast(16);
        ll.display();
        ll.middleNode();
    }
}
