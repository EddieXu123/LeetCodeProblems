/*
 * Sorting a string based on the frequency of its characters
 * 
 * Basic idea: I want to first sort the characters from most frequent to least frequent using a HashMap and a PriorityQueue
 * Then, I will remove the elements from the queue and append it to my StringBuilder
 */

import java.util.*;

public class SortingCharactersByFreq {
	
	public static String sortingFreq(String s) {
		// If no String, return ""
		if (s == null) {
			return "";
		}
		
		// StringBuilder I will use to build my output String
		StringBuilder b = new StringBuilder();
		// HashMap used to store the characters and how often they appear
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1); 
			/*
			 * This code does the same as: 
			 * 
			if (map.get(s.charAt(i)) != null) {
               	map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
			 */
		}
		
		// PriorityQueue with more frequent character having first priority in queue
		PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
		
		// Adding each character into our queue
		for (char c : map.keySet()) {
			pq.add(c);
		}
		
		// Building our String
		while (!pq.isEmpty()) {
			char c = pq.remove();
			// The count is how frequent that character appears
			int count = map.get(c);
			
			for (int i = 0; i < count; i++) {
				b.append(c);
			}
		}
		return b.toString();
	}

	public static void main(String[] args) {
		System.out.println(sortingFreq("Hello")); // returns "lleoH"
    System.out.println(sortingFreq("testtesttest")); // returns "tttttteeesss"
	}
}


// p
