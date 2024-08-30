class Solution {
    public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backtrace(s, result, new ArrayList<String>(), 0);
        return result;
    }
        public static void backtrace(String s, List<List<String>> result, List<String> list, int index){ 
        if(index == s.length()) result.add(new ArrayList<String>(list));
        else{
            for(int i = index + 1; i <= s.length(); i++){
                String sub = s.substring(index, i);
                if(isPalindrome(sub)){
                    list.add(sub);
                    backtrace(s, result, list, i);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    private static boolean isPalindrome(String s){
        int len = s.length();
        if(len == 0 || len == 1) return true;
        int half = len / 2;
        int low = -1, high = len;
        while(++low < len && --high >= 0 && low <= high){
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);
            if(c1 != c2) return false;
        }
        return true;
    }
}