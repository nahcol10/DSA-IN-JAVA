package DynamicProgramming;

public class ClimbingStairs {
    public static int Pathcount(int n , int[] qb){
        if(n == 0){
            return 1;
        }else if(n < 0) {
            return 0;
        }
        if(qb[n] > 0){
            return qb[n];
        }
        int path1 = Pathcount(n - 1 , qb);
        int path2 = Pathcount(n - 2 , qb);
        int path3 = Pathcount(n - 3 , qb);
        int count = path1 + path2 + path3;
        qb[n] = count;
        return count;

    }
    public static int PathcountTablular(int n,int[] qb){
        qb[0] = 1;
        for(int i = 1 ; i <= n ; i++) {
            if (i == 1) {
                qb[i] = qb[i - 1];
            } else if (i == 2) {
                qb[i] = qb[i - 1] + qb[i - 2];
            } else if (i > 2) {
                qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
            }
        }
        return qb[n];
    }
    public static void main(String[] args){
        int n = 10;
        int ans = PathcountTablular(n,new int[n + 1]);
        System.out.println(ans);
    }
}
