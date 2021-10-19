#include <iostream>
#include <map>
#include <string>
#include <iterator>
#include <algorithm>
#include <queue>
#include <utility>
#include <functional>

using namespace std;

map<string, int> frequencyMap(string codeString) {
    map<string, int> frequency;
    int length = codeString.size();
    for (int i = 0; i < length; i++) {
        string key;
        key.push_back(codeString[i]);
        if (frequency.find(key) == frequency.end()) {
            frequency[key] = 1;
        }
        else {
            frequency[key]++;
        }
    }
    return frequency;
}

bool Compare(pair<string, int> pair1, pair<string, int> pair2)
{
    return pair1.second > pair2.second;
}


vector<pair<string, char>> huffman(map<string, int> freq) {
    vector<pair<string,int>> huffmanArray(freq.size());
    copy(freq.begin(), freq.end(), huffmanArray.begin());
    priority_queue<pair<string, int>, vector<pair<string, int>>, function<bool(pair<string, int>, pair<string, int>)>> pq(Compare);
    for (auto it = huffmanArray.cbegin(); it != huffmanArray.cend(); ++it) {
        pq.push(*it);
    }
    vector<pair<string, char>> result;
    if (pq.size() == 1) {
        pair<string, int> elem = pq.top();
        pq.pop();
        pair<string, char> resultingPair;
        resultingPair.first = elem.first;
        resultingPair.second = '0';
        result.push_back(resultingPair);
    }
    while(pq.size() > 1) {
        pair<string, int> elem1 = pq.top();
        pq.pop();
        pair<string, int> elem2 = pq.top();
        pq.pop();
        pair<string, char> pair1 = make_pair(elem1.first, '0');
        pair<string, char> pair2 = make_pair(elem2.first, '1');
        result.push_back(pair1);
        result.push_back(pair2);
        pair<string, int> newPqPair = make_pair(elem1.first + elem2.first, elem1.second + elem2.second);
        pq.push(newPqPair);
    }
    return result;
}

int main() {
    string codeString;
    string resultString;
    cin >> codeString;
    map<string, int> frequency = frequencyMap(codeString);
    
    std::vector<char> keys;
    for(std::map<string,int>::iterator it = frequency.begin(); it != frequency.end(); ++it) {
      keys.push_back(it->first[0]);
    }
    vector<pair<string, char>> huffmanVector = huffman(frequency);
    map<char, string> charCodes;
    
    for(auto it = keys.cbegin(); it != keys.cend(); ++it)
    {
        string keyCode;
        for(auto itv = huffmanVector.cbegin(); itv != huffmanVector.cend(); ++itv) {
            string elem = itv->first;
            if (elem.find(*it) != string::npos) {
                keyCode.insert(0, 1, itv->second);
            }
        }
        charCodes[*it] = keyCode;
    }
    
    for(char& c : codeString) {
        resultString += charCodes[c];
    }
    
    cout << frequency.size() << " " << resultString.length() << endl;
    
    for(auto it = charCodes.cbegin(); it != charCodes.cend(); ++it) {
        cout << it->first << ": " << it->second << endl;
    }
    
    cout << resultString << endl;
    return 0;
}
