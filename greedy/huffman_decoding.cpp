#include <iostream>
#include <map>
#include <string>
#include <typeinfo>
#include <vector>

using namespace std;

vector<string> startsWith(string pref, vector<string> words) {
    vector<string> result;
    for (auto it = words.cbegin(); it != words.cend(); it++) {
        if ((*it).rfind(pref, 0) == 0) {
            result.push_back(*it);
        }
    }
    return result;
}

int main() {
    int k, l;
    char key;
    string value;
    string encodedString;
    map<string, char> dict;
    vector<string> keys;
    cin >> k >> l;
    cin.ignore();
    for (int i = 0; i < k; i++) {
        cin >> key;
        getline(cin, value);
        value = value.substr(2, value.length() - 2);
        keys.push_back(value);
        dict[value] = key;
    }
    getline(cin, encodedString);
    string resultString;
    string acc;
    for (int i = 0; i < encodedString.length(); i++) {
        acc.push_back(encodedString[i]);
        vector<string> starts = startsWith(acc, keys);
        if (starts.size() == 1) {
            resultString.push_back(dict[acc]);
            acc = "";
        }
    }
    cout << resultString << endl;
    return 0;
}
