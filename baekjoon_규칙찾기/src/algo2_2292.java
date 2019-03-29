
/* 백준 2292 벌집
* */

import java.util.Scanner;

public class algo2_2292 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int i = 0;
        int n = 1;
        int before = 1;
        while(true){
            if(N >= before && N <= n){
                System.out.print(i+1);
                break;
            }
            before = n;
            i++;
            n += 6 * i;
        }
    }
}
