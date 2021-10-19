#include <iostream>
#include <string>
#include <queue>
#include <sstream>
#include <iterator>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    int n;
    string input;
    priority_queue<int> pq;
    string EXTRACT_MAX("ExtractMax");
    stringstream ss;
    cin >> n;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        getline(cin, input);
        if (input.compare(EXTRACT_MAX)) {
            int index = input.find(" ");
            string num = input.substr(index, input.length() - index);
            int number;
            ss << num;
            ss >> number;
            ss.clear();
            pq.push(number);
        } else {
            cout << pq.top() << endl;
            pq.pop();
        }
    }
    
    return 0;
}
