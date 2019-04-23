
/* 백준 10451 순열 사이클
* dfs 이용
* */

import java.util.Scanner;

public class algo_10451 {
    public static int[] array; //배열
    public static int[] is; //방문 여부
    public static int count = 0; //사이클 개수

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0; i < T; i++){
            int N = scan.nextInt();

            array = new int[N+1];
            is = new int[N+1];
            for(int j = 1; j <= N; j++){
                array[j] = scan.nextInt();
            }
            for(int j = 1; j <= N; j++){
                if(is[j] == 0){
                    dfs(j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    static void dfs(int x){
        is[x] = 1;
        if(is[array[x]] == 0){
            dfs(array[x]);
        }else
            return;
    }
}
