#include <iostream>
#include <cstdio>
using namespace std;
int main() {
    int H, W;
    cin >> H >> W;
    int n;
    cin >> n;
    
    for (size_t i = 0; i < n; ++i) {
        scanf("%s", &s[i]);
    }
    cout << H << " " << W << endl;

    for (size_t i = 0; i < n; ++i) {
        printf("%s\n", s[i]);
    }
    return 0;
}