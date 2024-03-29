package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairsWithJump {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of stairs : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the jumps : ");
        for(int i = 0 ; i < n  ; i++){
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = 1 ;  j <= arr[i] && i + j < dp.length ; j++){
                dp[i] += dp[i + j];
            }
        }
        System.out.println(dp[0]);
    }
}
