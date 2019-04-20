//
//  algo_13241.cpp
//  bj_GcdLcm
//
//  Created by 김다원 on 17/04/2019.
//  Copyright © 2019 김다원. All rights reserved.
//
//  13241 최소공배수

#include <iostream>
using namespace std;
void LCM(long long int, long long int); //최소공배수

int main()
{
    long long int a, b;
    cin >> a >> b ;
    LCM(a, b);
    return 0;
}

void LCM(long long int a, long long int b)
{
    long long int min = a;
    long long int max = b;
    long long int result;
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

