#include <cassert>
#include <iostream>

class Fibonacci {
 public:
  static int get_last_digit(int n) {
    assert(n >= 1);
    if (n <= 2) return 1;
    else {
        int array[n+1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = (array[i-1] + array[i-2]) % 10;
        }
        return array[n];
    }
  }
};

int main(void) {
  int n;
  std::cin >> n;
  std::cout << Fibonacci::get_last_digit(n) << std::endl;
  return 0;
}
