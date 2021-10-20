#include <iostream>
#include <vector>
#include <queue>
#include <utility>

using namespace std;

int tree_height(pair<int, vector<vector<int>>>& ind_tree) {
    int root_idx = ind_tree.first;
    vector<vector<int>> tree = ind_tree.second;
    queue<int> current_roots;
    queue<int> future_roots;
    current_roots.push(root_idx);
    int res = 0;
    while(!current_roots.empty()) {
        while(!current_roots.empty()) {
            int first = current_roots.front();
            for(int & i : tree[first]) {
                future_roots.push(i);
            }
            current_roots.pop();
        }
        res++;
        current_roots = future_roots;
        future_roots = queue<int>();
    }
    return res;
}

pair<int, vector<vector<int>>> list_tree(vector<int>& tree) {
    vector<vector<int>> A(tree.size(), vector<int>());
    pair<int, vector<vector<int>>> result = pair<int, vector<vector<int>>>(0, A);
    for(int i = 0; i < tree.size(); i++) {
        if (tree[i] == -1) {
            result.first = i;
        } else {
            result.second[tree[i]].push_back(i);
        }
    }
    return result;
}

int main(void) {
    int size;
    cin >> size;
    vector<int> input(size);
    for(int i = 0; i < size; i++) {
        cin >> input[i];
    }
    pair<int, vector<vector<int>>> ind_tree_pair = list_tree(input);
    cout << tree_height(ind_tree_pair);
    return 0;
}