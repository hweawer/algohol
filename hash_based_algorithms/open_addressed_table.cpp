#include <vector>
#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

int main() {
    int n;
    string word, name;
    long number;
    string NONE("not found");
    unordered_map<long, string> map;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> word;
        if (word == "add") {
            cin >> number;
            cin >> name;
            map[number] = name;
        }
        else if (word == "find") {
            cin >> number;
            auto x = map.find(number);
            if (x == map.end()) {
                cout << NONE << endl;
            } else {
                cout << x->second << endl;
            }
        } else {
            cin >> number;
            map[number] = NONE;
        }
    }
    return 0;
}
