package BinaryTree;

import java.lang.reflect.Parameter;
import java.util.Stack;

public class binaryTreePractice {
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
    public  static  class Pair{
        Node node;
        int level;
        Pair(Node node , int level){
            this.node = node;
            this.level = level;
        }
    }
    public  static  Node BTConstruct(Integer[] arr){
        Node root = new Node(arr[0]);
        Pair rtp = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 1;
        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.level == 1){
                if(arr[idx] != null) {
                    top.node.left = new Node(arr[idx]);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
                else {
                    top.node.left = null;
                }
                top.level++;
                idx++;
            }
            else if(top.level == 2){
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx]);
                    Pair rp = new Pair(top.node.right,1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }
                top.level++;
                idx++;
            }
            else {
                st.pop();
            }
        }
        return root;
    }
    public  static void display(Node node){
        if(node == null) return;
        String str = "";
        str+= (node.left == null)?"." : node.left.data + " ";
        str+= "<--" + node.data + "-->";
        str+= (node.right == null)?"." : node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public  static  class BT{
        boolean isBT;
        int max;
        int min;
    }
    public  static  BT checkBT(Node node){
        if(node == null){
            BT bc = new BT();
            bc.isBT = true;
            bc.max = Integer.MIN_VALUE;
            bc.min = Integer.MAX_VALUE;
            return bc;
        }
        BT ln = checkBT(node.left);
        BT rn = checkBT(node.right);
        BT mr = new BT();
        mr.isBT = ln.isBT && rn.isBT && (ln.max < node.data && rn.min > node.data);
        mr.max = Math.max(node.data,Math.max(ln.max,rn.max));
        mr.min = Math.min(node.data,Math.min(ln.min,rn.min));
        return  mr;
    }
    public  static  void main(String[] args){
//        Integer[] arr = {50,25,12,null,null,37,30,null,null,40,null,null,75,62,60,null,null,77,null,null,87,null,null};
        Integer[] arr = {50 , 25 , 12 , null , null ,37 , null , null ,75, 62 , null , null, 87 , null , null};
        Node root = BTConstruct(arr);
        display(root);
        BT result = checkBT(root);
        System.out.println(result.isBT);
    }
}
