package LinkedList;

public class LinkedList1 {

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
            if(head != null){
                new_node.next = head;
                head = new_node;
            }
            size++;
        }
        void addLast(int val){
            Node new_node = new Node(val);
            if(head == null){
                head = tail = new_node;
            }else{
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
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
        void removeFirst(){
            if(head != null && head.next !=null){
                head = head.next;
            }
        }
        int  top(){
            return head.data;
        }
        void getFirst(){
            if(head != null){
                System.out.println(head.data);
            }
        }
        void getLast(){

            System.out.println(tail.data);
        }
        Node getAt(int idx){
            Node temp = head;
            for(int i = 0 ;i  < idx ; i++){
                temp = temp.next;
            }
            return temp;
        }
        void removeLast(){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        void removeAt(int idx){
            Node temp = head;
            for(int i = 0; i < idx - 1 ; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        void reverseIteratively(){
            int left = 0;
            int right = size - 1;
            while(left < right){
                Node leftNode = getAt(left);
                Node rightNode = getAt(right);
                int temp = leftNode.data;
                leftNode.data = rightNode.data;
                rightNode.data = temp;

                left++;
                right--;
            }

        }


    }
    public static void main(String[] args){
        LL l1 = new LL();
        l1.addLast(10);
        l1.addLast(11);
        l1.addLast(12);
        l1.addLast(13);
        l1.addLast(14);
        l1.addFirst(6);
        l1.display();
        l1.reverseIteratively();
        l1.display();

    }
}
