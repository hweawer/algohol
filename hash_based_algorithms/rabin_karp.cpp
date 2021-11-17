#include <iostream>
#include <random>
#include <string>
#include <stack>

long p = 1000000007;

using namespace std;

long oldest(long x, size_t power) {
    long res = 1;
    for (int i = 0 ; i < power; i++) {
        res = (res * x) % p;
    }
    return res;
}

long thash(string& s, long x) {
    long res = 0;
    long res_x = 1;
    for(int i = 0; i < s.size(); i++){
        res = (res + (s[i]*res_x) % p) % p;
        res_x = (res_x * x) % p;
    }
    return res % p;
}

int main() {
    string pattern, input;
    random_device rd;
    mt19937_64 eng(rd());
    uniform_int_distribution<long> distr(1, p - 1);
    long x = distr(eng);
    cin >> pattern >> input;
    long long old = oldest(x, pattern.size() - 1);
    long pattern_hash = thash(pattern, x);
    string init_substr = input.substr(input.size() - pattern.size(), pattern.size());
    long init_hash = thash(init_substr, x);
    vector<long long> hashes;
    hashes.push_back(init_hash);
    stack<int> res_ind;
    long long hash;
    for (long i = input.size() - pattern.size() - 1; i >= 0; i--) {
        hash = ((hashes.back() - ((long long)input[i + pattern.size()] * old) % p) % p * x  + (long long)input[i]) % p;
        hash = (hash + p) % p;
        hashes.push_back(hash);
    }
    for (int i = 0; i < hashes.size(); i++) {
        if (hashes[i] == pattern_hash) {
            string cmp_substr = input.substr(input.size() - pattern.size() - i, pattern.size());
            if (cmp_substr == pattern) {
                res_ind.push(input.size() - pattern.size() - i);
            }
        }
    }
    while (!res_ind.empty()) {
        cout << res_ind.top();
        res_ind.pop();
        if (!res_ind.empty()) {
            cout << " ";
        }
    }
    cout << endl;
    return 0;
}

