
/* 백준 2156 포도주 시식
* */

import java.util.Scanner;

public class algo_2156 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n+1];

        for(int i = 1; i <= n; i++)
            array[i] = scan.nextInt();

        int[] dp = new int[n+1];
        dp[1] = array[1]; //잔이 1개인 경우 1개 마시면 됨
        if(n > 1){
            dp[2] = array[1]+array[2]; //잔이 2개인 경우 2개 다 마시면 됨
            for(int i = 3; i <= n; i++){ //잔이 3개 이상인 경우
                //마지막 잔에 왔을 때 그 잔을 안 마셨느냐, 1개 연속 마셨느냐, 2개 연속 마셨느냐 중 가장 큰 값을 고름
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+array[i], dp[i-3]+array[i-1]+array[i]));
            }
        }

        System.out.println(dp[n]);
    }
}
