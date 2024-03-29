package LinkedList;

public class OddEvenWithRelativePosition {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = next;
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
                System.out.print(temp.data + " ---> ");
                temp = temp.next;
            }
            System.out.println();
        }
        void oddEven(){
            LL odd = new LL();
            LL even = new LL();
            Node temp = head;
            while(temp != null){
                if(temp.data % 2  != 0){
                    odd.addLast(temp.data);
                }else{
                    even.addLast(temp.data);
                }
                temp = temp.next;
            }
            head = odd.head;
            odd.tail.next = even.head;
            this.display();
        }
    }
    public  static void main(String[] args){
        LL l1 = new LL();
        l1.addLast(10);
        l1.addLast(11);
        l1.addLast(67);
        l1.addLast(23);
        l1.addLast(98);
        l1.addLast(43);
        l1.addLast(76);
        l1.addLast(87);
        l1.addLast(34);
        l1.display();
        l1.oddEven();
    }
}
