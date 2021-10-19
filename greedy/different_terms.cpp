#include <iostream>
#include <vector>

int main() {
    int n;
    std::cin >> n;
    int nCopy = n;
    std::vector<int> result;
    for (int i = 1; i <= n; i++) {
        int diff = nCopy - i;
        if (diff > i) {
            result.push_back(i);
            nCopy = diff;
        }
        else {
            result.push_back(nCopy);
            break;
        }
    }
    std::cout << result.size() << std::endl;
    for (int i = 0; i < result.size(); i++) {
        std::cout << result.at(i) << ' ';
    }
    return 0;
}
