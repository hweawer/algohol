#include <iostream>
#include <utility>
#include <vector>

using namespace std;

unsigned long left_child(unsigned long i) {
    return 2 * i + 1;
}

unsigned long right_child(unsigned long i) {
    return 2 * i + 2;
}

bool invariant(unsigned long i, unsigned long size, vector<long> &v) {
    if (left_child(i) < size && right_child(i) < size) return v[i] <= v[left_child(i)] && v[i] <= v[right_child(i)];
    else if (left_child(i) < size) return v[i] <= v[left_child(i)];
    else return true;
}

vector<pair<int, int>> siftDown(unsigned long i, vector<long> &v) {
    vector<pair<int, int>> res;
    unsigned long max_index = i;
    while (i < v.size() && !invariant(i, v.size(), v)) {
        max_index = i;
        unsigned long l = left_child(i);
        if (l < v.size() && v[l] < v[max_index]) {
            max_index = l;
        }
        unsigned long r = right_child(i);
        if (r < v.size() && v[r] < v[max_index]) {
            max_index = r;
        }
        if (i != max_index) {
            int temp = v[i];
            v[i] = v[max_index];
            v[max_index] = temp;
            res.emplace_back(i, max_index);
            i = max_index;
        }
    }
    return res;
}

int main() {
    long n;
    cin >> n;
    vector<long> v(n);
    for (long i = 0; i < n; i++) {
        cin >> v[i];
    }
    vector<pair<int, int>> res;
    for (unsigned long i = (v.size())/ 2; i < numeric_limits<unsigned long>::max(); i--) {
        for (auto &x: siftDown(i, v)) {
            res.push_back(x);
        }
    }
    cout << res.size() << endl;
    for (auto &x: res) {
        cout << x.first << " " << x.second << endl;
    }

    return 0;
}

