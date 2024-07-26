
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
         if (string_list == null || string_list.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String word : string_list) {
            String currMap = countCharacter(word);
            map.computeIfAbsent(currMap, x -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
    
    public String countCharacter(String str) {
        int[] map = new int[26];
        for (char c : str.toCharArray()) {
            map[c - 'a']++;
        }
        return Arrays.toString(map);
    }
}
