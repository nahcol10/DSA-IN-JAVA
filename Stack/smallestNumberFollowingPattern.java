package Stack;

import java.util.Scanner;
import java.util.Stack;

public class smallestNumberFollowingPattern {
    public  static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string");
        String str = sc.next();
        Stack<Integer> st = new Stack<>();
        int idx = 1;
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(ch == 'd'){
                st.push(idx);
                idx++;
            }else{
                st.push(idx);
                idx++;
                while(!st.isEmpty()){
                    System.out.print(st.pop() + "\t");
                }
            }

        }
        st.push(idx);
        while(!st.isEmpty()){
            System.out.print(st.pop() + "\t");
        }
    }
}
