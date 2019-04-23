
/* 백준 10216 Count Circle Groups
* */

import java.util.Scanner;

public class algo_10216 {
    public static int[][] array;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        array = new int[5010][5010]; //0 <= x,y <= 5000
        for(int i = 0; i < T; i++){
            int N = scan.nextInt(); //1 <= N <= 3000
            for(int j = 0; j < N; j++){
                int x = scan.nextInt();
                int y = scan.nextInt();
                int R = scan.nextInt(); //0<= R <= 5000
                for(int k = x-R; k <= x+R; k++){
                    for(int l = y-R; l <= y+R; l++){
                        if(k >= 0 && l >= 0 && k <= 5000 && l <= 5000 && array[k][l] == 0){
                            array[k][l] = 1;
                        }
                    }
                }
            }
            int group = 0;
            for(int j = 0; j <= 5000; j++){
                for(int k = 0; k <= 5000; k++){
                    if(array[j][k] == 1){
                        System.out.print(j +", "+k);
                        group++;
                        dfs(j, k);
                    }
                }
            }
            System.out.println(" group: "+group);
            /*System.out.println();
            for(int k = 0; k < 200; k++){
                for(int j = 0; j < 200; j++){
                    System.out.print(array[k][j]+ " ");
                }
                System.out.println();
            }*/
        }

    }
    static void dfs(int row, int col){
        if(array[row][col] == 0 || array[row][col] == 2) //0 이거나 방문한(2) 경우 pass
            return;

        array[row][col] = 2; //방문 했음을 표시

        if((col-1) >= 0 && array[row][col-1] == 1) { //왼쪽
            dfs(row, col - 1);
        }
        if((col+1) <= 5000 && array[row][col+1] == 1) { //오른쪽
            dfs(row, col + 1);
        }
        if((row-1) >= 0 && array[row-1][col] == 1) { //위쪽
            dfs(row - 1, col);
        }
        if((row+1) <= 5000 && array[row+1][col] == 1) { //아래쪽
            dfs(row + 1, col);
        }
    }
}
