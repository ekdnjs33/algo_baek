
/* 백준 2533 사회망 서비스(SNS)
* 다시 풀어보기
* 동적계획법 이용 */

import java.util.LinkedList;
import java.util.Scanner;

public class algo2_2533 {
    public static int N; //정점 N
    public static int[] visit;
    public static int[][] dp;
    public static LinkedList<Integer>[] list;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        visit = new int[N+1]; //해당 노드를 방문했는지 표시
        dp = new int[N+1][2]; //자기 자신 포함 아래로 얼리어답터 개수 저장 -> 동적계획법을 이용하기 위해
        list = new LinkedList[N+1];

        for (int i = 1; i <= N; i++) //왜 하는건지 모르겠
            list[i] = new LinkedList<>();

        for(int i = 0; i < N-1; i++){ //리스트를 구성, 각 노드에 연결되어있는 부모,자식 노드를 넣은 리스트
            int a = scan.nextInt();
            int b = scan.nextInt();
            list[a].add(b);
        }
        dfs(1);
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int index) {
        visit[index] = 1;
        dp[index][0] = 0; //얼리어답터가 아닌 경우
        dp[index][1] = 1; //얼리어답터인 경우

        LinkedList<Integer> item = list[index]; //item에 해당 노드에 연결되어 있는 노드들을 넣어줌

        for (int to : item) {
            if (visit[to] == 0) { //방문하지 않았다면
                dfs(to); //깊이탐색
                dp[index][0] += dp[to][1]; //자식이 얼리어답터인 경우를 더함
                dp[index][1] += Math.min(dp[to][0], dp[to][1]); //자식이 얼리어답터여도 되고 아니어도 되고, 그 중 작은 것 더함
            }
        }
    }
}