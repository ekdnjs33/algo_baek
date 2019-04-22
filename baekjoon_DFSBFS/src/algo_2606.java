
/* 백준 2606 바이러스
* 컴파일 오류
* -> array[][0] 자리에 원하는 컴터가 없을 경우 안 돌아가
* -> (1 3)으로 입력받든 (3 1)로 입력받든 같은 1과 3이 연결된 걸로 인식해야 해
* -> 그래서 (1 3)을 입력받은 경우, (1 3),(3 1) 둘 다 배열에 저장하여 해결
* */

import java.util.Scanner;

public class algo_2606 {
    public static int[][] array;
    public static int[] n;
    public static int count = 0;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int comp = scan.nextInt();
        int link = scan.nextInt();

        array = new int[link*2][2];
        n = new int[comp+1];
        for(int i = 0; i < link; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            array[i][0] = x;
            array[i][1] = y;
            array[i+link][0] = y;
            array[i+link][1] = x;
        }
        if(comp == 0) {
            System.out.println(0);
        }else{
            dfs(1, link*2);
            System.out.println(count-1);
        }
    }
    static void dfs(int x, int link){
        n[x] = ++count;
        for(int i = 0; i < link; i++){
            if(array[i][0] == x)
                if(n[array[i][1]] == 0)
                    dfs(array[i][1], link);
        }
        return;
    }
}
