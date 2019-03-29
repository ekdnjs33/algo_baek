
/* 백준 1094 막대기
* */

import java.util.Scanner;

public class algo_1094 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt(); //가지고 싶은 막대
        int left = 64;
        int min = 64; //가지고 있는 것 중 가장 짧은 막대
        int count = 1; //막대기 개수

        while(left > x){
            min = min/2;
            if(left-min >= x){
                left = left-min;
            }
            else{
                count++;
            }
        }
        System.out.print(count);
    }
}
