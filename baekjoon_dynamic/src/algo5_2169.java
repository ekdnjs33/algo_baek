
/* 백준 2169 로봇 조종하기
* 동적 계획법 */

import java.util.Scanner;

public class algo5_2169 {
    public static int[][] array;
    public static int N; //세로
    public static int M; //가로

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        array = new int[N][M]; //맵의 가치 저장
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                array[i][j] = scan.nextInt();
            }
        }
        LIS();
    }

    public static void LIS(){
        int[][] before = new int[N][M]; //각 위치에 대한 최대치를 저장할 배열
        int[][] comp = new int[2][M]; //최대치 비교를 위해 잠시 저장할 배열

        before[0][0] = array[0][0];
        for(int i = 1; i < M; i++){
            before[0][i] = before[0][i-1]+array[0][i];
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                //아래에서 온 값 저장
                comp[0][j] = before[i-1][j] + array[i][j];
                comp[1][j] = comp[0][j];
            }
            for(int j = 1; j < M; j++){
                //아래에서 온 값과 왼쪽에서 온 값 비교
                comp[0][j] = Math.max(comp[0][j], comp[0][j-1]+array[i][j]);
            }
            for(int j = M-2; j >= 0; j--){
                //아래에서 온 값과 오른쪽에서 온 값 비교
                comp[1][j] = Math.max(comp[1][j], comp[1][j+1]+array[i][j]);
            }
            for(int j = 0; j < M; j++){
                //아래, 왼, 오른쪽에서 온 값 비교
                before[i][j] = Math.max(comp[0][j], comp[1][j]);
            }
        }
        /*for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(before[i][j] + " ");
            }
            System.out.println();
        }*/
        System.out.println(before[N-1][M-1]);
    }
}
