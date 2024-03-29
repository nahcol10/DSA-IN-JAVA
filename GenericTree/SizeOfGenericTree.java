package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class SizeOfGenericTree {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }
    public static Node construct(int[] arr){
        Stack<Node> st = new Stack<>();
        Node root = new Node(arr[0]);
        st.push(root);
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node new_node = new Node(arr[i]);
                st.peek().children.add(new_node);
                st.push(new_node);
            }
        }
        return root;
    }
    public static void display(Node node){

        String str = "";
        str += node.data + " ---> ";
        for(Node child : node.children){
            str += child.data + " \t ";
        }
        System.out.println(str);
        for(Node child : node.children){
            display(child);
        }
    }
    static int size = 0;
    public static int size(Node node){
        for(Node child : node.children){
            size  = size(child);
        }
        return size + 1;
    }
    public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        display(root);
        System.out.println(size(root));
    }
}
