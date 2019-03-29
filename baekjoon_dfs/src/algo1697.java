
/* 백준 1697 숨바꼭질
 * */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class algo1697 {
    static int bfs(int N, int K, int[] Min){
        int nextN = N;
        int[] status = new int[3];
        Queue<Integer> q = new LinkedList<>();
        q.add(nextN);
        Min[nextN] = 0; //몇 번 만에 방문이 가능한지 표시

        while(!q.isEmpty() && nextN != K){ //큐가 비거나 nextN == K이면 종료
            nextN = q.poll(); //큐에서 꺼내온 값

            //다음에 이동할 좌표들
            status[0] = nextN - 1;
            status[1] = nextN + 1;
            status[2] = nextN * 2;

            for(int i=0; i<3; i++){
                //배열을 벗어나지 않았는지 확인
                if(status[i] >= 0 && status[i] <= 100000){
                    //이전에 방문했는지 확인
                    if(Min[status[i]] == -1){
                        //처음 간 곳이라면 큐에 넣고, 전 위치값 +1해서 저장
                        q.add(status[i]);
                        Min[status[i]] = Min[nextN] + 1;
                    }
                }
            }
        }
        return Min[K];
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int N = stdIn.nextInt();
        int K = stdIn.nextInt();
        int[] Min = new int[100001];
        Arrays.fill(Min, -1); //초기값을 모두 -1로 설정
        System.out.println(bfs(N, K, Min));
    }
}
