package BinaryTree;

import java.util.*;

public class tiltOfBinaryTree {
    public  static  class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    public static class pair{
        Node node;
        int state;
        pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node constructBT(Integer[] arr){
        Node root = new Node(arr[0]);
        pair rtp = new pair(root,1);
        Stack<pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while(!st.isEmpty())
        {
            pair top = st.peek();
            idx++;
            if(top.state == 1)
            {
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx]);
                    pair lp = new pair(top.node.left,1);
                    st.push(lp);
                }
                else{
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state == 2)
            {
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx]);
                    pair rp = new pair(top.node.right,1);
                    st.push(rp);
                }
                else{
                    top.node.right = null;
                }
                top.state++;
            }
            else{
                st.pop();
            }
        }
        return root;
    }
    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null? "." : node.left.data + " ";
        str += "<--" + node.data + "-->";
        str += node.right == null? "." : node.right.data + " ";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    static  int tlt = 0;
    public  static  int tiltBT(Node node){
        if(node == null) return 0;
        int ls = tiltBT(node.left);
        int rs = tiltBT(node.right);
        int ltlt =  Math.abs(ls - rs);
        tlt += ltlt;
        return ls + rs + node.data;
    }
    public  static class BST{
        boolean isBST;
        int max;
        int min;
    }
    public static BST checkBST(Node node){
        if(node == null){
            BST bc = new BST();
            bc.isBST = true;
            bc.max = Integer.MIN_VALUE;
            bc.min= Integer.MAX_VALUE;
            return  bc;
        }
        BST ln = checkBST(node.left);
        BST rn = checkBST(node.right);

        BST mr = new BST();
        mr.isBST = ln.isBST && rn.isBST && (node.data >= ln.max && node.data <= rn.min);
        mr.max = Math.max(node.data,Math.max(ln.max,rn.max));
        mr.min = Math.min(node.data,Math.min(ln.min,rn.min));

        return  mr;
    }

    public  static  void main(String[] args){
        Integer[] arr = {50 , 25 , 12 , null , null ,37 , 30 ,null , null, 40 , null , null , 75 , 62 , 60 , null , null, 77 , null , null,87, null , null};
        Node root = constructBT(arr);
        display(root);
        BST ans = checkBST(root);
        System.out.println(ans.isBST);
    }
}
