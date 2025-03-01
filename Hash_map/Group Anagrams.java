import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            
            m.putIfAbsent(sortedStr, new ArrayList<>());
            m.get(sortedStr).add(s);
        }
        
        return new ArrayList<>(m.values());
    }
}
