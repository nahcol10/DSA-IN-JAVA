package LinkedList;

public class IsPalindromeLL {
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
        Node tail;
        Node left;
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
        boolean isPalindrome(){
            left = head;
            return isPalindromeHelper(head);
        }
        boolean isPalindromeHelper(Node right){
            if(right == null) return true;
            boolean tres = isPalindromeHelper(right.next);
            if(!tres) return false;
            else if(left.data != right.data) {
                return false;
            }
            else {
                left = left.next;
                return true;
            }
        }
        void fold(){
            left = head;
            foldHelper(head,0);
        }
        void foldHelper(Node right,int level){
            if(right == null ) return ;
            foldHelper(right.next, level + 1);
            if(level > size/2){
                Node temp = left.next;
                left.next = right;
                right.next = temp;
                left = temp;
            }else if(level == size / 2){
                tail = right;
                tail.next = null;
            }
        }
    }
    public static  void main(String[] args){
        LL ll = new LL();
        ll.addLast(10);
        ll.addLast(11);
        ll.addLast(12);
        ll.addLast(13);
        ll.addLast(14);
        ll.addLast(15);
//        ll.addLast(15);
//        ll.addLast(14);
//        ll.addLast(13);
//        ll.addLast(12);
//        ll.addLast(11);
//        ll.addLast(10);
        ll.display();
        ll.fold();
        ll.display();

    }
}
