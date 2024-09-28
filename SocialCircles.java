public class SocialCircles {

  public List<Set<String>> getSocialCircles(List<Pair<String, String>> interactions) {
    List<Set<String>> socialCircles = new ArrayList<>();
    Map<String, Set<String>> groups = new HashMap<>();

    for (Pair<String, String> friendship : interactions) {
      String person1 = friendship.getKey();
      String person2 = friendship.getValue();
      groups.putIfAbsent(person1, k -> new HashSet<>()).add(person2);
      groups.putIfAbsent(person2, k -> new HashSet<>()).add(person1);
    }

    Set<String> visited = new HashSet<>();
    for (String person : groups.keySet()) {
      if (!visited.contains(person)) {
        Set<String> circle = new HashSet<>();
        dfs(visited, circle, person, groups);
        socialCircles.add(circle);
      }
    }

    return socialCircles;
  }

  private void dfs(Set<String> visited, Set<String> circle, String person, Map<String, Set<String>> groups) {
    circle.add(person);
    visited.add(person);
    for (String friend : groups.get(person)) {
      if (!visited.contains(friend) {
        dfs(visited, circle, friend, groups);
      }
    }
  }

  class Pair<K,V> {
    private K key;
    private V value;

    Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return this.key;
    }

    public V getValue() {
      return this.value
    }
  }
}
