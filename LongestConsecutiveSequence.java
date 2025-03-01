//code 1 using hashset

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int maxLen = 0;

        for (int num : s) {
            if (!s.contains(num - 1)) { // Check if it's the start of a sequence
                int currentNum = num;
                int currentStreak = 1;

                while (s.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxLen = Math.max(maxLen, currentStreak);
            }
        }

        return maxLen;
    }
}

//code 2 using hashmap

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> d = new HashMap<>(); // HashMap to store sequence lengths
        int maxLen = 0;

        for (int num : nums) {
            if (!d.containsKey(num)) {
                int left = d.getOrDefault(num - 1, 0); // Length of left sequence
                int right = d.getOrDefault(num + 1, 0); // Length of right sequence
                int length = left + 1 + right; // Total sequence length

                d.put(num, length); // Store current number's sequence length
                d.put(num - left, length); // Update the start of the sequence
                d.put(num + right, length); // Update the end of the sequence

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }
}
