
/* 백준 1021 회전하는 큐
* */

import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;

public class algo_1021 {
    public static int[] array;
    public static int N; //큐 크기
    public static int count; //연산 횟수

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int M = scan.nextInt(); //뽑아내려는 개수
        int k = 0; //뽑아내려는 수의 위치

        array = new int[N+1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            dq.add(i);
            array[i] = i;
        }

        count = 0;
        for(int i = 0; i < M; i++){
            k = scan.nextInt();

            finding(k, dq);
        }
        System.out.println(count);
    }

    static void finding(int k, Deque<Integer> dq){
        int cnt = 0;
        int value = 0;

        if(dq.peek() == k){
            dq.pop();
            N--;
        }
        else {
            for (int i = 1; i <= N; i++) {
                if (array[i] == k)
                    break;
                else
                    cnt++;
            }

            if (cnt <= N - cnt) { //왼쪽 이동이 최소일 경우
                for (int j = 1; j <= cnt; j++) {
                    value = dq.pop();
                    dq.add(value);
                    count++;
                }
                dq.pop();
                N--;
            }
            else { //오른쪽 이동이 최소일 경우
                for (int j = 1; j <= N - cnt; j++) {
                    value = dq.removeLast();
                    dq.addFirst(value);
                    count++;
                }
                dq.pop();
                N--;
            }
        }

        for (int j = 1; j <= N; j++) { //배열 및 큐 재정렬
            array[j] = dq.pop();
            dq.add(array[j]);
        }
    }
}
