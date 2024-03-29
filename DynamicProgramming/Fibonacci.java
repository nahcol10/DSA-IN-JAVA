package DynamicProgramming;
//memoization
public class Fibonacci {
    public static int fibonacci(int n,int[] qb){
        if(n == 0 || n == 1) return qb[n] = n;
        if(qb[n] != 0){
            return qb[n];
        }
        else {
            int f1 = fibonacci(n - 1, qb);
            int f2 = fibonacci(n - 2, qb);
            int fn = f1 + f2;
            qb[n] = fn;
            System.out.println(fn);
            return fn;
        }
    }
    public static void main(String[] args){
        int[] arr = new int[6];
        fibonacci(5,arr);
    }
}
