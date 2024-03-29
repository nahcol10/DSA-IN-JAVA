package LinkedList;

public class ReverseLLRecursively {
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
            }else {
                tail.next = new_node;
                tail = new_node;
            }
            size++;
        }
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println();
        }

        void reverse(){
            reverseHelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = head;
        }
        void reverseHelper(Node node){
            if(node == null || node.next == null) return;
            reverseHelper(node.next);
            node.next.next = node;

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
        ll.display();
        ll.reverse();
        ll.display();
    }
}
