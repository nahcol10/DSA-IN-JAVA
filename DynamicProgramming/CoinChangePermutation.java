package DynamicProgramming;

import java.util.Scanner;

public class CoinChangePermutation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of element of an array : ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("enter the element of an array : ");
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = sc.nextInt();
        }
        System.out.println("enter the amount : ");
        int amount = sc.nextInt();
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 1 ; i < dp.length ; i++){
            for(int coin : coins){
                if(coin <= i){
                    int ramt = Math.abs(coin - i);
                    dp[i] += dp[ramt];
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
    }
}
