import java.util.Scanner;

public class algo1707 {
    //dfs stack, bfs로 풀기
    public static int[][] array;
    public static int[] visit;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(); //테스트 케이스

        for(int i = 0; i < k; i++){
            int v = scan.nextInt(); //노드 수
            int e = scan.nextInt(); //간선 수
            for(int j = 0; j < e; j++){
                int x = scan.nextInt();
                int y = scan.nextInt();      // 00 01 02
                array[y][x] = 1;             // 10 11 12
                array[x][y] = 1;             // 20 21 22
            }
            dfs(v, 0, 0);
        }
    }
    public static void dfs(int v, int i, int j){
        for(i = 0; i < v; i++){
            for(j = 0; j < v; j++){
                if(array[i][j] == 1){ //(j, i)
                    visit[j] = 1;
                    dfs(v, i, j);
                }
            }
        }
    }

}
