class Solution {
    public boolean isNumber(String s) {
          s = s.trim();
        int eSignIndex = -1;
        boolean digitsBeforeESign = false;
        boolean digitsAfterESign = false;
        boolean dotSign = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                if (!(i == 0 || eSignIndex != -1 && i == eSignIndex + 1)) {
                    return false;
                }
            } else if (ch == '.') {
                if (dotSign || eSignIndex != -1) {
                    return false;
                }
                dotSign = true;
            } else if (ch == 'e' || ch == 'E') {
              
                if (eSignIndex != -1 || !digitsBeforeESign) {
                    return false;
                }
                eSignIndex = i;
            } else if (Character.isDigit(ch)) {
                if (eSignIndex != -1) {
                    digitsAfterESign = true;
                } else {
                    digitsBeforeESign = true;
                }
            } else {
                return false;
            }
        }
        return (digitsBeforeESign) && (eSignIndex != -1 ? digitsAfterESign : true);
    }
}