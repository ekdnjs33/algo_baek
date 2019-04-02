
/* 백준 1912 연속합
 * */

import java.util.Scanner;

public class algo_1912 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] array = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            array[i] = scan.nextInt();
        }
        /*int[] dp = new int[N + 1];
        int best = array[1];
        dp[1] = array[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            best = Math.max(dp[i], best);
        }
        System.out.println(best);*/

        int[][] dp = new int[N + 1][2];
        if(array[1] < 0){
            dp[1][0] = array[1];
        }
        else{
            dp[1][1] = array[1];
            dp[1][0] = array[1];
        }

        for (int i = 2; i <= N; i++) {
            if (array[i] < 0) {
                if (dp[i - 1][1] + array[i] < 0) {
                    dp[i][0] = Math.max(dp[i - 1][0], array[i]);
                    //System.out.println(dp[i][1] + " =" + dp[i][0]);
                } else {
                    dp[i][1] = dp[i - 1][1] + array[i];
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i][1]);
                    //System.out.println(dp[i][1] + " =" + dp[i][0]);
                }

            } else {
                dp[i][1] = dp[i - 1][1] + array[i];
                dp[i][0] = Math.max(dp[i - 1][0], dp[i][1]);
                //System.out.println(dp[i][1] + " =" + dp[i][0]);
            }
        }
        System.out.println(dp[N][0]);
    }
}
