
/* 백준 1966 프린터 큐
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class algo_1966 {
    public static int[] array; //중요도 저장
    public static int count;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt(); //테스트 케이스
        int N; //문서 개수
        int M; //궁금한 문서 위치
        int value; //중요도

        for(int i = 0; i < testcase; i++) {
            Queue<Integer> q = new LinkedList<>(); //큐 초기화
            N = scan.nextInt();
            M = scan.nextInt();

            array = new int[N];
            for (int j = 0; j < N; j++) {
                value = scan.nextInt();
                q.add(j); //큐에는 위치 저장
                array[j] = value; //배열에는 해당 위치의 중요도 저장
            }

            count = 0;
            printer(M, N, q);
            System.out.println(count);
        }
    }

    static void printer(int M, int N, Queue<Integer> q){
        int max = 0;
        int label = 0;
        int v = 0;

        for(int i = 0; i < N; i++){ //중요도 높은 위치 탐색
            v = q.poll();
            if(array[v] > max) {
                max = array[v];
                label = v;
            }
            //System.out.println("큐 값: "+v+", 중요도: "+array[v]+", max: "+max+", label: "+label);
            q.add(v);
        }
        //System.out.println("-----------------");

        if(label == M){ //궁금 문서가 가장 높은 중요도를 가진 경우
            count++;
            return;
        }
        else{
            for(int i = 0; i <N; i++){
                v = q.poll();
                if(v == label) { //중요도 높은 문서일 경우
                    array[v] = 0;
                    count++;
                    printer(M, N-1, q);
                }
                else {
                    q.add(v); //아닐 경우 큐의 가장 뒤에 배치
                }
            }
        }
    }

}
