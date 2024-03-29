package LinkedList;

public class KthElementFromLast {
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
        int size;
        void addLast(int val){
            Node new_node = new Node(val);
            if(head == null){
                head = new_node;
            }else{
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = new_node;
            }
            size++;
        }
        void display(){
            Node temp = head;
            for(int i = 0 ; i < size ; i++){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println();
        }
        void kthFromLast(int idx){
            Node fast = head;
            Node slow = head;
            for(int i = 0 ; i < idx ; i++) {
                fast = fast.next;
            }
            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            System.out.println(slow.data);
        }

    }
    public static  void main(String[] args){
        LL ll = new LL();
        ll.addLast(10);
        ll.addLast(11);
        ll.addLast(12);
        ll.addLast(13);
        ll.display();
        ll.kthFromLast(2);
    }
}
