class InsertRemoveRandomO1 {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size()); // The map represents the arraylist but we can do stuff in constant time. The key is the value and the index is where it will be once we add it to the arrayList
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val); // We want to get where this value is in our list
            list.set(index, list.get(list.size() - 1)); // Overwrite the index of the value with the last element of our list so we can then delete the last element of our list in O(1)
            map.put(list.get(index), index); // Updates the last element that was placed in the index position in the map
            map.remove(val); // Now, I can remove the val (which is at the last index of the list)
            list.remove(list.size() - 1); // Remove the last index of the original list (which was now replaced to be at index)
            return true;
        }
        
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
