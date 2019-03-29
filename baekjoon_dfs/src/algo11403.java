
/* 백준 11403 경로 찾기
 * 런타임 에러
 * */

import java.util.Scanner;

public class algo11403 {
    public static int[][] data;
    public static int N;
    public static int[][] array;

    static void dfs(int row, int col){
        if(row != col) {
            for (int i=0; i<N; i++) {
                if (data[col][i] == 1) {
                    dfs(row, i);
                }
            }
        }
        array[row][col] = 1; //row에서 col로 가는 간선이 있음을 표시
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        N = stdIn.nextInt();
        data = new int[N][N];
        array = new int[N][N];

        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                data[i][j] = stdIn.nextInt();
            }
        }

        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(data[i][j] == 1){
                    data[i][j] = 2; //방문 했음을 표시
                    dfs(i, j);
                    data[i][j] = 1; //원상 복구
                }
            }
        }

        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.printf("\n");
        }
    }
}

