
/* 백준 7576 토마토 1
* bfs 이용
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class algo_7576 {
    static int[] dx = {0, 1, 0, -1}; //우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};
    public static int[][] array;
    public static int[][] visit; //방문 여부
    public static int count; //모두 익는 최소 일수

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt(); //가로
        int N = scan.nextInt(); //세로
        boolean zero = false;

        array = new int[N][M];
        visit = new int[N][M];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = scan.nextInt();
            }
        }

        count = bfs(N, M);
        /*for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }*/
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(array[i][j] == 0){
                    zero = true;
                    System.out.println(-1);
                    return;
                }
            }
        }
        if(zero == false) {
            System.out.println(count);
        }
    }

    static int bfs(int N, int M) {
        boolean is = false;
        int x = 0, y = 0;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 1) {
                    qx.add(i);
                    qy.add(j);
                } else if (array[i][j] == 0) {
                    is = true;
                }
            }
        }
        if (is == false) {
            return 0;
        }

        while (!qx.isEmpty() && !qy.isEmpty()) { //큐가 비면 종료
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                //배열을 벗어나지 않았는지 확인
                if (X >= 0 && Y >= 0 && X < N && Y < M) {
                    //이전에 방문했는지 확인
                    if (visit[X][Y] == 0 && array[X][Y] == 0) {
                        qx.add(X);
                        qy.add(Y);
                        array[X][Y] = array[x][y] + 1;
                    }
                }
            }
        }
        return array[x][y] - 1;
    }
}
