class Solution {
    public int characterReplacement(String s, int k) {
         char[] arr = s.toCharArray();
        int left = 0, right = 0, n = arr.length;
        
        Map<Character, Integer> hm = new HashMap<>();
                int maxLen = 0, mostFreq = 0;
                while(right < n){
            hm.put(arr[right], hm.getOrDefault(arr[right], 0) + 1);
            mostFreq = Math.max(mostFreq, hm.get(arr[right]));
                        if((right - left + 1) - mostFreq > k){
                hm.put(arr[left], hm.get(arr[left]) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}