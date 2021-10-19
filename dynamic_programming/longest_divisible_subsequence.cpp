#include <algorithm>
#include <cstddef>
#include <iostream>
#include <vector>

using namespace std;

int get_length_of_longest_divisible_subsequence(vector<int> numbers) {
  vector<int> D(numbers.size());
  for (int i = 0; i < numbers.size(); i++) {
    D[i] = 1;
    for (int j = 0; j <= i - 1; j++) {
        if (numbers[i] % numbers[j] == 0 && D[j] + 1 > D[i]) {
            D[i] = D[j] + 1;
        }
    }
  }
  int max = D[0];
  for (int i = 1; i < D.size(); i++) {
      if (D[i] > max) {
          max = D[i];
      }
  }
  return max;
}

int main(void) {
  size_t number_count;
  cin >> number_count;
  vector<int> numbers(number_count);
  for (auto &number:numbers) {
    cin >> number;
  }

  cout << get_length_of_longest_divisible_subsequence(numbers) << endl;
}
