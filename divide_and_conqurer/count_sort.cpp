#include <iostream>
#include <vector>

using namespace std;

vector<int> countSort(vector<int> numbers) {
    vector<int> indexes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    for (auto &number:numbers) {
        indexes[number] = indexes[number]++;
    }
    for (int j = 1; j < indexes.size(); j++) {
        indexes[j] = indexes[j] + indexes[j - 1];
    }
    vector<int> result(numbers.size());
    for (int i = 0; i < numbers.size(); i++) {
        result[indexes[numbers[i]]] = numbers[i];
        indexes[numbers[i]]--;
    }
    return result;
}

int main() {
    size_t number_count;
    cin >> number_count;
    vector<int> numbers(number_count);
    for (auto &number:numbers) {
      cin >> number;
    }
    vector<int> indexes(10);
    for (auto &number:numbers) {
        indexes[number - 1]++;
    }
    for (int j = 1; j < indexes.size(); j++) {
        indexes[j] = indexes[j] + indexes[j - 1];
    }
    for (int i = 0; i < indexes.size(); i++) {
        if (indexes[i] > 0) {
            indexes[i] = indexes[i] - 1;
        }
    }
    vector<int> result(numbers.size());
    for (int i = 0; i < numbers.size(); i++) {
        result[indexes[numbers[i] - 1]] = numbers[i];
        indexes[numbers[i] - 1] = indexes[numbers[i] - 1] - 1;
    }
    for (auto &number:result) {
        cout << number << " ";
    }
    cout << endl;
    return 0;
}
