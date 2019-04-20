//
//  main.cpp
//  bj_GcdLcm
//
//  Created by 김다원 on 17/04/2019.
//  Copyright © 2019 김다원. All rights reserved.
//
//  1934 최소공배수

#include <iostream>
using namespace std;
void LCM(int, int); //최소공배수

int main()
{
    int test, a, b;
    cin >> test;
    for(int i=0; i<test; i++){
        cin >> a >> b ;
        LCM(a, b);
    }
    return 0;
}

void LCM(int a, int b)
{
    int min = a;
    int max = b;
    int result;
    if(a > b)
    {
        max = a;
        min = b;
    }
    for(int i=1; i<=min; i++)
    {
        result = max*i;
        if((result % min) == 0)
        {
            cout << result << endl;
            break;
        }
    }
}
