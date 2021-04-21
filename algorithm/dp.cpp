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

const int max_n = 1000;
char s[max_n] , t[max_n];
int dp[max_n][max_n];

void solve(){
    int lens = strlen(s+1) , lent = strlen(t+1);
    for (int i = 1 ; i <= lens ; i ++){
        for (int j = 1 ; j <= lent ; j ++){
            if (s[i] == t[j]){
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
}

int main(){
    scanf("%s%s",s+1,t+1);
    solve();
    printf("%d\n",dp[strlen(s+1)][strlen(t+1)]);
}
