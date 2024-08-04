class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getActual(s).equals(getActual(t));
    }
     private String getActual(String input) {

    StringBuilder actualString = new StringBuilder();
    int hashCount = 0;

    for (int i = input.length() - 1; i >= 0 ; i--) {

      if (input.charAt(i) == '#') {
        hashCount++;
        continue;
      }
      if (hashCount > 0) {
        hashCount--;
      } else {
        actualString.insert(0, input.charAt(i));
      }
    }

    return actualString.toString();
     }
}