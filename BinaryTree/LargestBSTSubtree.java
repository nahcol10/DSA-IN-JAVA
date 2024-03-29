package BinaryTree;

import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class LargestBSTSubtree {
    public static  class Node{
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
    public static class BSTPAIR{
        boolean isBST;
        int min;
        int max;
        Node largestroot;
        int largestsize;

    }
    public  static Node constructBT(Integer[] arr){
        Node root = new Node(arr[0]);
        Pair rtp = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 1;
        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.level == 1) {
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx]);
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                idx++;
                top.level++;
            }
            else if(top.level == 2){
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx]);
                    Pair rp = new Pair(top.node.right,1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }
                idx++;
                top.level++;
            }
            else {
                st.pop();
            }
        }
        return root;
    }
    public static void display(Node node){
        if(node == null) return;
        String str = "";
        str += (node.left == null)?" . ":node.left.data + " ";
        str += " <--- " + node.data + " ---> ";
        str += (node.right == null)? " . " : node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public  static  BSTPAIR largestBSTSubset(Node node){
        if(node == null){
            BSTPAIR bc = new BSTPAIR();
            bc.isBST = true;
            bc.min = Integer.MAX_VALUE;
            bc.max = Integer.MIN_VALUE;
            bc.largestroot = null;
            bc.largestsize = 0;
            return  bc;
        }
        BSTPAIR lp = largestBSTSubset(node.left);
        BSTPAIR rp = largestBSTSubset(node.right);
        BSTPAIR mp = new BSTPAIR();
        mp.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);
        mp.max = Math.max(node.data,Math.max(lp.max, rp.max));
        mp.min = Math.min(node.data,Math.min(lp.min,rp.min));
        if(mp.isBST){
            mp.largestroot = node;
            mp.largestsize = lp.largestsize + rp.largestsize + 1;
        } else if (lp.largestsize > rp.largestsize) {
            mp.largestroot = lp.largestroot;
            mp.largestsize = lp.largestsize;
        }
        else {
            mp.largestroot = rp.largestroot;
            mp.largestsize = rp.largestsize;

        }
        return mp;
    }
    public  static  void main(String[] args){
        Integer[] arr = {50,25,12,null,null,37,30,null,null,40,null,null,75,62,60,null,null,77,null,null,87,null,null};
        Node root = constructBT(arr);
        display(root);
        BSTPAIR ans = largestBSTSubset(root);
        System.out.println(ans.largestroot.data + "@" + ans.largestsize);
    }
}
