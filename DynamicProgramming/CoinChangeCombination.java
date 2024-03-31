package DynamicProgramming;

import java.util.Scanner;

//public class CoinChangeCombination {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number of element of an array :");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        System.out.println("Enter the element of an array : ");
//        for(int i = 0 ; i < arr.length ; i++){
//            arr[i] = sc.nextInt();
//        }
//        System.out.println("enter the target : ");
//        int target = sc.nextInt();
//        int[][] dp = new int[arr.length + 1][target + 1];
//        for(int i = 0 ; i < dp.length ; i++){
//            for(int j = 0 ; j < dp[0].length ; j++){
//                if(i == 0 && j == 0){
//                    dp[i][j] = 1;
//                }else if(i == 0){
//                    dp[i][j] = 0;
//                }else if(j == 0){
//                    dp[i][j] = 1;
//                }else{
//                    if(j >= arr[i - 1]){
//                        dp[i][j] = dp[i-1][j] + dp[i][j - arr[i - 1]];
//                    }else{
//                        dp[i][j] = dp[i-1][j];
//                    }
//                }
//            }
//        }
//        System.out.println(dp[arr.length][target]);
//    }
//}

public class CoinChangeCombination {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element of an array :");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the element of an array : ");
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = sc.nextInt();
        }
        System.out.println("enter the target : ");
        int amount = sc.nextInt();
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = 1 ; i < dp.length ; i++){
                if(coin <= i){
                    int ramt = Math.abs(coin - i);
                    dp[i] += dp[ramt];
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
    }
}
