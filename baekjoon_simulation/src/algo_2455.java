
/* 백준 2455 지능형 기차
* */

import java.util.Scanner;

public class algo_2455 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n; //내리는 사람
        int m; //타는 사람
        int total = 0; //총 탄사람
        int max = 0; //가장 많이 탄 사람 수

        for (int i = 0; i < 4; i++) {
            n = scan.nextInt();
            m = scan.nextInt();
            total = total - n + m;

            if (total > max)
                max = total;
        }
        System.out.print(max);
    }

}
