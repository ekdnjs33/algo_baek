
/* 백준 1475 방 번호
* */

import java.util.Scanner;

public class algo8_1475 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] array = new int[10];

        while (N > 0) {
            array[N%10]++;
            N = N/10;
        }
        array[6] += array[9];
        int max = 1;
        for(int i = 0; i < 9; i++){
            if(i == 6){
                array[i] = array[i]/2+array[i]%2;
            }
            if(array[i] > max){
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
