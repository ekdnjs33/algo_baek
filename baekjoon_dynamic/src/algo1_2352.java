
/* 백준 2352 반도체 설계
* 해당 포트에서 위와 아래로 나누어 겹치지 않는 연결선을 찾았더니 중복 계산 심함
* LIS(최장 증가 수열) 이용 */

import java.util.Scanner;

public class algo1_2352 {
    public static int[] now; //각 포트가 연결된 곳 저장하는 배열
    public static int N; //포트 개수
    public static int max; //최대 연결선 개수

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        now = new int[N+1];
        for(int i = 1; i <= N; i++){
            now[i] = scan.nextInt();
        }

        LIS();
        System.out.print(max);
    }

    /* 포트 1에서부터 차례대로 각 포트 위로 겹치지 않는 연결선이 몇 개 존재하는지 저장, 나중에 가져다 쓰기 위해 */
    public static void LIS(){
        int[] before= new int[N+1]; //자기 포트 위로 몇 개의 겹치지 않는 연결선을 가지는지 저장하는 배열

        for(int i = 1; i <= N; i++){
            before[i] = 1; //먼저 자기 연결선 1개가 있음을 표시
            if(i != 1){
                for(int j = 1; j < i; j++){
                    if(now[i] > now[j]){
                        //자기 위의 포트들을 검사하여 겹치지 않는 연결선을 가진 포트의 before 값에 +1을 추가하여 비교
                        before[i] = Math.max(before[i], before[j]+1);
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            max = Math.max(before[i], max);
        }
    }
}
