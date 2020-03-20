/*
 * Finding all duplicates in an array in linear time
 * @author Eddie Xu
 */
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class FindDuplicates {
  public static List<Integer> findDuplicates(int[] arr) {
    List<Integer> list = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
      
      /* Line 14 follows the same idea as:
      
      if (map.get(arr[i]) != null) {
        map.put(arr[i], map.get(arr[i]) + 1);
      }
      else {
        map.put(arr[i], 1);
      }
      
      */
      
    }
    
    for (int i : map.keySet()) {
      if (map.get(i) != 1) {
        list.add(i);
      }
    }
    return list;
  }
  
  public static void main(String[] args) {
    int[] arr = {-3, -2, -2, 1, 3, 3, 5, 5, 8, 9, 10, 10};
    System.out.println(findDuplicates(arr));
  }
}
