import java.util.ArrayList;
import java.util.HashMap;

record Item(int weight, int value){}
record Pair(int capacity, int index){}

class Knapsack{
    private final HashMap<Pair, Integer> memo = new HashMap<>();

    int maximumValue(int capacity, ArrayList<Item> itemList){
        return knapsack(itemList, new Pair(capacity, itemList.size()));
    }

    int knapsack(ArrayList<Item> itemList, Pair pair) {
        if(pair.index() == 0 || pair.capacity() == 0) return 0;
        if (memo.containsKey(pair)) return memo.get(pair);

        var item = itemList.get(pair.index() - 1);
        if(item.weight() > pair.capacity()) {
            memo.put(pair, knapsack(itemList, new Pair(pair.capacity(), pair.index()-1)));
        } else {
            memo.put(pair, Math.max(
                    knapsack(itemList, new Pair(pair.capacity(), pair.index()-1)),
                    item.value() + knapsack(itemList, new Pair(pair.capacity() - item.weight(), pair.index()-1))));
        }
        return memo.get(pair);
    }
}