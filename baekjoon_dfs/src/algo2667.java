
/* 백준 2667 단지번호 붙이기
 * */

import java.util.*;

public class algo2667 {
    public static int[][] data;
    public static int count;

    static int dfs(int row, int col){
        if(data[row][col] == 0 || data[row][col] == 2) //0 이거나 방문한 경우 pass
            return 0;
        data[row][col] = 2; //방문 했음을 표시
        count++;

        if((col-1) >= 0 && data[row][col-1] == 1) //왼쪽
            dfs(row, col-1);
        if((col+1) < data[0].length && data[row][col+1] == 1) //오른쪽
            dfs(row, col+1);
        if((row-1) >= 0 && data[row-1][col] == 1) //위쪽
            dfs(row-1, col);
        if((row+1) < data.length && data[row+1][col] == 1) //아래쪽
            dfs(row+1, col);
        return count;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int N = stdIn.nextInt(); //지도 크기
        data = new int[N][N];

        for(int i=0; i<N; i++) {
            String str = stdIn.next();
            for (int j=0; j<N; j++) {
                data[i][j] = str.charAt(j)-'0'; //숫자로 변환
            }
        }

        int[] array = new int[N*N]; //각 단지내 집 수 저장
        int danji = 0; //단지 수
        int index = 0;

        for(int i=0; i<N; i++) {
            for (int j=0; j <N; j++) {
                if(data[i][j] == 1){
                    danji++;
                    array[index++] = dfs(i, j);
                    count = 0;
                }
            }
        }

        System.out.println(danji);
        Arrays.sort(array); //오름차순으로 나열
        for(int i=0; i<N*N; i++){
            if(array[i] != 0)
                System.out.println(array[i]);
        }
    }

}
