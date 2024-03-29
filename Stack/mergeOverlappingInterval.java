package Stack;

import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class mergeOverlappingInterval {
    public static class  Pair implements  Comparable<Pair>{
        int st;
        int et;
        Pair(int st , int et){
            this.st = st;
            this.et = et;
        }
        public int compareTo(Pair other) {
            return this.st - other.st;
        }
    }
    public  static void mergeOverlappingIntervals(int[][] arr){
        Pair[] pairs = new Pair[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            pairs[i] = new Pair(arr[i][0],arr[i][1]);
        }

        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);
        for(int i = 1 ; i < pairs.length ; i++){
            Pair top = st.peek();
            if(top.et < pairs[i].st){
                st.push(pairs[i]);
            }else{
                top.et = Math.max(top.et , pairs[i].st);
            }
        }
        while (!st.isEmpty()){
            Pair P = st.pop();
            System.out.println(P.st + " "+ P.et);
        }
    }
    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of interval : ");
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        mergeOverlappingIntervals(arr);



    }
}
