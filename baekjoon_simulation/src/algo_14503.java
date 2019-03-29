
/* 백준 14503 로봇 청소기
* 공간복잡도 O(nm), 시간복잡도 O(nm)*/

import java.util.Scanner;

public class algo_14503 {
    public static int[][] array; //공간
    public static int count;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //세로
        int M = scan.nextInt(); //가로
        int r = scan.nextInt(); //청소기가 위치하는 y좌표
        int c = scan.nextInt(); //청소기가 위치하는 x좌표
        int d = scan.nextInt(); //청소기가 바라보는 방향

        array = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                array[i][j] = scan.nextInt();

        count = 0;
        go(c, r, d);

        System.out.println(count);
    }

    static void go(int x, int y, int dir) {
        //청소 횟수 카운트
        if(array[y][x] == 0){
            array[y][x] = 2; //자기 자리 청소, 청소한 자리 2로 표시
            count++;
        }

        //사방이 청소했거나 벽일 경우 뒤로 후진, 후진이 불가능한 경우 return
        if(array[y-1][x] > 0 && array[y][x-1] > 0 && array[y+1][x] > 0 && array[y][x+1] > 0){
            if(dir == 0){
                if(array[y+1][x] == 1) //후진할 곳이 벽인 경우
                    return;
                else
                    go(x, y+1, dir); //방향은 그대로 두고 후진
            }
            else if(dir == 3){
                if(array[y][x+1] == 1)
                    return;
                else
                    go(x+1, y, dir);
            }
            else if(dir == 2){
                if(array[y-1][x] == 1)
                    return;
                else
                    go(x, y-1, dir);
            }
            else if(dir == 1){
                if(array[y][x-1] == 1)
                    return;
                else
                    go(x-1, y, dir);
            }
        }
        else{ //사방 중 갈 수 있는 곳이 있다면
            int newdir = (dir + 3) % 4; //왼쪽으로만 돌아가니까 (dir+3)%4 한 값이 새로 바라보는 방향

            if (newdir == 0) {
                if (array[y - 1][x] == 0) {
                    go(x, y - 1, newdir);
                } else
                    go(x, y, newdir);
            } else if (newdir == 3) {
                if (array[y][x - 1] == 0) {
                    go(x - 1, y, newdir);
                } else
                    go(x, y, newdir);
            } else if (newdir == 2) {
                if (array[y + 1][x] == 0) {
                    go(x, y + 1, newdir);
                } else
                    go(x, y, newdir);
            } else if (newdir == 1) {
                if (array[y][x + 1] == 0) {
                    go(x + 1, y, newdir);
                } else
                    go(x, y, newdir);
            }
        }
    }
}
