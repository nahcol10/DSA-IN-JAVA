import java.util.*;
public class binaryTree{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        Node(){
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
        Node root = new Node(arr[0],null,null);
        pair rtp = new pair(root,1);

        Stack<pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while(st.size() > 0)
        {
            pair top = st.peek();
            idx++;
            if(top.state == 1)
            {
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx],null,null);
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
                    top.node.right = new Node(arr[idx],null,null);
                    pair lp = new pair(top.node.right,1);
                    st.push(lp);
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
    public static Integer size(Node node){
        if(node == null){ return 0 ;}
            int lcs = size(node.left);
            int rcs = size(node.right);
            int size = lcs + rcs + 1;
            return size;
        
    }
    public static Integer sum(Node node){
        if(node == null){ return 0; }
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        int sum = lsum + rsum + node.data;
        return sum;
    }
    public static Integer max(Node node){
        if(node == null) return 0;
        int rmax = max(node.right);
        int lmax = max(node.left);
        int max = Math.max(node.data,Math.max(rmax,lmax));
        return max;
    }
    public static Integer height(Node node){
        if(node == null) return 0;
        int rheight = height(node.right);
        int lheight = height(node.left);
        int ht = Math.max(rheight,lheight) + 1;
        return ht;
    }
    public static void lineTraversal(Node node){
        Queue<Node> mQ = new ArrayDeque<>();
        mQ.add(node);
        while(mQ.size() > 0)
        {
            int size = mQ.size();
            for(int i = 0 ; i < size ; i++)
            {
                node = mQ.remove();
                System.out.print(node.data + " ");
                if(node.left != null) mQ.add(node.left);
                if(node.right != null) mQ.add(node.right);
            }
            System.out.println();
        }   
    }
    public static boolean find(Node node , int target){
        if(node == null) return false;
        if(node.data == target) return true;
        boolean lcheck = find(node.left,target);
        if(lcheck == true) return true;
        boolean rcheck = find(node.right,target);
        if(rcheck == true) return true;
        return false;
        
    }
    public static ArrayList<Node> rootToNode(Node node,int target){
        if(node == null) return new ArrayList<>();
        if(node.data == target){
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }
        ArrayList<Node> rctn = rootToNode(node.right,target);
        if(rctn.size() > 0){
            rctn.add(node);
            return rctn;
        }
        ArrayList<Node> lctn = rootToNode(node.left,target);
        if(lctn.size() > 0){
            lctn.add(node);
            return lctn;
        }
        return new ArrayList<>();
    }
    public static void kLevelDown(Node node,int k,Node blocker){
        if(node == null || k < 0 || node == blocker) return;
        if(k==0) System.out.println(node.data);
        kLevelDown(node.left,k-1,blocker);
        kLevelDown(node.right,k-1,blocker);
    }
    public static ArrayList<Node> kDistanceAway(Node node,int target , int k){
        ArrayList<Node> path = rootToNode(node,target);
        for(int i = 0 ; i < path.size() ; i++){
            kLevelDown(path.get(i),k - i,i == 0 ? null : path.get(i - 1));
        }
        return path;
    }
    public static void leafFromRoot(Node node , String path ,int sum, int lo , int hi){
        if(node == null) return;
        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum >= lo && sum <= hi){
                System.out.println(path + node.data);
            }
            return;
        }
        leafFromRoot(node.left,path + node.data + " ",sum + node.data,lo,hi);
        leafFromRoot(node.right,path + node.data + " ",sum + node.data,lo,hi);
    }
    public static Node transformToLeftClonedTrees(Node node){
        if(node == null) return null;
        Node lcr = transformToLeftClonedTrees(node.left);
        Node rcr = transformToLeftClonedTrees(node.right);
        Node new_node = new Node();
        new_node.data = node.data;
        new_node.left = lcr;
        new_node.right = null;

        node.left = new_node;
        node.right = rcr;
        return node;
    }
    public static Node transformBackFromLeftClonedTrees(Node node){
        if(node == null) return null;
        Node lnn = transformBackFromLeftClonedTrees(node.left.left);
        Node rnn = transformBackFromLeftClonedTrees(node.right);
        node.left = lnn;
        node.right = rnn;
        return node;
    }
    public static void printSingleChildNode(Node node , Node parents){
        if(node == null) return;
        if(parents != null && parents.left != null && parents.right == null) 
        System.out.print(node.data);
        else if(parents != null && parents.left == null && parents.right != null) 
        System.out.print(node.data);
        printSingleChildNode(node.left,node);
        printSingleChildNode(node.right,node);
    }
    public static Node removeLeavesNode(Node node){
        if(node == null) return null;
        if(node.left == null && node.right == null) return null;
        node.left = removeLeavesNode(node.left);
        node.right = removeLeavesNode(node.right);
        return node;
    }
    public static int diameterOfBinarayTree(Node node){
        if(node == null) return 0;
        int ld  = diameterOfBinarayTree(node.left);
        int rd = diameterOfBinarayTree(node.right);
        int ht = height(node.left) + height(node.right) + 2;
        int ans = Math.max(ht,Math.max(ld,rd));
        return ans - 1;
    }

    public static void main(String[] args)
    {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Node root = constructBT(arr);
        // display(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(max(root));
        // System.out.println(height(root));
        // lineTraversal(root);
        // System.out.println(rootToNode(root,70));
        // kLevelDown(root,2);
        // leafFromRoot(root,"",0,1,200);
        // Node ans = transformToLeftClonedTrees(root);
        // display(ans);
        // System.out.println();
        // Node result = transformBackFromLeftClonedTrees(root);
        // display(result);        
        // printSingleChildNode(root,null);
        display(root);
        System.out.println(diameterOfBinarayTree(root));
        
    }
}

