
/* 백준 10844 쉬운 계단 수
 * 다시 공부하기 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class algo_10844 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long[][] dp = new long[101][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0)
                    dp[i][j] = dp[i-1][j+1];
                else if (j == 9)
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum % 1000000000);

        /*Queue<Long> q = new LinkedList<>();

        for (Long i = 1L; i < 10L; i++)
            q.add(i);

        int cnt = 0;
        while(true){
            int num = 0;
            long b = q.poll();
            long a = b;

            while(a > 0){
                num++;
                a = a/10;
            }

            long c = b%10;
            if(c == 0)
                q.add(b*10+c+1);
            else if(c == 9)
                q.add(b*10+c-1);
            else{
                q.add(b*10+c-1);
                q.add(b*10+c+1);
            }

            if(num == N)
                cnt++;
            else if(num == N+1)
                break;
        }
        System.out.println(cnt);*/
    }
}
