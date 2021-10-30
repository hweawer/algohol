#include <iostream>
#include <functional>
#include <queue>
#include <vector>
#include <utility>

using namespace std;

int main() {
    auto lambda = [](pair<int, long> left, pair<int, long> right) {
        if (left.second == right.second) return left.first > right.first;
        else return left.second > right.second;
    };

    int n, m;
    long x;
    cin >> n;
    vector<pair<int, long>> v;
    cin >> m;
    for (int i = 0; i < n; i++) {
        pair<int, long> p(i, 0);
        v.push_back(p);
    }
    priority_queue<pair<int, long>, vector<pair<int, long>>, decltype(lambda)> pq(lambda, v);
    for (int i = 0; i < m; i++) {
        cin >> x;
        pair<int, long> top = pq.top();
        cout << top.first << " " << top.second << endl;
        pair<int, long> new_p = pair<int, long>(top.first, top.second + x);
        pq.pop();
        pq.push(new_p);
    }
    return 0;
}
