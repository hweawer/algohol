#include <cassert>
#include <cstdint>
#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

struct Item final {
  double weight;
  double value;
};
	
bool comp (Item item1, Item item2) {
   return (item1.value / item1.weight) > (item2.value / item2.weight);
}

double get_max_knapsack_value(double capacity, std::vector <Item> items) {
  double value = 0.0;
  if (capacity == 0) return value;
  sort(items.begin(), items.end(), comp);

  // take items while there is empty space in knapsack
  for (auto &item:items) {
    if (capacity > item.weight) {
      // can take full item and continue
      capacity -= item.weight;
      value += item.value;
    } else {
      value += item.value * (static_cast <double>(capacity) / item.weight);
      break;
    }
  }

  return value;
}

int main(void) {
  int number_of_items;
  int knapsack_capacity;
  std::cin >> number_of_items >> knapsack_capacity;
  std::vector <Item> items(number_of_items);
  for (int i = 0; i < number_of_items; i++) {
    std::cin >> items[i].value >> items[i].weight;
  }

  double max_knapsack_value = get_max_knapsack_value(static_cast <double>(knapsack_capacity), std::move(items));

  std::cout.precision(10);
  std::cout << max_knapsack_value << std::endl;
  return 0;
}
