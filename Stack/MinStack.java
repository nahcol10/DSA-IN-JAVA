package Stack;

import java.util.Stack;

public class MinStack {
    public static class Minstack{
        Stack<Integer> mst = new Stack<>();
        Stack<Integer> minSt = new Stack<>();

        void push(int val){
            mst.push(val);
            if(minSt.isEmpty()){
                minSt.push(val);
            }
            if(val < minSt.peek()){
                minSt.push(val);
            }
        }
        void pop(){
            if(minSt.peek() != mst.peek()){
                int x = mst.pop();
                System.out.println(x);
            }else{
                int x = mst.pop();
                minSt.pop();
                System.out.println(x);
            }
        }
        void size(){
            System.out.println(mst.size());
        }
        void top(){
            System.out.println(mst.peek());
        }
        void min(){
            System.out.println(minSt.peek());
        }

    }
    public static void main(String[] args){
        Minstack st = new Minstack();
        st.push(5);
        st.push(3);
        st.push(11);
        st.push(8);
        st.push(7);
        st.push(2);
        st.push(9);
        st.push(1);

        st.min();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.min();
    }
}
