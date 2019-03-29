
/* 백준 5397 키로커
* 스택 이용, 공간복잡도 , 시간복잡도
* 스택이 비어있는지 확인 */

import java.util.Scanner;

public class algo_5397 {
    public static int[] array;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int i = 0; i < t; i++){
            String L = scan.next();

            array = new int[L.length()];
            for(int j = 0; j < L.length(); j++){
                array[i] = L.charAt(i);
            }
            rearrange(array, L.length());

        }

    }

    public static void rearrange(int[] array, int length){
        for(int i = 0; i < length; i++){
            if(array[i] == '<'){

            }else if(array[i] == '>'){

            }else if(array[i] == '-'){

            }else{

            }
    }
}
