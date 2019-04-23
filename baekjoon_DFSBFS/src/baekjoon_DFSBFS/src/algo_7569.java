
/* 백준 7569 토마토 2
* bfs 이용
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class algo_7569 {
    static int[] dx = {0, 1, 0, -1, 0, 0}; //우, 하, 좌, 상, 위, 아래
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    public static int[][] array;
    public static int[][] visit; //방문 여부
    public static int count; //모두 익는 최소 일수

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt(); //가로
        int N = scan.nextInt(); //세로
        int H = scan.nextInt(); //높이
        boolean zero = false;

        array = new int[N*H][M];
        visit = new int[N*H][M];
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    array[i+k*N][j] = scan.nextInt();
                }
            }
        }

        count = bfs(N, M, H);

        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(array[i+k*N][j] + " ");
                }
                System.out.println();
            }
        }
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(array[i+k*N][j] == 0){
                        zero = true;
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if(zero == false) {
            System.out.println(count);
        }
    }

    static int bfs(int N, int M, int H) {
        boolean is = false;
        int x = 0, y = 0, z = 0;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qz = new LinkedList<>();
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (array[i+k*N][j] == 1) {
                        qx.add(i);
                        qy.add(j);
                        qz.add(k);
                    } else if (array[i+k*N][j] == 0) {
                        is = true;
                    }
                }
            }
        }
        if (is == false) {
            return 0;
        }

        while (!qx.isEmpty() && !qy.isEmpty()) { //큐가 비면 종료
            x = qx.poll();
            y = qy.poll();
            z = qz.poll();
            visit[x+N*z][y] = 1;

            for (int i = 0; i < 6; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];
                int Z = z + dz[i];

                //배열을 벗어나지 않았는지 확인
                if (X >= 0 && Y >= 0 && Z >= 0 && X < N && Y < M && Z < H) {
                    //이전에 방문했는지 확인
                    if (visit[X+N*Z][Y] == 0 && array[X+N*Z][Y] == 0) {
                        qx.add(X);
                        qy.add(Y);
                        qz.add(Z);
                        array[X+N*Z][Y] = array[x+N*z][y] + 1;
                    }
                }
            }
        }
        return array[x+N*z][y] - 1;
    }
}

