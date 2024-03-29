package LinkedList;

public class ReverseLL {
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
                tail.next  = new_node;
                tail = new_node;
            }
            size++;
        }
        void addFirst(int val){
            Node new_node = new Node(val);
            if(head != null){
                new_node.next = head;
                head = new_node;
            }else{
                head = tail = new_node;
            }
            size++;
        }
        Node removeFirst(){
            if(head != null){
                head = head.next;
            }
            size--;
            return head;
        }

        Node removeLast(){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            return head;
        }
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println();
        }
        void KthReverse(int r) {
            LL prev = null;
            while (this.size > 0) {
                LL curr = new LL();
                if(this.size >= r) {
                    for (int i = 0; i < r; i++) {
                        curr.addFirst(this.head.data);
                        this.removeFirst();
                    }
                } else {
                    int os = this.size;
                    for(int i = 0 ; i < os ; i++) {
                        curr.addLast(this.head.data);
                        this.removeFirst();

                    }
                }
                if(prev == null){
                    prev = curr;
                }else{
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }
            prev.display();
        }

        void displayRecursively(){
            Node temp = this.head;
            displayRecursivelyHelper(temp);
        }
        void displayRecursivelyHelper(Node node){
            if(node == null){
                return;
            }
            displayRecursivelyHelper(node.next);
            System.out.print(node.data + " --> ");
        }
    }

    public static void main(String[] args){
        LL ll = new LL();
        ll.addLast(11);
        ll.addLast(12);
        ll.addLast(13);
        ll.addLast(14);
        ll.addLast(15);
        ll.addLast(16);
        ll.addLast(17);
        ll.addLast(18);
        ll.display();
        ll.displayRecursively();

    }
}
