
/* 백준 3055 탈출
* 입력 잘못 받음 -> 수정, 실패
* */

import java.util.Scanner;

public class algo_3055 {
    public static char[][] array;
    public static int[][] waterWay;
    public static int R; //행
    public static int C; //열
    public static int[] located;
    public static int num;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        R = scan.nextInt();
        C = scan.nextInt();
        located = new int[4];
        num = 0;

        array = new char[R][C];
        waterWay = new int[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                array[i][j] = scan.next().charAt(0); //char형으로 입력 받기
                //고슴도치가 있는 곳 저장
                if(array[i][j] == 'S'){
                    located[0] = i;
                    located[1] = j;
                }
                //비버굴이 있는 곳 저장
                if(array[i][j] == 'D'){
                    located[2] = i;
                    located[3] = j;
                }
                //물이 있는 곳 저장
                if(array[i][j] == '*'){
                    waterWay[i][j] = 1;
                }
            }
        }
        dfs(located[0], located[1]);

        if(num == 0){
            System.out.println("KAKTUS");
        }else{
            System.out.println(num);
        }

    }

    static void dfs(int x, int y) {
        int count = 0; //최단 시간 출력

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (array[i][j] == '*') {
                    if ((i - 1) >= 0 && array[j][i - 1] == '.') //왼쪽
                        waterWay[j][i - 1] = 1;
                    if ((j + 1) < R && array[j][i + 1] == '.') //오른쪽
                        waterWay[j][i + 1] = 1;
                    if ((j - 1) >= 0 && array[j - 1][i] == '.') //위쪽
                        waterWay[j - 1][i] = 1;
                    if ((j + 1) < C && array[j + 1][i] == '.') //아래쪽
                        waterWay[j + 1][i] = 1;
                }
            }
        }
        for (int i = 0; i < R; i++) { //물길 갱신
            for (int j = 0; j < C; j++) {
                if (waterWay[i][j] == 1)
                    array[i][j] = '*';
            }
        }

        if (x == located[2] && y == located[3]) {
            num = count;
            return;
        } else {
            if (((y - 1) >= 0 && array[x][y - 1] == '.') || ((y + 1) < R && array[x][y + 1] == '.') || ((x - 1) >= 0 && array[x - 1][y] == '.') || ((x + 1) < C && array[x + 1][y] == '.')) {
                if ((y - 1) >= 0 && array[x][y - 1] == '.') { //왼쪽
                    array[x][y] = '.';
                    array[x][y - 1] = 'S';
                    dfs(x, y - 1);
                    count++;
                }
                if ((y + 1) < R && array[x][y + 1] == '.') { //오른쪽
                    array[x][y] = '.';
                    array[x][y + 1] = 'S';
                    dfs(x, y + 1);
                    count++;
                }
                if ((x - 1) >= 0 && array[x - 1][y] == '.') { //위쪽
                    array[x][y] = '.';
                    array[x - 1][y] = 'S';
                    dfs(x - 1, y);
                    count++;
                }
                if ((x + 1) < C && array[x + 1][y] == '.') { //아래쪽
                    array[x][y] = '.';
                    array[x + 1][y] = 'S';
                    dfs(x + 1, y);
                    count++;
                }
            } else
                count = 0;
        }
    }

}
