#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>

using namespace std;

class StackBasedQueue {
private:
    stack<int> right;
    stack<int> left;

    stack<int> right_max;
    stack<int> left_max;

    void fromLeftToRight() {
        while (!left.empty()) {
            right.push(left.top());
            order_helper_stack(right_max, left.top());
            left_max.pop();
            left.pop();
        }
    }

    static void order_helper_stack(stack<int> &st, int x) {
        if (st.empty()) {
            st.push(x);
        } else {
            if (x >= st.top()) {
                st.push(x);
            } else {
                st.push(st.top());
            }
        }
    }

public:
    void push(int x) {
        left.push(x);
        order_helper_stack(left_max, x);
    }

    void pop() {
        if (right.empty()) {
            fromLeftToRight();
        }
        right.pop();
        right_max.pop();
    }

    int front() {
        if (right.empty()) {
            fromLeftToRight();
        }
        return right.top();
    }

    int max() {
        // both can't be empty
        if (right_max.empty()) {
            return left_max.top();
        } else if (left_max.empty()) {
            return right_max.top();
        } else {
            return std::max(left_max.top(), right_max.top());
        }
    }
};


int main() {
    int n, m, x;
    cin >> n;
    vector<int> input(n);
    vector<int> result;
    StackBasedQueue stq;
    for (int i = 0; i < n; i++) {
        cin >> x;
        input[i] = x;
    }
    cin >> m;
    //window initialization
    for (int i = 0; i < m; i++) {
        stq.push(input[i]);
    }
    result.push_back(stq.max());
    for (int i = m; i < n; i++) {
        stq.pop();
        stq.push(input[i]);
        result.push_back(stq.max());
    }

    for (auto &rx: result) {
        cout << rx << " ";
    }
    return 0;
}
