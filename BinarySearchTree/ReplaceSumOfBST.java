package BinarySearchTree;

import java.util.Stack;

public class ReplaceSumOfBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node construct(int[] arr,int lo  , int hi){
        if(lo > hi) return  null;
        int mid = (lo + hi)/2;
        Node ln = construct(arr,lo,mid - 1);
        Node rn = construct(arr,mid + 1, hi);
        return new Node(arr[mid],ln,rn);
    }
    public static void display(Node node){
        if(node == null) return;
        String str = "";
        str += (node.left == null)?" . ":node.left.data + " ";
        str += " <--- " + node.data + " ---> ";
        str += (node.right == null)?" . ":node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static boolean find(Node node , int target){
        if(node == null) return false;
        if(node.data > target){
            return find(node.left,target);
        }else if(node.data < target){
            return find(node.right,target);
        }else{
            return true;
        }
    }
    public static int max(Node node ){
        if(node.right == null){
            return node.data;
        }else{
            return max(node.right);
        }
    }
    public static int min(Node node){
        if(node.left == null){
            return node.data;
        }else{
            return min(node.left);
        }
    }
    public static int size(Node node){
        if(node == null) return  0 ;
        int ln = size(node.left);
        int rn = size(node.right);
        return ln + rn + 1;
    }
    public static int sum(Node node){
        if(node == null) return 0;
        int ls = sum(node.left);
        int rs = sum(node.right);
        return ls + rs + node.data;

    }
    static int sum = 0;
//    public static void replaceSumOfLargestBST(Node node){
//        if(node == null) return;
//        replaceSumOfLargestBST(node.right);
//        int od = node.data;
//        node.data = sum;
//        sum += od;
//        replaceSumOfLargestBST(node.left);
//    }
    public static Node addNode(Node node , int val){
        if(node == null) return new Node(val,null,null);
        if(node.data > val){
            node.left = addNode(node.left,val);
        }else if(node.data < val){
            node.right = addNode(node.right,val);
        }
        return node;
    }
    public static Node removeNode(Node node , int val){
        if(node == null) return null;
        if(node.data > val){
           node.left = removeNode(node.left,val);
        }else if(node.data < val){
            node.right = removeNode(node.right , val);
        }else{
            if(node.left != null && node.right != null){
                int lmax = max(node.left);
                node.data = lmax;
                removeNode(node,lmax);

            }else if(node.left != null){
                return node.left;
            }else if(node.right !=null){
                return node.right;
            }else{
                return null;
            }
        }
        return node;
    }
    public static void replaceSumOFBST(Node node){
        if(node == null) return;
        replaceSumOFBST(node.right);
        int od = node.data;
        node.data = sum;
        sum += od;
        replaceSumOFBST(node.left);
    }
    public static int lca(Node node , int d1 , int d2){
        if(node.data > d1 && node.data > d2){
            return lca(node.left,d1,d2);
        }else if(node.data < d1 && node.data < d2){
            return lca(node.right,d1,d2);
        }else{
            return node.data;
        }

    }
    public static void pir(Node node, int lb , int rb){
        if(node == null) return;
        if(lb > node.data ){
            pir(node.right,lb,rb);
        }else if(rb < node.data){
            pir(node.left,lb,rb);
        }else{
            pir(node.left,lb,rb);
            System.out.print(node.data + " --> ");
            pir(node.right,lb,rb);

        }
    }
    public static void targetSum(Node root , Node node , int target){
        if(node == null) return;
        targetSum(root,node.left,target);
        int complement = target - node.data;
        if(node.data < target) {
            if (find(root, complement)) {
                System.out.println(node.data + " - " + complement);
            }
        }
        targetSum(root,node.right,target);
    }

    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87};
        Node root = construct(arr,0,arr.length - 1);
        display(root);
//        pir(root,20,70);

        targetSum(root,root,112);
    }
}
