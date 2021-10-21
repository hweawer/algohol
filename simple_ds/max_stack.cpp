#include <iostream>
#include <stack>

using namespace std;

int main() {
    stack<int> regular, max;
    int n, op;
    string input;
    string POP("pop");
    string MAX("max");
    string PUSH("push");
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        if (input == PUSH) {
            cin >> op;
            regular.push(op);
            if (max.empty()) {
                max.push(op);
            } else {
                if (max.top() >= op) {
                    max.push(max.top());
                } else {
                    max.push(op);
                }
            }
        }
        else if (input == MAX) {
            cout << max.top() << endl;
        }
        else if (input == POP) {
            regular.pop();
            max.pop();
        }
    }
    return 0;
}
