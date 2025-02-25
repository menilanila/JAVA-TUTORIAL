import java.util.HashMap;
import java.util.Map;

class Valid_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();

        for (char c : s.toCharArray()) {
            a.put(c, a.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            b.put(c, b.getOrDefault(c, 0) + 1);
        }

        return a.equals(b);
    }
}
