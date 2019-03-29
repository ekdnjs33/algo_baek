
/* 백준 10026 적록색약
 * */

import java.util.Scanner;

public class algo10026 {
    public static int[][] array;
    public static int[][] visit;
    public static int k;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        k = scan.nextInt();
        array = new int[k][k];
        visit = new int[k][k];
        
        for(int i = 0; i < k; i++) {
            String c = scan.next();
            for(int j = 0; j < k; j++) {
                array[i][j] = c.charAt(j);
            }
        }
        //정상의 경우
        danjiNum();

        for(int i = 0; i < k; i++) //R->G 으로 변경, 재배열
            for(int j = 0; j < k; j++){
                if (array[i][j] == 'R')
                    array[i][j] = 'G';
                visit[i][j] = 0;
            }
        //적록색약의 경우
        danjiNum();
    }

    public static void dfs(int i, int j, int[][] check){
        check[i][j] = 1;
        
        if((j - 1) >= 0)
            if(array[i][j - 1] == array[i][j] && check[i][j-1] == 0) //왼쪽
                dfs(i, j - 1, check);
        if((j + 1) < array.length)
            if(array[i][j + 1] == array[i][j] && check[i][j+1] == 0) //오른쪽
                dfs(i, j + 1, check);
        if((i - 1) >= 0)
            if(array[i - 1][j] == array[i][j] && check[i-1][j] == 0) //위쪽
                dfs(i - 1, j, check);
        if((i + 1) < array.length)
            if(array[i + 1][j] == array[i][j] && check[i+1][j] == 0) //아래쪽
                dfs(i + 1, j, check);
    }

    public static void danjiNum(){
        int danji = 0;
        for(int i = 0; i < k; i++)
            for(int j = 0; j < k; j++)
                if (visit[i][j] == 0) {
                    dfs(i, j, visit);
                    danji++;
                }
        System.out.print(danji + " ");
    }
}
