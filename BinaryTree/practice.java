package BinaryTree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class practice {
    public  static  class  Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public  static  class  Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public  static @NotNull Node constructBT(Integer[] arr){
        Node root = new Node(arr[0]);
        Pair rtp = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 1;
        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state == 1) {
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx]);
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                idx++;
                top.state++;
            }
            else if(top.state == 2){
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx]);
                    Pair rp = new Pair(top.node.right,1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }
                idx++;
                top.state++;
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
        str += (node.left == null)?".":node.left.data + " ";
        str += "<---" + node.data + "--->";
        str += (node.right == null)?".":node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static  class htAndBBT{
        boolean isBBT;
        int ht;
    }
    public  static  htAndBBT balancedTree(Node node){
        if(node == null){
            htAndBBT bc = new htAndBBT();
            bc.ht = 0;
            bc.isBBT = true;
            return bc;
        }
        htAndBBT ln = balancedTree(node.left);
        htAndBBT rn = balancedTree(node.right);
        htAndBBT mr = new htAndBBT();
        mr.isBBT = ln.isBBT && rn.isBBT &&(Math.abs(ln.ht - rn.ht) <= 1);
        mr.ht = Math.max(ln.ht,rn.ht) + 1;
        return mr;
    }

    public static class BSTpair{
        boolean isBST;
        int max;
        int min;
    }
    public  static  BSTpair checkBST(Node node){
        if(node == null){
            BSTpair bc = new BSTpair();
            bc.isBST = true;
            bc.max = Integer.MIN_VALUE;
            bc.min = Integer.MAX_VALUE;
            return bc;
        }
        BSTpair lp = checkBST(node.left);
        BSTpair rp = checkBST(node.right);
        BSTpair mp = new BSTpair();
        mp.isBST = lp.isBST && rp.isBST && (lp.max < node.data && rp.min > node.data);
        mp.min =  Math.min(node.data,Math.min(lp.min,rp.min));
        mp.max = Math.max(node.data,Math.max(lp.max,rp.max));
        return mp;
    }
    static int tlt = 0;
    public  static  int tilt(Node node){
        if(node == null) return  0;
        int ls = tilt(node.left);
        int rs = tilt(node.right);
        tlt += Math.abs(ls - rs);
        return  ls + rs + node.data;
    }
    public static class basicPair{
        int size = 0;
        int ht = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
    }
    public  static basicPair Basic(Node node){
        if(node == null){
            basicPair bc = new basicPair();
            bc.size = 0;
            bc.ht = 0;
            bc.sum = 0;
            bc.max = 0;
            return bc;
        }
        basicPair lp = Basic(node.left);
        basicPair rp = Basic(node.right);
        basicPair mp = new basicPair();
        mp.size = rp.size + rp.size + 1;
        mp.ht =  Math.max(lp.ht,rp.ht) + 1;
        mp.sum = lp.sum + rp.sum + node.data;
        mp.max = Math.max(node.data, Math.max(lp.max,rp.max));
        return mp;
    }
    public  static  void levelOrderTraversal(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (!mq.isEmpty()){
            int count = mq.size();
            for(int i = 0 ; i < count ; i++) {
                Node x = mq.remove();
                System.out.print(x.data + " ");
                if(x.left != null){
                    mq.add(x.left);
                }
                if(x.right != null) {
                    mq.add(x.right);
                }
            }
            System.out.println();

        }
    }

    public  static  void main(String[] args){
        Integer[] arr = {50,25,12,null,null,37,30,null,null,40,null,null,75,62,60,null,null,77,null,null,87,null,null};
        Node root  = constructBT(arr);
        display(root);
        levelOrderTraversal(root);

    }
}
