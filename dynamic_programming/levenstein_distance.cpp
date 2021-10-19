#include <algorithm>
#include <cstddef>
#include <iostream>
#include <string>

using namespace std;

int get_levenshtein_distance(const std::string &str1, const std::string &str2) {
  // TODO optimize this function
  int size1 = str1.size();
  int size2 = str2.size();
  if (str1.empty() || str2.empty()) {
    return size1 + size2;
  }
  int D[size1+1][size2+1];
  
  for(int i = 0; i < size1 + 1; i++) {
      D[i][0] = i;
  }
    
  for(int j = 0; j < size2 + 1; j++) {
      D[0][j] = j;
  }
    
  for (int i = 1; i <= size1; i++) {
      for (int j = 1; j <= size2; j++) {
          int c = 1;
          if (str1[i - 1] == str2[j - 1]) {
              c = 0;
          }
          D[i][j] = min({D[i - 1][j] + 1, D[i][j - 1] + 1, D[i - 1][j - 1] + c});
      }
  }
  return D[size1][size2];
}

int main(void) {
  std::string str1;
  std::string str2;

  std::cin >> str1 >> str2;  

  std::cout << get_levenshtein_distance(str1, str2) << std::endl;
}

