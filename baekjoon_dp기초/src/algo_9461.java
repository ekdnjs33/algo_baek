
/* 백준 9461 파도반 수열
* */

import java.util.Scanner;

public class algo_9461 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        long[] P = new long[101];
        for(int i = 1; i <= 5; i++){
            if(i < 4){
                P[i] = 1;
            }else
                P[i] = 2;
        }
        for(int i = 0; i < T; i++){
            int N = scan.nextInt();
            if(N > 5){
                for(int j = 6; j <= N; j++){
                    P[j] = P[j-5]+P[j-1];
                }
            }
            System.out.println(P[N]);
        }
    }
}
