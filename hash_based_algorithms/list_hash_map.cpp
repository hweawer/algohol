#include <vector>
#include <iostream>
#include <string>
#include <list>

using namespace std;

long p = 1000000007;
long x = 263;

long thash(string &s, long m) {
    long res = 0;
    long step_x = 1;
    for (char i : s) {
        res = res + ((i * step_x) % p);
        step_x = (step_x * x) % p;
    }
    return (res % p) % m;
}

bool findH(vector<list<string>> &table, string &elem, long m, long h) {
    if (table[h].empty()) return false;
    else {
        for (auto &it : table[h]) {
            if (it == elem) return true;
        }
        return false;
    }
}

bool find(vector<list<string>> &table, string &elem, long m) {
    return findH(table, elem, m, thash(elem, m));
}

void add(vector<list<string>> &table, string &elem, long m) {
    long h = thash(elem, m);
    if (findH(table, elem, m, h)) return;
    else table[h].push_front(elem);
}

void del(vector<list<string>> &table, string &elem, long m) {
    long h = thash(elem, m);
    if (table[h].empty()) return;
    else table[h].remove(elem);
}


int main() {
    int n, m, l;
    string cmd, input;
    cin >> m;
    cin >> n;
    vector<list<string>> table(m, list<string>());
    for (int i = 0; i < n; i++) {
        cin >> cmd;
        if (cmd == "add") {
            cin >> input;
            add(table, input, m);
        } else if (cmd == "find") {
            cin >> input;
            if (find(table, input, m)) cout << "yes" << endl;
            else cout << "no" << endl;
        } else if (cmd == "del") {
            cin >> input;
            del(table, input, m);
        } else {
            cin >> l;
            if (table[l].empty()) cout << endl;
            else {
                for(auto &it : table[l]) {
                    cout << it << " ";
                }
                cout << endl;
            }
        }
    }


    return 0;
}

