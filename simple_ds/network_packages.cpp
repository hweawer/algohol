#include <queue>
#include <iostream>

using namespace std;

int main() {
    int size, n;
    int start, exec;
    cin >> size;
    cin >> n;
    queue<int> buffer;
    for (int i = 0; i < n; i++) {
        cin >> start;
        cin >> exec;
        if (buffer.size() < size) {
            if (buffer.empty()) {
                buffer.push(start + exec);
                cout << start << endl;
            }
            else {
                cout << std::max(start, buffer.back()) << endl;
                buffer.push(buffer.back() + exec);
            }
        } else {
            if (start < buffer.front()) cout << -1 << endl;
            else {
                buffer.pop();
                if (buffer.empty()) {
                    cout << start << endl;
                } else {
                    cout << std::max(start, buffer.back()) << endl;
                }
                buffer.push(std::max(start, buffer.back()) + exec);
            }
        }
    }
    return 0;
}
