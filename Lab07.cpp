#include "MyLab07.h"
#include <iostream>
using namespace std;

void Check(){
    double a[3] = {0};
    for (int i = 0; i < 3; i++){
        cin >> a[i];
    }
    double max;
    max = a[0];
    for (int i = 0; i < 3; i++){
        if (a[i] > max){
            max = a[i];
        }
    }
    if (max < a[0] + a[1] && max == a[2] || max < a[0] + a[2] && max == a[1] || max < a[2] + a[1] && max == a[0]){
        cout << "There is a triangle!";   
    }
    else {
        cout << "There is no triangle!";    
    }
}
