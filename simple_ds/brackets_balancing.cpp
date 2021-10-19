#include <iostream>
#include <iterator>
#include <string>
#include <stack>

using namespace std;

// ([](){([])})
// ()[]}
// {{[()]]

int main(void) {
    stack<pair<int, char>> st;
    string input;
    cin >> input;
    int i = 0;
    for (; i < input.size(); i++) {
        char c = input[i];
        if (c == '[' || c == '(' || c == '{') {
            st.push(pair<int, char>(i, c));
        } else if (c == ']') {
            if (st.empty() || st.top().second != '[') {
                cout << i + 1 << endl;
                return 0;
            }
            else {
                st.pop();
            }
        } else if (c == ')') {
            if (st.empty() || st.top().second != '(') {
                cout << i + 1 << endl;
                return 0;
            }
            else {
                st.pop();
            }
        } else if (c == '}') {
            if (st.empty() || st.top().second != '{') {
                cout << i + 1 << endl;
                return 0;
            }
            else {
                st.pop();
            }
        }
    }
    if (st.empty()) {
        cout << "Success" << endl;
    } else {
        cout << st.top().first + 1 << endl;
    }
    return 0;
}