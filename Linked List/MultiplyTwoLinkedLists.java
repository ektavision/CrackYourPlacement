
class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
         
          long mod = 1000000007;
          long n1 = 0;
          long n2 = 0;
          
          while(first != null) {
              n1 = ((n1*10) + first.data) % mod;
              first = first.next;
          }
          while(second != null) {
              n2 = ((n2*10) + second.data) % mod;
              second = second.next;
          }
          return (n1 * n2) % mod;
    }
}