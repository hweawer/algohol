#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    long W, n, x;
    cin >> W;
    cin >> n;
    vector<long> weights;
    for (long i = 0; i < n; i++) {
        cin >> x;
        weights.push_back(x);
    }
    vector<vector<long>> D(W + 1, vector<long>(n+1));
    for (long w = 0; w <= W; w++) {
        D[w][0] = 0;
    }
    for (long i = 0; i <= n; i++) {
        D[0][i] = 0;
    }
    for (long i = 1; i <= n; i++) {
        for(long w = 1; w <= W; w++) {
            D[w][i] = D[w][i - 1];
            if (weights[i - 1] <= w) {
                D[w][i] = max(D[w][i], D[w - weights[i - 1]][i - 1] + weights[i - 1]);
            }
        }
    }
    cout << D[W][n] << endl;
    return 0;
}
