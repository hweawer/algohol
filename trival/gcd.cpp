#include <cassert>
#include <iostream>

template <class Int>
Int gcd(Int a, Int b) {
  assert(a > 0 && b > 0);
  int c;
  while(b){
      c = a % b;
      a = b;
      b = c;
  }
  return abs(a);
}

int main(void) {
  int a, b;
  std::cin >> a >> b;
  std::cout << gcd(a, b) << std::endl;
  return 0;
}
