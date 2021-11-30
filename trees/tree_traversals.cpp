#include <iostream>
#include <vector>
#include <tuple>

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

    explicit Tree(Node &x) : root(x) {}

    void in_order(Node *node) {
        if (node == nullptr) return;
        else {
            in_order(node->left);
            cout << node->key << " ";
            in_order(node->right);
        }
    }

    void pre_order(Node *node) {
        if (node == nullptr) return;
        else {
            cout << node->key << " ";
            pre_order(node->left);
            pre_order(node->right);
        }
    }

    void post_order(Node *node) {
        if (node == nullptr) return;
        else {
            post_order(node->left);
            post_order(node->right);
            cout << node->key << " ";
        }
    }
};

int main() {
    int n;
    cin >> n;
    vector<tuple<long, long, long>> input(n);
    for (int i = 0; i < n; i++) {
        cin >> get<0>(input[i]);
        cin >> get<1>(input[i]);
        cin >> get<2>(input[i]);
    }

    Node *root = Node::build_tree(input, input[0]);
    Tree *tree = new Tree(*root);
    tree->in_order(root);
    cout << endl;
    tree->pre_order(root);
    cout << endl;
    tree->post_order(root);
    cout << endl;

    return 0;
}

