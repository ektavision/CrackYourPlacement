class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
            StringBuilder sb = new StringBuilder();
            for(int i = words.length - 1; i > 0; i--)
                sb.append(words[i] + " ");
            return sb.append(words[0]).toString();
    }
}