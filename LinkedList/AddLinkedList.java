package LinkedList;

public class AddLinkedList {
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
        void addFirst(int val){
            Node new_node = new Node(val);
            if(head == null) tail = head = new_node;
            else{
                new_node.next = head;
                head = new_node;
            }
            size++;
        }
        void addLast(int val){
            Node new_node= new Node(val);
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
            while(temp!= null){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println();
        }
        void addLL(LL other){
            LL res = new LL();
            AddLLHelper(this.head,this.size,other.head,other.size,res);
            res.display();
        }
        int AddLLHelper(Node h1 , int idx1 , Node h2 , int idx2 , LL res){
            if(h1 == null && h2 == null) {
                return  0;
            }
            int data = 0;
            int carry;
            if(idx1 > idx2){
                carry = AddLLHelper(h1.next,idx1 - 1 , h2 , idx2 , res);
                data = h1.data + carry;
                int rem = data % 10;
                res.addFirst(rem);
                return data/10;
            } else if (idx2 > idx1) {
                carry = AddLLHelper(h1,idx2 , h2.next , idx2 -1 ,res);
                data =  h2.data + carry;
                int rem = data % 10;
                res.addFirst(rem);
                return data/10;
            }else {
                carry = AddLLHelper(h1.next,idx1-1,h2.next,idx2 - 1 , res);
                data = h1.data + h2.data + carry;
                int rem = data % 10;
                res.addFirst(rem);
                return data/10;
            }
        }
    }
    public static void main(String[] args){
        LL l1 = new LL();
        l1.addLast(11);
        l1.addLast(2);
        l1.addLast(3);

        LL l2 = new LL();
        l2.addLast(5);
        l2.addLast(16);
        l2.addLast(0);
        l1.display();
        l2.display();
        l2.addLL(l1);
    }
}
