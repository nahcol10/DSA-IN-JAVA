package Stack;

import java.util.ArrayList;

public class BuildADynamicStack {
    public static class Stack{
       ArrayList<Integer> al = new ArrayList<>();
       int size = 0;
       void push(int val){
           al.add(val);
           size++;
       }
       void top(){
           System.out.println(al.get(size - 1));
       }
       void size(){
        System.out.println(size);
       }
       void pop(){
        top();
        size--;
       }
       void display(){
        for(int i = 0 ; i < size; i++){
            System.out.print(al.get(i) + "-->");
        }
        System.out.println();
       }
    }
    public  static  void main(String[] args){
        Stack st = new Stack();
        st.push(10);
        st.push(11);
        st.push(12);
        st.push(13);
        st.push(14);
        st.display();
        st.size();
        st.pop();
        st.pop();
        st.display();
        st.top();
    }
}
