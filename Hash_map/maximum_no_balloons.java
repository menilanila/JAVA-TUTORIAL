import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {
        String t = "balloon";
        HashMap<Character, Integer> map = new HashMap<>();

        // Count occurrences of characters in text that appear in "balloon"
        for (char ch : text.toCharArray()) {
            if (t.indexOf(ch) != -1) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        // Check if all required characters are present
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return 0;
            }
        }

        // Calculate the number of "balloon" words that can be formed
        return Math.min(
            Math.min(map.getOrDefault('b', 0), map.getOrDefault('a', 0)),
            Math.min(map.getOrDefault('l', 0) / 2, 
                     Math.min(map.getOrDefault('o', 0) / 2, map.getOrDefault('n', 0)))
        );
    }
}
