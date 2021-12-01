#include <iostream>
#include <tuple>
#include <vector>
#include <cmath>

using namespace std;

class Node {
public:
    long key;
    Node *left;
    Node *right;

    Node(long key, Node *left, Node *right) : key(key), left(left), right(right) {
    }

    explicit Node(long key) : key(key), left(nullptr), right(nullptr) {
    }

    static Node *build_tree(vector<tuple<long, long, long>> &nodes_desc, tuple<long, long, long> &root) {
        if (get<1>(root) == -1 && get<2>(root) == -1) {
            return new Node(get<0>(root));
        } else if (get<1>(root) == -1) {
            return new Node(get<0>(root), nullptr,
                            build_tree(nodes_desc, nodes_desc[get<2>(root)]));
        } else if (get<2>(root) == -1) {
            return new Node(get<0>(root), build_tree(nodes_desc, nodes_desc[get<1>(root)]),
                            nullptr);
        } else {
            return new Node(get<0>(root), build_tree(nodes_desc, nodes_desc[get<1>(root)]),
                            build_tree(nodes_desc, nodes_desc[get<2>(root)]));
        }
    }
};

bool check(Node *node, long min, long max) {
    return node == nullptr ||
           min <= node->key && node->key <= max && check(node->left, min, node->key - 1) &&
           check(node->right, node->key, max);
}

int main() {
    int n;
    cin >> n;
    if (n == 0) {
        cout << "CORRECT" << endl;
        return 0;
    }
    vector<tuple<long, long, long>> input(n);
    for (int i = 0; i < n; i++) {
        cin >> get<0>(input[i]);
        cin >> get<1>(input[i]);
        cin >> get<2>(input[i]);
    }
    Node *root = Node::build_tree(input, input[0]);
    if (check(root, static_cast<long>(pow(static_cast<double>(-2), 31)),
              static_cast<long>(pow(static_cast<double>(2), 31)) - 1)) {
        cout << "CORRECT" << endl;
    } else {
        cout << "INCORRECT" << endl;
    }

    return 0;
}
