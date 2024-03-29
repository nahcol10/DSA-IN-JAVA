package LinkedList;

public class MergeTwoSortedLL {
    public static  class  Node{
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
        void addLast(int data){
            Node new_node = new Node(data);
            if(head == null){
                tail = head = new_node;
            }else{
                tail.next = new_node;
                tail = new_node;
            }
            size++;
        }
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ---> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static LL mergeLL(Node h1 , Node h2){
        LL mergeLL = new LL();
        while(h1 != null && h2 != null){
            if(h1.data < h2.data){
                mergeLL.addLast(h1.data);
                h1 = h1.next;
            }
            else{
                mergeLL.addLast(h2.data);
                h2 = h2.next;
            }
        }
        while (h1!= null){
            mergeLL.addLast(h1.data);
            h1 = h1.next;
        }
        while (h2!= null){
            mergeLL.addLast(h2.data);
            h2 = h2.next;
        }
        return mergeLL;
    }
    public static void main(String[] args){
        LL  l1 = new LL();
        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.addLast(40);
        l1.addLast(50);
        LL l2 = new LL();
        l2.addLast(15);
        l2.addLast(25);
        l2.addLast(28);
        l2.addLast(30);
        l2.addLast(35);
        l1.display();
        l2.display();
        LL ll = mergeLL(l1.head,l2.head);
        ll.display();
    }
}
