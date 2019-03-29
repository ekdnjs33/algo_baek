
/* 백준 2775 부녀회장이 될테야
* */

import java.util.Scanner;

public class algo7_2775 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] test = new int[T];

        for(int i = 0; i < T; i++){
            int k = scan.nextInt();
            int n = scan.nextInt();
            int[][] apart = new int[15][15];


            for(int j = 1; j <15; j++){
                apart[0][j] = j;
            }
            for(int j = 1; j <= k; j++){
                for(int m = 1; m <= n; m++){
                    for(int l = 1; l <= m; l++) {
                        apart[j][m] += apart[j-1][l];
                    }
                }
            }
            test[i] = apart[k][n];
        }
        for(int i = 0; i < T; i++)
            System.out.println(test[i]);
    }
}
