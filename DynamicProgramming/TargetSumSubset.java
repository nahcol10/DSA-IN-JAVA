package DynamicProgramming;

import java.util.Scanner;

public class TargetSumSubset {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of an array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the element of an array : ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target : ");
        int target = sc.nextInt();
        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j  < dp[0].length ; j++){
                if(i == 0 && j==0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if(j == 0){
                    dp[i][j] = true;
                }else{
                    if(dp[i - 1][j]){
                        dp[i][j] = true;
                    }else{
                        int val = arr[i - 1];
                        if(j >= val){
                            if(dp[i - 1][val - 1]){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[arr.length][target]);
    }
}
