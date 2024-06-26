package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairsMinimumMoves {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of stairs :");
        int n  = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the frequencies of stairs :");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(arr[i] > 0){
                int min = Integer.MAX_VALUE;
                for(int j = 1 ; j <= arr[i] && i + j < dp.length ; j++){
                    if(dp[i + j] != null){
                        min = Math.min(min,dp[i + j]);
                    }
                }
                if(min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);
    }
}
