package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the element of the tower : ");
        int n = sc.nextInt();
        String t1 = sc.next();
        String t2 = sc.next();
        String t3 = sc.next();
        towerOfHanoi(n,t1,t2,t3);
    }

    private static void towerOfHanoi(int n , String t1, String t2, String t3) { // t1 -> source , t2 -> dest , t3 -->helper
        if( n == 0) return;
        towerOfHanoi( n -1 , t1,t3,t2);
        System.out.println(n + " : " + t1 + "-->" + t2);
        towerOfHanoi(n-1,t3,t2,t1);
    }
}
