package BinarySearchTree;

public class BSTconstruct {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node constructor(int[] arr, int lo , int hi){
        if(lo > hi) return null;
        int mid = lo + (hi - lo)/2;
        int data = arr[mid];
        Node ln = constructor(arr,lo,mid - 1);
        Node rn = constructor(arr,mid + 1, hi);
        return new Node(data,ln,rn);
    }
    public  static  void  display(Node node){
        if(node == null) return;
        String str = "";
        str += (node.left==null)? '.' : node.left.data +  " ";
        str += " <--- " + node.data + " ---> ";
        str += (node.right == null)?'.': node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static int max(Node node){
        if(node == null) return Integer.MIN_VALUE;
        int max = node.data;
        int rn = max(node.right);
        if(max < rn) {
            max = rn;
        }
        return max;
    }
    public static int min(Node node){
        if(node == null) return  Integer.MAX_VALUE;
        int min = node.data;
        int ln = min(node.left);
        if(min > ln) min = ln;
        return min;
    }
    public static int sum(Node node){
        if(node == null) return 0;
        int ln = sum(node.left);
        int rn = sum(node.right);
        return ln + rn + node.data;
    }
    public static int size(Node node){
        if(node == null) return 0;
        int ln = size(node.left);
        int rn = size(node.right);
        return ln + rn + 1;
    }
    public static boolean find(Node node,int target){
        if(node == null) return false;
        if(node.data == target) return true;
        boolean ln = find(node.left,target);
        boolean rn = find(node.right,target);
        return ln || rn;
    }
    public static Node addNode(Node node , int val){
        if(node == null) return new Node(val,null,null);
        if(node.data > val){
            node.left = addNode(node.left,val);
        }else if(node.data < val){
            node.right = addNode(node.right,val);
        }else{
            // do nothing
        }
        return node;
    }

    public static  void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87};//enter the sorted array
        Node root = constructor(arr,0,arr.length -1 );
        display(root);
        addNode(root,100);
        display(root);

    }
}
