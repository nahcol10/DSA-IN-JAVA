package Recursion;

public class MaximumOfArray {
    public static void main(String[] args){
        int[] arr = {2,3,299,3,23};
        int ans = findMax(arr,0);
        System.out.println(ans);
    }
    public static int findMax(int[] arr, int idx){
        if(idx == arr.length) return Integer.MIN_VALUE;
        int max = findMax(arr,idx + 1);
        max = Math.max(max,arr[idx]);
        return max;
    }
}
