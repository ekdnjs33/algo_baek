
/* 백준 1463 1로 만들기
* */

import java.util.Scanner;

public class algo_1463 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] array = new int[1000001];

        for(int i = 2; i <= N; i++){
            if(i%2 == 0 && i%3 == 0) //2와 3 둘 다 나누어질 경우
                array[i] = Math.min(array[i-1]+1, Math.min(array[i/2]+1, array[i/3]+1));
            else if(i%2 == 0) //2로만 나누어질 경우
                array[i] = Math.min(array[i-1]+1, array[i/2]+1);
            else if(i%3 == 0) //3로만 나누어질 경우
                array[i] = Math.min(array[i-1]+1, array[i/3]+1);
            else //2와 3 모두 안 나누어질 경우
                array[i] = array[i-1]+1;
        }
        System.out.println(array[N]);
    }
}
