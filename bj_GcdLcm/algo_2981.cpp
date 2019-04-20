//
//  algo_2981.cpp
//  bj_GcdLcm
//
//  Created by 김다원 on 17/04/2019.
//  Copyright © 2019 김다원. All rights reserved.
//
//  2981 검문

#include <stdio.h>
#include <iostream>
#include <algorithm>
using namespace std;
long GCD(long, long);

int main(){
    int N;
    cin >> N;
    long array[N];
    
    for(int i=0; i<N; i++){
        cin >> array[i];
    }
    sort(array, array+N);
    
    long gcd = array[N-1]-array[0];
    long cd[1000000];
    int num=0;
    for(int i=2; i<=gcd; i++){
        if(gcd%i == 0){
            cd[num] = i;
            num++;
        }
    }
    cout << num << " ";
    for(int i=0; i<num; i++){
        long mod = array[0] % cd[i];
        int check = 0;
        for(int j=1; j<N; j++){
            if((array[j]%cd[i]) != mod){
                check = 1;
                break;
            }
        }
        if(check == 0){
            cout << cd[i] <<" ";
        }
    }
}
long GCD(long a, long b){
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
    return min;
}
