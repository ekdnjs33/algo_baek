
/* 백준 6603 로또
 * */

import java.util.Scanner;

public class algo6603 {
    public static int[] output;
    public static int[] input;
    public static int k;

    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i=0; i<6; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i=start; i<k; i++) {
            output[depth] = input[i];
            dfs(i+1, depth+1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            k = scanner.nextInt();

            if(k == 0)
                break;

            input = new int[k];
            output = new int[6];

            for (int i=0; i<k; i++) { //입력받은 번호
                input[i] = scanner.nextInt();
            }

            dfs(0, 0);
            System.out.println();
        }

    }

}
