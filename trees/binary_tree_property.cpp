#include <iostream>
#include <tuple>
#include <vector>

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

class Tree {
public:
    Node &root;
    bool correctness = true;
    Node *last = nullptr;

    explicit Tree(Node &x) : root(x) {}

    void in_order(Node *node) {
        if (node == nullptr) return;
        else {
            in_order(node->left);
            if (last == nullptr) {
                last = node;
            } else {
                if (last->key >= node->key) {
                    correctness = false;
                    return;
                }
                last = node;
            }
            in_order(node->right);
        }
    }
};


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
    Tree *tree = new Tree(*root);
    tree->in_order(root);
    if (tree->correctness) {
        cout << "CORRECT" << endl;
    } else {
        cout << "INCORRECT" << endl;
    }

    return 0;
}

