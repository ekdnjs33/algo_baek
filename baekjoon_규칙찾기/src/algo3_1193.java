
/* 백준 1193 분수찾기
* */

import java.util.Scanner;

public class algo3_1193 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int i = 1; //개수 및 분수에 들어갈 숫자 저장
        int n = 1; //순서 저장
        int before = 0;
        boolean is = true;
        while(is){
            if(i%2 == 1){ //i가 홀수인 경우
                int a = i; //분자
                int b = 1; //분모
                for(int j = before+1; j <=n; j++) {
                    if (j == N) {
                        System.out.print(a + "/" + b);
                        is = false;
                    }
                    a--;
                    b++;
                }
            }
            else if(i%2 == 0){ //i가 짝수인 경우
                int a = 1; //분자
                int b = i; //분모
                for(int j = before+1; j <=n; j++) {
                    if (j == N) {
                        System.out.print(a + "/" + b);
                        is = false;
                    }
                    a++;
                    b--;
                }
            }
            before = n;
            i++;
            n += i;
        }
    }
}
