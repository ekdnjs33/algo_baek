
/* 백준 2178 미로 탐색
* bfs 이용
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class algo_2178 {
    static int[] dx = {0, 1, 0, -1}; //우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};
    public static int N, M;
    public static int[][] array; //배열
    public static int[][] visit; //방문 여부

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        array = new int[N][M];
        visit = new int[N][M];
        for(int i = 0; i < N; i++){
            String s = scan.next();
            for(int j = 0; j < M; j++)
                array[i][j] = s.charAt(j) - 48; //숫자로 변환
        }

        bfs(0, 0);
        System.out.println(array[N-1][M-1]);
    }

    static void bfs(int x, int y){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(x);
        qy.add(y);

        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = 1;

            for(int i = 0; i < 4; i++){
                int X = x + dx[i];
                int Y = y + dy[i];
                if(X >= 0 && Y >= 0 && X < N && Y < M){
                    if(array[X][Y] == 1 && visit[X][Y] == 0){ //갈 수 있는 길이면서 아직 방문하지 않은 길
                        qx.add(X);
                        qy.add(Y);
                        visit[X][Y] = 1;
                        array[X][Y] = array[x][y] + 1;
                    }
                }
            }
        }
    }
}
