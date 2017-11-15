#include <cstdio>
#include <algorithm>
using namespace std;
int main() {
  int n[3];
  for (size_t i = 0; i < 3; ++i) {
    scanf("%d", &n[i]);
  }
  sort(n, n+3);
  for (size_t i = 0; i < 3; ++i) {
    printf("%d%c", n[i], i < 2 ? ' ' : '\n');
  }
  return 0;
}