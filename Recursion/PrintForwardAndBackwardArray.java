package Recursion;

public class PrintForwardAndBackwardArray {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        printForward(arr,0);
    }

    public static void printForward(int[] arr,int idx){
        if(idx == arr.length) return;
        System.out.print(arr[idx] + " \t ");
        printForward(arr,idx + 1);
    }
    public static void printBackward(int[] arr,int idx){
        if(idx == arr.length) return;
        printBackward(arr,idx + 1);
        System.out.print(arr[idx] + " \t ");
    }
}
