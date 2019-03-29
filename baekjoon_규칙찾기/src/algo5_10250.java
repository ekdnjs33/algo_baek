
/* 백준 10250 ACM 호텔
 * 출력 때문에 시간 버림 */

import java.util.Scanner;

public class algo5_10250 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] array = new int[T];

        for (int i = 0; i < T; i++) {
            int H = scan.nextInt();
            int W = scan.nextInt();
            int N = scan.nextInt();

            int cnt = 0;
            for (int j = 1; j <= W; j++) {
                for (int k = 1; k <= H; k++) {
                    cnt++;
                    if (N == cnt) {
                        array[i] = k*100+j;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < T; i++){
            System.out.println(array[i]);
        }
    }

}
