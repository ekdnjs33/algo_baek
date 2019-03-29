
/* 백준 1932 정수 삼각형
* */

import java.util.Scanner;

public class algo_1932 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] array = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                array[i][j] = scan.nextInt();
            }
        }

        System.out.println(LIS(n, array));
    }
    public static int LIS(int n, int[][] a){
        int[][] dp = new int[n][n];
        dp[0][0] = a[0][0];
        int max = 0;

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < i+1; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], a[i+1][j]+dp[i][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], a[i+1][j+1]+dp[i][j]);
            }
        }

        for(int i = 0; i < n; i++){
            if(max < dp[n-1][i])
                max = dp[n-1][i];
        }

        return max;
    }
}
