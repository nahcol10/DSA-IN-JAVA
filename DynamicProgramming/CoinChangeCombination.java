package DynamicProgramming;

import java.util.Scanner;

public class CoinChangeCombination {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element of an array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the element of an array : ");
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the target : ");
        int target = sc.nextInt();
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0 ; i < arr.length; i++)        {
            for(int j  = arr[i] ;  j < dp.length ; j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[target]);

    }
}
