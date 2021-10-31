#include <iostream>
#include <utility>
#include <vector>

using namespace std;

class DisjoinedSet {
private:
    vector<long> parent;
    vector<long> rank;

public:

    explicit DisjoinedSet(long n) : parent(n), rank(n) {}

    void make_set(long x) {
        parent[x] = x;
        rank[x] = 0;
    }

    long find(long x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void _union(long i, long j) {
        long i_id = find(i);
        long j_id = find(j);
        if (i_id == j_id) return;
        if (rank[i_id] > rank[j_id]) {
            parent[j_id] = i_id;
        } else {
            parent[i_id] = j_id;
            if (rank[i_id] == rank[j_id]) {
                rank[j_id]++;
            }
        }
    }
};

int main() {
    long n, e, d, i, j;
    cin >> n;
    cin >> e;
    cin >> d;
    DisjoinedSet ds(n);
    for (long k = 0; k < n; k++) {
        ds.make_set(k);
    }
    for (long k = 0; k < e; k++) {
        cin >> i;
        cin >> j;
        ds._union(i - 1, j - 1);
    }
    for (long k = 0; k < d; k++) {
        cin >> i;
        cin >> j;
        if (ds.find(i - 1) == ds.find(j - 1)) {
            cout << 0 << endl;
            return 0;
        }
    }
    cout << 1 << endl;

    return 0;
}