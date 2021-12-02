#include <iostream>
#include <tuple>

using namespace std;

template<class T>
class Node {
public:
    T key;
    Node<T> *parent;
    Node<T> *left;
    Node<T> *right;
    T sum;

    Node(T key, Node<T> *parent, Node<T> *left, Node<T> *right) : key(key), parent(parent), left(left), right(right),
                                                                  sum(key) {
    }

    Node(T key, Node<T> *left, Node<T> *right) : key(key), parent(nullptr), left(left), right(right), sum(key) {
    }

    Node(T key, Node<T> *left, Node<T> *right, T sum) : key(key), parent(nullptr), left(left), right(right), sum(sum) {
    }

    explicit Node(T key) : key(key), parent(nullptr), left(nullptr), right(nullptr), sum(key) {
    }
};

template<class T>
class SplayTree {
private:

    void set_parent(Node<T> *child, Node<T> *parent) {
        if (child != nullptr) {
            child->parent = parent;
        }
    }

    void keep_parent(Node<T> *v) {
        set_parent(v->left, v);
        set_parent(v->right, v);
        //v->sum = v->left->sum + v->right->sum + v->key;
    }

    void rotate(Node<T> *parent, Node<T> *child) {
        Node<T> *gparent = parent->parent;
        if (gparent != nullptr) {
            if (gparent->left == parent) {
                gparent->left = child;
            } else {
                gparent->right = child;
            }
            gparent->sum =
                    gparent->sum - (parent == nullptr ? 0 : parent->sum) + (child == nullptr ? 0 : child->sum);
        }

        if (parent->left == child) {
            parent->left = child->right;
            parent->sum =
                    parent->sum - (child == nullptr ? 0 : child->sum) +
                    (child == nullptr ? 0 : child->right == nullptr ? 0 : child->right->sum);
            if (child->right != nullptr) {
                child->sum -= child->right->sum;
            }
            child->right = parent;
            child->sum += parent->sum;
        } else {
            parent->right = child->left;
            parent->sum =
                    parent->sum - (child == nullptr ? 0 : child->sum) +
                    (child == nullptr ? 0 : child->left == nullptr ? 0 : child->left->sum);
            if (child->left != nullptr) {
                child->sum -= child->left->sum;
            }
            child->left = parent;
            child->sum += parent->sum;
        }
        if (gparent != nullptr) {
            gparent->sum += parent->sum;
        }
        keep_parent(child);
        keep_parent(parent);
        child->parent = gparent;
    }

    Node<T> *splay(Node<T> *u) {
        if (u->parent == nullptr) return u;
        Node<T> *parent = u->parent;
        Node<T> *gparent = parent->parent;
        if (gparent == nullptr) {
            rotate(parent, u);
            return u;
        } else {
            bool zigzig = (gparent->left == parent) == (parent->left == u);
            if (zigzig) {
                rotate(gparent, parent);
                rotate(parent, u);
            } else {
                rotate(parent, u);
                rotate(gparent, u);
            }
        }
        return splay(u);
    }

public:
    Node<T> *find(Node<T> *v, T key) {
        if (v == nullptr) {
            return nullptr;
        }
        if (key == v->key) {
            return splay(v);
        }
        if (key < v->key && v->left != nullptr) {
            return find(v->left, key);
        }
        if (key > v->key && v->right != nullptr) {
            return find(v->right, key);
        }
        return splay(v);
    }

    tuple<Node<T> *, Node<T> *> split(Node<T> *v, T key, bool save_eq) {
        if (v == nullptr) {
            return tuple<Node<T> *, Node<T> *>(nullptr, nullptr);
        }
        v = find(v, key);
        if (v->key == key && !save_eq) {
            set_parent(v->right, nullptr);
            set_parent(v->left, nullptr);
            if (v->right != nullptr) {
                v->sum -= v->right->sum;
            }
            if (v->left != nullptr) {
                v->sum -= v->left->sum;
            }
            return tuple<Node<T> *, Node<T> *>(v->left, v->right);
        }
        if (v->key == key && save_eq) {
            set_parent(v->right, nullptr);
            if (v->right != nullptr) {
                v->sum -= v->right->sum;
            }
            return tuple<Node<T> *, Node<T> *>(v, v->right);
        }
        if (v->key < key) {
            Node<T> *right = v->right;
            v->right = nullptr;
            if (right != nullptr) {
                v->sum -= right->sum;
            }
            set_parent(right, nullptr);
            return tuple<Node<T> *, Node<T> *>(v, right);
        } else {
            Node<T> *left = v->left;
            v->left = nullptr;
            if (left != nullptr) {
                v->sum -= left->sum;
            }
            set_parent(left, nullptr);
            return tuple<Node<T> *, Node<T> *>(left, v);
        }
    }

    Node<T> *insert(Node<T> *v, T key) {
        tuple<Node<T> *, Node<T> *> s_res = split(v, key, false);
        v = new Node<T>(key, get<0>(s_res), get<1>(s_res),
                        key + (get<0>(s_res) == nullptr ? 0 : get<0>(s_res)->sum) +
                        (get<1>(s_res) == nullptr ? 0 : get<1>(s_res)->sum));
        keep_parent(v);
        return v;
    }

    Node<T> *merge(Node<T> *left, Node<T> *right) {
        if (right == nullptr) return left;
        if (left == nullptr) return right;
        right = find(right, left->key);
        right->left = left;
        right->sum += (left == nullptr ? 0 : left->sum);
        left->parent = right;
        return right;
    }

    Node<T> *remove(Node<T> *root, T key) {
        root = find(root, key);
        if (root->key == key) {
            set_parent(root->left, nullptr);
            set_parent(root->right, nullptr);
            return merge(root->left, root->right);
        }
        return root;
    }

    T sum(Node<T> *root, T left, T right) {
        tuple<Node<T> *, Node<T> *> s1_res = split(root, left - 1, true);
        tuple<Node<T> *, Node<T> *> s2_res = split(get<1>(s1_res), right, true);
        T result = get<0>(s2_res)->sum;
        Node<T> *merge1 = merge(get<0>(s2_res), get<1>(s2_res));
        merge(get<0>(s1_res), merge1);
        return result;
    }
};

long f(long x, long last_s) {
    return (x + last_s) % 1000000001;
}


int main() {
    int n;
    long x, y;
    Node<long> *node = nullptr;
    auto *tree = new SplayTree<long>();
    long last_s = 0;
    cin >> n;
    char in;
    for (int i = 0; i < n; i++) {
        cin >> in;
        cin >> x;
        if (in == '+') {
            if (node == nullptr) {
                node = new Node<long>(f(x, last_s));
            } else {
                node = tree->insert(node, f(x, last_s));
            }
        } else if (in == '?') {
            if (node == nullptr) {
                cout << "Not found" << endl;
            } else {
                Node<long>* found = tree->find(node, f(x, last_s));
                if(found != nullptr) {
                    node = found;
                    if (node->key == f(x, last_s)) {
                        cout << "Found" << endl;
                    } else {
                        cout << "Not found" << endl;
                    }
                } else {
                    cout << "Not found" << endl;
                }
            }
        } else if (in == '-') {
            node = tree->remove(node, f(x, last_s));
        } else {
            cin >> y;
            last_s = tree->sum(node, f(x, last_s), f(y, last_s));
            cout << last_s << endl;
        }
    }
    return 0;
}
