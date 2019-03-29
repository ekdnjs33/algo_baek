
/* 백준 1012 유기농 배추
* 런타임 에러
* */

import java.util.Scanner;

public class algo1012 {
    public static int[][] array;
    public static int n, m;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(); //테스트 케이스

        int[] two = new int[k];

        for(int i = 0; i < k; i++){
            n = scan.nextInt(); //가로
            m = scan.nextInt(); //세로
            int t = scan.nextInt(); //총 배추 위치 개수
            array = new int[m][n];

            for(int j = 0; j < t; j++) {
                int x = scan.nextInt(); // nextInt를 구글링 해보기
                int y = scan.nextInt();
                array[y][x] = 1;
            }
            two[i] = danjiNum();
        }

        for(int i = 0; i < k; i++)
            System.out.println(two[i]);
    }

    public static void dfs(int i, int j){
        array[i][j] = 2;

        if((j - 1) >= 0 && array[i][j - 1] == 1) //왼쪽
            dfs(i, j - 1);
        if((j + 1) < n && array[i][j + 1] == 1) //오른쪽
            dfs(i, j + 1);
        if((i - 1) >= 0 && array[i - 1][j] == 1) //위쪽
            dfs(i - 1, j);
        if((i + 1) < m && array[i + 1][j] == 1) //아래쪽
            dfs(i + 1, j);
    }

    public static int danjiNum(){
        int danji = 0;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(array[i][j] == 1){
                    dfs(i, j);
                    danji++;
                }
        return danji;
    }
}

