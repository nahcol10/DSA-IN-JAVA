package BinarySearchTree;

public class removeNodeInBST {
    public  static  class Node{
        int data;
        Node left;
        Node right;
        Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node construct(int[] arr, int lo , int hi){
        if(lo > hi) return null;
        int mid = (lo + hi)/2;
        int data = arr[mid];
        Node ln = construct(arr,lo,mid - 1);
        Node rn = construct(arr,mid + 1 , hi);
        return  new Node(data,ln,rn);
    }
    public  static void display(Node node){
        if(node == null) return;
        String str = "";
        str += (node.left == null)? '.':node.left.data + " ";
        str+= " <--- " + node.data + " ---> ";
        str+= (node.right == null)? " ." : node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static Node addNode(Node node,int val){
        if(node == null) return new Node(val,null,null);
        if(node.data < val){
            node.right = addNode(node.right,val);
        }else if (node.data > val){
            node.left = addNode(node.left,val);
        }else{
            // do nothing
        }
        return node;
    }
    public  static int max(Node node){
        if(node != null){
            return max(node.right);
        }else {
            return node.data;
        }
    }
    public static Node removeNode(Node node,int val){
        if(node.data > val){
            node.left = removeNode(node.left,val);
        }else if(node.data < val){
            node.right = removeNode(node.right,val);
        }else{
            if(node.left != null && node.right != null){
                int lmax = max(node.left);
                node.data = lmax;
                removeNode(node,lmax);
            }else if(node.left != null){
                return node.left;
            }else if(node.right != null){
                return node.right;
            }else{
                return null;
            }
        }
        return node;
    }
    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87};
        Node root = construct(arr,0,arr.length - 1);
        display(root);
        System.out.println();
        System.out.println();
        addNode(root,11);
        display(root);
        removeNode(root,11);
        System.out.println();
        System.out.println();
        display(root);
    }
}
