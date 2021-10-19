#include <iostream>
#include <vector>
#include <queue>
#include <utility>
#include <algorithm>

using namespace std;

pair<vector<long>, long> merge(vector<long> left, vector<long> right) {
    vector<long> resulting_vector;
    int lp = 0;
    int rp = 0;
    long inv = 0;
    while(lp != left.size() || rp != right.size()) {
        if (lp == left.size()) {
            resulting_vector.push_back(right[rp++]);
        }
        else if (rp == right.size()) {
            resulting_vector.push_back(left[lp++]);
        }
        else if (left[lp] < right[rp]) {
            resulting_vector.push_back(left[lp++]);
        }
        else if (left[lp] == right[rp]) {
            resulting_vector.push_back(left[lp++]);
        }
        else {
            resulting_vector.push_back(right[rp++]);
            inv = inv + left.size() - lp;
        }
    }
    pair<vector<long>, long> res(resulting_vector, inv);
    return res;
}

long mergeSort(vector<long> vec) {
    long inv = 0;
    int n = vec.size();
    for(int cur_size = 1; cur_size <= n - 1; cur_size = 2 * cur_size) {
        for(int left_start = 0; left_start < n - 1; left_start = left_start + 2 * cur_size) {
            int mid = min(left_start + cur_size - 1, n - 1);
            int right_end = min(left_start + 2 * cur_size - 1, n-1);
            vector<long> left;
            vector<long> right;
            for (int i = left_start; i <= mid; i++) {
                left.push_back(vec[i]);
            }
            for (int i = mid + 1; i <= right_end; i++) {
                right.push_back(vec[i]);
            }
            pair<vector<long>, long> merge_res = merge(left, right);
            for (int i = left_start, j = 0; i <= right_end; i++, j++) {
                vec[i] = merge_res.first[j];
            }
            inv += merge_res.second;
        }
    }
    return inv;
}

int main() {
    int number_count;
    cin >> number_count;
    long res = 0;
    vector<long> numbers(number_count);
    for (auto &number:numbers) {
      cin >> number;
    }
    long inv = mergeSort(numbers);
    cout << inv << endl;
    return 0;
}
