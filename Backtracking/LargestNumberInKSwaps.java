
class Solution
{
    public static String findMaximumNum(String str, int k)
        {
              int n = str.length();
            max = str.toCharArray();
            helper(str.toCharArray(), k, 0);
            return new String(max);
        }
        
    static char[] max;
    public static void helper(char[] ch, int k, int swap) {
        if(swap == k) {
            return;
        }
        
        for(int i=0; i<ch.length; i++) {
            for(int j=i+1; j<ch.length; j++) {
                if(Integer.valueOf(ch[i]) < Integer.valueOf(ch[j])) {
                    swap(ch, i, j);
                    check(ch);
                    helper(ch, k, swap+1);
                    swap(ch, i, j);
                }
            }
        }
    }
    
    public static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    
    private static void check(char[] arr) {
        int i = 0, n = arr.length;
        while(i < n && arr[i] == max[i]) {
            ++i;
        }
        
        if(i < n && arr[i] > max[i]) {
            while(i < n) max[i] = arr[i++];
        }
        }
}