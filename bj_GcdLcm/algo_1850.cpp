//
//  algo_1850.cpp
//  bj_GcdLcm
//
//  Created by 김다원 on 17/04/2019.
//  Copyright © 2019 김다원. All rights reserved.
//
//  1850 최대공약수

#include <stdio.h>
#include <iostream>
using namespace std;
int GCD(long, long); //최대공약수

int main(){
    long a, b;
    int gcd;
    cin >> a >> b;
    gcd = GCD(a,b);
    for(int i=0; i<gcd; i++){
        cout << 1;
    }
    cout << endl;
}
int GCD(long a, long b){
    long min = a;
    long max = b;
    if(a > b){
        min = b;
        max = a;
    }
    for(;;){
        long x = max % min;
        if(x == 0)
            break;
        max = min;
        min = x;
    }
    return (int)min;
}
