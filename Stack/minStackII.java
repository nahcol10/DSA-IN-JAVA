package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class minStackII {
    public  static class MinStack{
        Stack<Integer> ms = new Stack<>();
        int min;
        void push(int val){
            if(ms.isEmpty()){
                min = val;
                ms.push(val);
            }else if(val < min){
                int calc = 2 * val - min;
                ms.push(calc);
                min = val;
            }else {
                ms.push(val);
            }
        }
        void pop(){
            int x = ms.pop();
            if(x > min){
                System.out.println(x);
            }else{
                System.out.println(min);
                min = 2 * min - x;
            }
        }
        void top(){
            if(ms.peek() > min){
                System.out.println(ms.peek());
            }else{
                System.out.println(min);
            }
        }
        void size(){
            System.out.println(ms.size());
        }
    }
    public static  void main(String[] args){
        MinStack ms = new MinStack();
        ms.push(10);
        ms.push(5);
        ms.push(3);
        ms.push(8);
        ms.push(11);
        ms.pop();
        ms.pop();
        ms.pop();
        int min = ms.min;
        System.out.println(min);

    }
}
