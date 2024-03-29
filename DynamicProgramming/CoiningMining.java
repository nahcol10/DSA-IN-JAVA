package DynamicProgramming;

import java.util.Scanner;

public class CoiningMining {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the row of matrix : ");
        int row = sc.nextInt();
        System.out.println("enter the column of matrix : ");
        int col = sc.nextInt();
        System.out.println("enter the element of an array : ");
        int[][] arr = new int[row][col];
        for(int i = 0 ; i  < row ; i++){
            for(int j = 0 ; j < col ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] dp  = new int[row][col];
        for(int j = arr[0].length - 1 ; j >= 0 ; j--){
            for(int i = arr.length - 1; i >=0 ; i--){
                if(j == arr[0].length -1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + arr[i][j];
                }
                else if( i == arr.length - 1){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i -1][j+1]) + arr[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1])) + arr[i][j];
                }
            }
        }

        for(int i = 0 ; i  < row ; i++){
            for(int j = 0 ; j < col ; j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        int max = dp[0][0];
        for(int i = 1 ; i < dp.length ; i++){
            if(max < dp[i][0]) {
                max = dp[i][0];
            }
        }
        System.out.println(max);
    }
}
