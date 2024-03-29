package Stack;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;
import java.util.Stack;

public class buildNormalStack {
    public  static  class Stack{
        int[] data;
        int idx = -1;
        Stack(int capacity){
            data = new int[capacity];
        }
        void push(int val){
            if(idx < data.length){
                idx++;
                data[idx] = val;
            }
            else{
                System.out.println("Stack overflow");
            }
        }
        void pop(){
            if(idx == 0){
                System.out.println("Stack underflow");
            }else{
                System.out.println(data[idx]);
                idx--;
            }
        }
        void top(){
            System.out.println(data[idx]);
        }
        void size(){
            System.out.println(++idx);
        }
        void display(){
            for(int i = idx; i >= 0 ; i--){
                System.out.print(data[i] + "-->");
            }
            System.out.println();
        }
    }


    public static  void main(String[] args){
        int n = 5;
        Stack st = new Stack(n);
        st.push(10);
        st.push(11);
        st.push(12);
        st.push(13);
        st.push(15);
        st.display();
        st.pop();
        st.pop();
        st.top();
        st.top();
        st.display();
        st.size();
    }
}
