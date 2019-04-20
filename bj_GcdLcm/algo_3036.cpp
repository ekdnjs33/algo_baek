//
//  algo_3036.cpp
//  bj_GcdLcm
//
//  Created by 김다원 on 17/04/2019.
//  Copyright © 2019 김다원. All rights reserved.
//
//  3036 링

#include <stdio.h>
#include <iostream>
using namespace std;
int GCD(int, int); //최대공약수

int main(){
    int N;
    cin >> N;
    int array[N];
    for(int i=0; i<N; i++){
        cin >> array[i];
    }
    for(int i=1; i<N; i++){
        int m = GCD(array[0], array[i]);
        cout << array[0]/m << "/" << array[i]/m << endl;
    }
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
