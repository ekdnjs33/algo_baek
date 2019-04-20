//
//  algo_2609.cpp
//  bj_GcdLcm
//
//  Created by 김다원 on 17/04/2019.
//  Copyright © 2019 김다원. All rights reserved.
//
//  2609 최대공약수와 최소공배수

#include <stdio.h>
int GCD(int, int); //최대공약수
int LCM(int, int, int); //최소공배수

int main(){
    int a, b;
    scanf("%d %d", &a, &b);
    int gcd = GCD(a, b);
    int lcm = LCM(a, b, gcd);
    printf("%d\n%d\n", gcd, lcm);
    return 0;
}

int GCD(int a, int b){
    int min = a;
    int max = b;
    if(a > b){
        min = b;
        max = a;
    }
    for(;;){
        int x = max % min;
        if(x == 0)
            break;
        max = min;
        min = x;
    }
    return min;
}

int LCM(int a, int b, int gcd){
    return a * b / gcd;
}
