
/* 백준 6064 카잉 달력
 * 시간 초과
 * */

import java.util.Scanner;

public class algo9_6064 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] test = new int[T];

        for (int i = 0; i < T; i++) {
            int M = scan.nextInt();
            int N = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();

            int lcmN = LCM(M, N);

            while(x != y && x <= lcmN){ //최대공배수일 때까지만 돌거야
                if (x < y) x += M; //x, y 번갈아 가면서 확인
                else y += N;
            }
            if(x != y)
                test[i] = -1;
            else
                test[i] = x; //x=y 경우

            /*int m = 1;
            int n = 1;
            int cnt = 1;
            while (m != M || n != N) {
                if (m == x && n == y) {
                    test[i] = cnt;
                    break;
                }
                if (m == M) {
                    m = 0;
                }
                if (n == N) {
                    n = 0;
                }
                m++;
                n++;
                cnt++;
            }
            if (m == M && n == N)
                test[i] = -1;*/

        }
        for (int i = 0; i < T; i++)
            System.out.println(test[i]);
    }

    public static int LCM(int n, int m) { //최소공배수
        int a = m;
        int b = n;
        int tmp;
        while (b > 0) { //최대공약수 구한 뒤에
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return (m * n) / a; //서로 곱해서 최대공약수로 나누면 최소공배수가 된다.
    }
}
