
/* 백준 1924 2007년
* */

import java.util.Scanner;

public class algo6_1924 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] year = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int x = scan.nextInt();
        int y = scan.nextInt();

        for(int i = 0; i < x-1; i++){
            y += year[i];
        }
        System.out.println(day[y%7]);
    }
}
