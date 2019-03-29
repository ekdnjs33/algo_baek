
/* 백준 2169 감소하는 수
* 각 자리를 차례로 비교했더니 시간 초과
* so, 동적 계획법 이용
* 더 큰 감소하는 수는 작은 감소하는 수에 숫자를 덧붙여 찾아야 함 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class algo4_1038 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //N번째 감소하는 수
        Queue<Long> q = new LinkedList<>();
        int count = -1;

        for(long i = 0; i < 10; i++){ //그 자체로 감소하는 수
            q.add(i);
            count++;
            if(N == count) {
                System.out.print(i);
                break;
            }
        }

        while(count < N){ //N번째 감소하는 수가 10 이상인 경우
            long n = q.poll();

            if(n == 9876543210L){ //9876543210 뒤로는 더 이상 감소하는 수를 만들 수 없다.
                System.out.print(-1);
                break;
            }
            else {
                long temp = n % 10; //1의 자리수 숫자 저장

                for (long i = 0; i < temp; i++) { //1의 자리수 숫자보다 작은 수만 뒤에 붙일 수 있다.
                    q.add(n * 10 + i);
                    count++;
                    if (N == count) {
                        System.out.print(n * 10 + i);
                        break;
                    }
                }
            }
        }
    }
}
