#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
#include<vector>
#include<queue>
#include<set>
#include<map>
#include<list>
#include<math.h>
#define ll long long
using namespace std;

void move (int n ,  int from , int buffer , int to){
    if (n==1) {
        printf("Move from %d to %d\n",from,to);
    }
    else{
        move(n-1,from,to,buffer);
        move(1,from,buffer,to);
        move(n-1,buffer,from,to);
    }
}

int main(){
    move(3,1,2,3);
}
