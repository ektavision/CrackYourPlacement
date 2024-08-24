class Solution {
    int n;
  Integer[] table;
  public int numDecodings(String s) {
      if (s.charAt(0) == '0') return 0;
      n = s.length();
      table = new Integer[n+1];
      table[0] = count(s.toCharArray(),0);
      return table[0]; 
  }
   private int count(char[] s, int index)
  {
      if (index == n) return table[index] = 1; 
      
      if (table[index] != null) return table[index]; 
      
      int curr;
      
      table[index] = 0;
      
      curr = s[index]-'0';
      if (curr != 0)
          table[index] += count(s,index+1); 
      else return table[index]; 
      
      if (index < n-1) 
      {
          curr = curr*10+s[index+1]-'0'; 
              table[index] += count(s,index+2);
      }
      
      return table[index];
  }
}