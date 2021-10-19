#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>

using Segment = std::pair<int, int>;

bool comp(Segment segment1, Segment segment2) {
    return segment1.second < segment2.second;
}

std::vector <int> get_covering_set(std::vector <Segment> segments) {
  std::vector <int> result;
  sort(segments.begin(), segments.end(), comp);
  // fix this function
  for (auto s : segments) {
    if (result.empty()) {
      result.push_back(s.second);    
    } else {
      int top = result.back();
      if (top >= s.first && top <= s.second) continue;
      else result.push_back(s.second);
    }
  }

  return result;
}

int main(void) {
  int segments_count;
  std::cin >> segments_count;
  std::vector <Segment> segments(segments_count);
  for (auto &s:segments) {
    std::cin >> s.first >> s.second;
  }

  auto points = get_covering_set(std::move(segments));
  std::cout << points.size() << std::endl;
  for (auto point:points) {
    std::cout << point << " ";
  }
  std::cout << std::endl;
}
