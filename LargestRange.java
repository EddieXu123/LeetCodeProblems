import java.util.*;

class LargestRange {
  public static int[] largestRange(int[] array) {
		int range = 0;
		int maxRange = 0;
		int left = 0;
		int right = 0;
		int[] ans = new int[2];
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int num : array) {
			map.put(num, true);
		}
		
		for (int num : array) {
			if (!map.get(num)) {
				continue;
			}
			map.put(num, false);
			range = 1;
			left = num - 1;
			right = num + 1;
			
			while (map.containsKey(left)) {
				map.put(left, false);
				left--;
				range++;
			}
			
			while (map.containsKey(right)) {
				map.put(right, false);
				right++;
				range++;
			}
			
			if (range > maxRange) {
				maxRange = range;
				ans = new int[] {left + 1, right - 1};
			}
		}
		
    return ans;
  }
}
