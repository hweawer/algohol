#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

class DisjoinedSet {
private:
    vector<long> parent;
    vector<long> rank;
    vector<long> sizes;

public:
    long max;

    explicit DisjoinedSet(long n) : parent(n), rank(n), sizes(n) {}

    void make_set(long x, long size) {
        parent[x] = x;
        rank[x] = 0;
        sizes[x] = size;
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
        parent[j_id] = i_id;
        sizes[i_id] += sizes[j_id];
        if (sizes[i_id] > max) {
            max = sizes[i_id];
        }
        if (rank[i_id] > rank[j_id]) {
            parent[j_id] = i_id;
            sizes[i_id] += sizes[j_id];
            if (sizes[i_id] > max) {
                max = sizes[i_id];
            }
        } else {
            parent[i_id] = j_id;
            sizes[j_id] += sizes[i_id];
            if (sizes[j_id] > max) {
                max = sizes[j_id];
            }
            if (rank[i_id] == rank[j_id]) {
                rank[j_id]++;
            }
        }
    }

    long max_size() {
        return *max_element(std::begin(sizes), std::end(sizes));
    }

};

int main() {
    int n, m;
    cin >> n;
    cin >> m;
    long destination, source;
    long size;
    DisjoinedSet disjoinedSet(n);
    for (int i = 0; i < n; i++) {
        cin >> size;
        disjoinedSet.make_set(i, size);
    }
    disjoinedSet.max = disjoinedSet.max_size();
    for (int i = 0; i < m; i++) {
        cin >> destination;
        cin >> source;
        disjoinedSet._union(destination - 1, source - 1);
        cout << disjoinedSet.max << endl;
    }

}
