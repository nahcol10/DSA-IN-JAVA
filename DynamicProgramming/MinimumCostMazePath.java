package DynamicProgramming;

import java.util.Scanner;

public class MinimumCostMazePath {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of row : ");
        int row = sc.nextInt();
        System.out.print("enter the number of col : ");
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[row][col];
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            for(int j = arr[0].length - 1 ; j >= 0 ; j--){
                if(i == arr.length - 1 && j == arr[0].length - 1){
                    dp[i][j] = arr[i][j];
                }else if(i == arr.length -1){
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                }else if(j == arr[0].length -1){
                    dp[i][j] = dp[i+1][j] + arr[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i][j + 1],dp[i + 1][j]) + arr[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
